import 'package:flutter/material.dart';

class HistoryCard extends StatelessWidget {
  final String plateNumber;
  final String description;
  final DateTime date;
  final String status;

  const HistoryCard({
    Key? key,
    required this.plateNumber,
    required this.description,
    required this.date,
    required this.status,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {

    Color statusColor = status == 'finished' ? Colors.green : Color.fromARGB(255, 173, 165, 97);

    return Card(
      margin: const EdgeInsets.symmetric(vertical: 8, horizontal: 16),
      child: ListTile(
        leading: const Icon(Icons.directions_car),
        title: Text(plateNumber),
        subtitle: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(description),
            const SizedBox(height: 4),
            Text('Reported on: ${date.toLocal()}'),
            const SizedBox(height: 4),
            Text(
              status.toUpperCase(),
              style: TextStyle(
                color: statusColor,
                fontWeight: FontWeight.bold,
              ),
            )
          ],
        ),
      ),
    );
  }
}
