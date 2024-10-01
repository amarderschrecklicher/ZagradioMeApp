import 'package:flutter/material.dart';
import 'package:zagradio_me/components/profile_button.dart';
import 'package:zagradio_me/components/about_modal.dart';

class ProfileScreen extends StatelessWidget{
  final String fullName;
  
  const ProfileScreen({super.key, required this.fullName});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Profil',
          style:TextStyle(fontWeight: FontWeight.bold)
        ),
        automaticallyImplyLeading: false,
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Full Name
            Text(
              fullName,
              style: const TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 20),

            // Profile Edit Button
            buildProfileButton(
              icon: Icons.edit,
              text: 'Edit Profile',
              onPressed: () {
                // Add navigation or functionality here
              },
            ),
            const SizedBox(height: 10),

            // Settings Button
            buildProfileButton(
              icon: Icons.settings,
              text: 'Settings',
              onPressed: () {
                // Add navigation or functionality here
              },
            ),
            const SizedBox(height: 10),

            // About Button
            buildProfileButton(
              icon: Icons.info,
              text: 'About',
              onPressed: () {
                showAboutModal(context);
              },
            ),
            const SizedBox(height: 10),

            // Log Out Button
            buildProfileButton(
              icon: Icons.logout,
              text: 'Log Out',
              color: Colors.red, // Log out button color
              onPressed: () {
                 Navigator.pop(context);
              },
            ),
          ],
        ),

      ),       
    );
  }
  
  
}