import 'package:flutter/material.dart';

void showAboutModal(BuildContext context) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: const Text('About This App'),
          content: const Text(
              'This app allows users to report blocked parking spots.\n\nVersion: 1.0.0\nDeveloper: Your Name'),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop(); // Close the modal
              },
              child: const Text('Close'),
            ),
          ],
        );
      },
    );
}