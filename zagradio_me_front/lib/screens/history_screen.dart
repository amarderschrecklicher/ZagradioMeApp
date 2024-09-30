import 'package:flutter/material.dart';
import 'package:zagradio_me/components/history_card.dart';

class HistoryScreen extends StatelessWidget {
final List<Map<String, dynamic>> historyReports = [
    {
      'plateNumber': 'ABC123',
      'description': 'Blocked a driveway',
      'date': DateTime.now().subtract(const Duration(days: 1)),
      'status': 'finished', // Report status
    },
    {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
        {
      'plateNumber': 'XYZ456',
      'description': 'Parked in a reserved spot',
      'date': DateTime.now().subtract(const Duration(days: 2)),
      'status': 'processing', // Report status
    },
    // Add more reports here
  ];

 @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Historija',
           style: TextStyle(fontWeight: FontWeight.bold)
        ),
        centerTitle: true,
        automaticallyImplyLeading: false,
      ),
      body: ListView.builder(
        itemCount: historyReports.length,
        itemBuilder: (context, index) {
          final report = historyReports[index];
          return HistoryCard(
            plateNumber: report['plateNumber'],
            description: report['description'],
            date: report['date'],
            status: report['status'],
          );
        },
      ),
    );
  }
}