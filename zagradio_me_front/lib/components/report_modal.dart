import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class ReportModal extends StatelessWidget {
  final String plateNumber;
  final String description;
  final DateTime date;
  final String status;

  const ReportModal({
    Key? key,
    required this.plateNumber,
    required this.description,
    required this.date,
    required this.status,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
      Color statusColor = status == 'uspješno' ?  Colors.green :
    status ==  'neuspješno'? Colors.red  
    : Color.fromARGB(255, 173, 165, 97);

    return AlertDialog(
      title: const Text('Report',
          textAlign: TextAlign.center,
          style: TextStyle(fontWeight: FontWeight.bold)),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          const Text(
            'Report Details',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          Text('Plate Number: $plateNumber', style: TextStyle(fontSize: 18)),
          const SizedBox(height: 8),
          Text('Description: $description', style: TextStyle(fontSize: 16)),
          const SizedBox(height: 8),
          Text('Reported on: ${DateFormat('d. MMMM yyyy HH:mm').format(date)}',
              style: const TextStyle(fontSize: 16)),
          const SizedBox(height: 8),
          Text(
            'Status: ${status.toUpperCase()}',
            style: TextStyle(
              fontSize: 16,
              color: statusColor,
              fontWeight: FontWeight.bold,
            ),
          ),
        ],
      ),   
      actions: status == 'uspješno' || status == 'neuspješno'
      ? null // If the status is uspješno or neuspješno, no buttons are shown
      : [
        TextButton(
          onPressed: () {
            // Action for "Otkaži"
          },
          style: TextButton.styleFrom(
            backgroundColor: Colors.red, // Set red color for this button
            foregroundColor: Colors.white, // Text color
            padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
          ),
          child: const Text('Neuspješno'),
        ),
                TextButton(
          onPressed: () {
            // Action for "Riješeno"
          },
          style: TextButton.styleFrom(
            backgroundColor: Colors.green, // Set green color for this button
            foregroundColor: Colors.white, // Text color
            padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
          ),
          child: const Text('Uspješno'),
        ),
      ],
    );
  }
}
