import 'package:flutter/material.dart';

Widget buildProfileButton({
  required IconData icon,
  required String text,
  required VoidCallback onPressed,
  Color color = Colors.blue
}){
    return ElevatedButton.icon(
      style: ElevatedButton.styleFrom(
        minimumSize: const Size(double.infinity, 50), // Full-width button
        backgroundColor: color,
        textStyle: const TextStyle(fontSize: 16),
      ),
      icon: Icon(icon, size: 24),
      label: Text(text),
      onPressed: onPressed,
    );
  }

