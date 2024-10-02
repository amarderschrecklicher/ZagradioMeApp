import 'dart:async';
import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:geolocator/geolocator.dart';
import 'package:permission_handler/permission_handler.dart';

class MapsWidget extends StatefulWidget {
  const MapsWidget({super.key});

  @override
  State<MapsWidget> createState() => MapSampleState();
}

class MapSampleState extends State<MapsWidget> {
  LatLng? _pickedLocation;
  final Completer<GoogleMapController> _mapController =
      Completer<GoogleMapController>();

  LatLng _initialLocation = const LatLng(0, 0);

  @override
  void initState() {
    super.initState();
    _determinePosition();
  }

Future<void> _determinePosition() async {
  bool serviceEnabled;
  LocationPermission permission;

  // Check if location services are enabled
  serviceEnabled = await Geolocator.isLocationServiceEnabled();
  if (!serviceEnabled) {
    // Handle the case where the service is not enabled (e.g., show a message or redirect the user)
    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
      content: Text('Location services are disabled. Please enable them.'),
    ));
    return;
  }

  // Check for location permissions
  permission = await Geolocator.checkPermission();
  if (permission == LocationPermission.denied || permission == LocationPermission.deniedForever) {
    permission = await Geolocator.requestPermission();
    if (permission == LocationPermission.denied) {
      // Permissions are denied, handle this case
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
        content: Text('Location permissions are denied.'),
      ));
      return;
    } else if (permission == LocationPermission.deniedForever) {
      // Permissions are denied forever, handle this case
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
        content: Text('Location permissions are permanently denied. Please enable them in settings.'),
      ));
      return;
    }
  }

  // If everything is okay, get the position
  Position position = await Geolocator.getCurrentPosition();
  setState(() {
    _initialLocation = LatLng(position.latitude, position.longitude);
    _pickedLocation = _initialLocation;
  });
}


  Future<void> _checkLocationPermission() async {
    var status = await Permission.location.status;
    if (status.isDenied || status.isPermanentlyDenied) {
      // Request permission if not granted
      await Permission.location.request();
    }
    if (await Permission.location.isGranted) {
      _determinePosition(); // Call your method to get location and load the map
    }
  }

  void _onMapTap(LatLng position) {
    setState(() {
      _pickedLocation = position;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _initialLocation.latitude != 0
          ? GoogleMap(
              initialCameraPosition: CameraPosition(
                target: _initialLocation,
                zoom: 14.0,
              ),
              onMapCreated: (GoogleMapController controller) {
                _mapController.complete(controller);
              },
              markers: {
                Marker(
                  markerId: const MarkerId("pickedLocation"),
                  position: _pickedLocation ?? _initialLocation,
                  draggable: true,
                  onDragEnd: (newPosition) {
                    setState(() {
                      _pickedLocation = newPosition;
                    });
                  },
                )
              },
              onTap: _onMapTap,
            )
          : const Center(child: CircularProgressIndicator()),
    );
  }
}
