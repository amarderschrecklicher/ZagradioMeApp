import 'package:flutter/material.dart';

class RegisterScreen extends StatefulWidget {
  const RegisterScreen({super.key});

  @override
  _RegisterScreenState createState() => _RegisterScreenState();
}

class _RegisterScreenState extends State<RegisterScreen> {
  final _formKey = GlobalKey<FormState>();
  String _name = '';
  String _surname = '';
  String _email = '';
  String _password = '';
  String? _selectedGender = 'Male';
  bool _isExpanded = false;
  DateTime? _selectedDate;
  int? _phone_number;
  List<String> _carPlatesList = [''];

  final TextEditingController _dateController = TextEditingController();

  Future<void> _selectDate(BuildContext context) async {
    final DateTime? picked = await showDatePicker(
      context: context,
      initialDate: DateTime.now(),
      firstDate: DateTime(1900),
      lastDate: DateTime(2101),
    );
    if (picked != null && picked != _selectedDate) {
      setState(() {
        _selectedDate = picked;
        _dateController.text = "${picked.toLocal()}".split(' ')[0];
      });
    }
  }

  @override
  void dispose() {
    _dateController.dispose();
    super.dispose();
  }

  void _addCarPlateField() {
    setState(() {
      _carPlatesList.add('');
    });
  }

  void _removeCarPlateField(int index) {
    setState(() {
      if (_carPlatesList.length > 1) {
        _carPlatesList.removeAt(index);
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(36.0),
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: <Widget>[
                Align(
                  alignment: Alignment.centerLeft,
                  child: ElevatedButton(
                    onPressed: () {
                      Navigator.pop(context);
                    },
                    child: const Icon(Icons.arrow_back),
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
                const SizedBox(height: 20),
                Form(
                  key: _formKey,
                  child: Column(
                    children: <Widget>[
                      // Name and Surname
                      _buildTextField('Name', (value) {
                        _name = value!;
                      }),
                      const SizedBox(height: 20),
                      _buildTextField('Surname', (value) {
                        _surname = value!;
                      }),
                      const SizedBox(height: 10),

                      GestureDetector(
                        onTap: () {
                          setState(() {
                            _isExpanded = !_isExpanded;
                          });
                        },
                        child: Container(
                          padding: const EdgeInsets.all(16),
                          decoration: BoxDecoration(
                            border: Border.all(color: Colors.blue, width: 2),
                            borderRadius: BorderRadius.circular(8),
                          ),
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              Text(
                                'Gender: ${_selectedGender ?? 'Select Gender'}',
                                style: const TextStyle(fontSize: 18),
                              ),
                              Icon(
                                _isExpanded
                                    ? Icons.arrow_drop_up
                                    : Icons.arrow_drop_down,
                              ),
                            ],
                          ),
                        ),
                      ),
                      if (_isExpanded) _buildGenderOptions(),

                      const SizedBox(height: 10),
                      TextFormField(
                        controller: _dateController,
                        decoration: InputDecoration(
                          labelText: 'Birthday',
                          border: const OutlineInputBorder(),
                          suffixIcon: IconButton(
                            icon: const Icon(Icons.calendar_today),
                            onPressed: () => _selectDate(context),
                          ),
                        ),
                        readOnly: true,
                        validator: (value) {
                          if (value!.isEmpty) {
                            return 'Please select a date';
                          }
                          return null;
                        },
                      ),
                      const SizedBox(height: 20),

                      _buildTextField('Phone Number', (value) {
                        _phone_number = int.parse(value!);
                      }, keyboardType: TextInputType.phone),

                      const SizedBox(height: 20),
                      // Email
                      _buildTextField('Email', (value) {
                        _email = value!;
                      }, keyboardType: TextInputType.emailAddress),

                      const SizedBox(height: 20),
                      // Password
                      _buildTextField('Password', (value) {
                        _password = value!;
                      }, isPassword: true),

                      const SizedBox(height: 20),

                      _buildCarPlatesFields(),

                      const SizedBox(height: 20),

                      ElevatedButton(
                        onPressed: () {
                          if (_formKey.currentState!.validate()) {
                            _formKey.currentState!.save();
                            // Handle login logic here
                          }
                        },
                        child: const Text('Register'),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.blue,
                          foregroundColor: Colors.white,
                          textStyle: TextStyle(fontSize: 18),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  // Function to build a text field widget
  Widget _buildTextField(
    String label,
    FormFieldSetter<String> onSaved, {
    TextInputType keyboardType = TextInputType.text,
    bool isPassword = false,
  }) {
    return TextFormField(
      decoration: InputDecoration(
        labelText: label,
        border: const OutlineInputBorder(),
      ),
      obscureText: isPassword,
      validator: (value) {
        if (value == null || value.isEmpty) {
          return 'Please enter your $label';
        }
        return null;
      },
      onSaved: onSaved,
      keyboardType: keyboardType,
    );
  }

  // Gender Selector Widget
  Widget _buildGenderOptions() {
    return Column(
      children: <Widget>[
        _genderOption('Male'),
        _genderOption('Female'),
        _genderOption('Other'),
      ],
    );
  }

  Widget _genderOption(String gender) {
    return GestureDetector(
      onTap: () {
        setState(() {
          _selectedGender = gender;
          _isExpanded = false; // Close the options after selection
        });
      },
      child: Container(
        margin: const EdgeInsets.symmetric(vertical: 8),
        padding: const EdgeInsets.all(16),
        decoration: BoxDecoration(
          color: _selectedGender == gender ? Colors.blue : Colors.white,
          borderRadius: BorderRadius.circular(8),
          border: Border.all(color: Colors.blue, width: 2),
        ),
        child: Center(
          child: Text(
            gender,
            style: TextStyle(
              color: _selectedGender == gender ? Colors.white : Colors.blue,
              fontSize: 18,
            ),
          ),
        ),
      ),
    );
  }

  // Car Plates fields with add/remove functionality
  Widget _buildCarPlatesFields() {
    return Column(
      children: [
        ListView.builder(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: _carPlatesList.length,
          itemBuilder: (context, index) {
            return Row(
              children: [
                Expanded(
                  child: TextFormField(
                    decoration: InputDecoration(
                      labelText: 'Car Plate ${index + 1}',
                      border: const OutlineInputBorder(),
                    ),
                    onChanged: (value) {
                      _carPlatesList[index] = value;
                    },
                  ),
                ),
                IconButton(
                  onPressed: () => _removeCarPlateField(index),
                  icon: const Icon(Icons.remove_circle),
                  color: Colors.red,
                ),
              ],
            );
          },
        ),
        const SizedBox(height: 10),
        TextButton(
          onPressed: _addCarPlateField,
          child: const Text('Add another car plate'),
        ),
      ],
    );
  }
}
