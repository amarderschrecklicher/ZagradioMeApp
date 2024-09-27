import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:geolocator/geolocator.dart';
import 'package:image_picker/image_picker.dart';
import 'dart:io';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final TextEditingController _controller = TextEditingController();
  bool _isButtonEnabled = false;
  LatLng? _pickedLocation;
  GoogleMapController? _mapController;
  LatLng _initialLocation = const LatLng(0, 0);
  File? _imageFile;

  @override
  void initState() {
    super.initState();
    _controller.addListener(_validateInput);
    _determinePosition();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  void _validateInput() {
    final input = _controller.text;
    // Regular expression for pattern: 3 characters, comma, number, comma, 3 characters
    final regExp = RegExp(r'^[A-Za-z]{3}\d[A-Za-z]{3}$');
    setState(() {
      _isButtonEnabled = regExp.hasMatch(input);
    });
  }

  Future<void> _determinePosition() async {
    bool serviceEnabled;
    LocationPermission permission;

    serviceEnabled = await Geolocator.isLocationServiceEnabled();
    if (!serviceEnabled) {
      return; // Location services are not enabled
    }

    permission = await Geolocator.checkPermission();
    if (permission == LocationPermission.denied) {
      permission = await Geolocator.requestPermission();
      if (permission == LocationPermission.denied) {
        return; // Permissions are denied
      }
    }

    if (permission == LocationPermission.deniedForever) {
      return; // Permissions are denied forever
    }

    Position position = await Geolocator.getCurrentPosition();
    setState(() {
      _initialLocation = LatLng(position.latitude, position.longitude);
      _pickedLocation = _initialLocation;
    });
  }

  void _onMapTap(LatLng position) {
    setState(() {
      _pickedLocation = position;
    });
  }

  Future<void> _pickImage(ImageSource source) async {
    final picker = ImagePicker();
    final pickedFile = await picker.pickImage(source: source);

    if (pickedFile != null) {
      setState(() {
        _imageFile = File(pickedFile.path);
        _validateInput();
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Padding(
      padding: const EdgeInsets.all(36.0),
      child: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Icon(Icons.logout),
                style: ElevatedButton.styleFrom(
                  foregroundColor: Colors.blue,
                  textStyle: TextStyle(fontSize: 18),
                ),
              ),
            ),
            const SizedBox(height: 20),
            const Text(
              'ZagradioMe',
              style: TextStyle(fontSize: 32.0, fontWeight: FontWeight.bold),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 40),
            TextFormField(
              controller: _controller,
              maxLength: 7,
              inputFormatters: [
                FilteringTextInputFormatter.allow(RegExp(r'[A-Za-z0-9]')),
              ],
              decoration: const InputDecoration(
                labelText: 'Unsite registarske table',
                border: OutlineInputBorder(),
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 10),
            TextFormField(
              decoration: const InputDecoration(
                labelText: 'Unsite opis',
                border: OutlineInputBorder(),
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 20),
            SizedBox(
              height: 400,
              child: _initialLocation.latitude != 0
                  ? GoogleMap(
                      initialCameraPosition: CameraPosition(
                        target: _initialLocation,
                        zoom: 14.0,
                      ),
                      onMapCreated: (controller) {
                        _mapController = controller;
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
            ),
            const SizedBox(height: 20),
            if (_imageFile != null)
              SizedBox(
                height: 150,
                child: Image.file(_imageFile!),
              ),
            const SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                ElevatedButton.icon(
                  onPressed: () => _pickImage(ImageSource.camera),
                  icon: const Icon(Icons.camera),
                  label: const Text('Take Photo'),
                ),
                ElevatedButton.icon(
                  onPressed: () => _pickImage(ImageSource.gallery),
                  icon: const Icon(Icons.image),
                  label: const Text('Upload Photo'),
                ),
              ],
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: _isButtonEnabled
                  ? () {
                      print('Search initiated');
                    }
                  : null,
              child: const Text('Prijavi'),
              style: ElevatedButton.styleFrom(
                backgroundColor: _isButtonEnabled ? Colors.blue : Colors.grey,
                foregroundColor: Colors.white,
                textStyle: const TextStyle(fontSize: 18),
              ),
            ),
          ],
        ),
      ),
    ));
  }
}
