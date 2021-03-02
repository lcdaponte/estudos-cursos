import 'package:flutter/material.dart';
import '../models/contact.dart';
import '../screens/contact_form.dart';
import '../dao/contact_dao.dart';

class ContactsList extends StatefulWidget {
  // final List<Contact> contacts = List();

  @override
  _ContactsListState createState() => _ContactsListState();
}

class _ContactsListState extends State<ContactsList> {

  final ContactDAO dao = ContactDAO();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Contacts'),
      ),
      body: FutureBuilder<List<Contact>>(
        initialData: List(),
        future: dao.findAll(),
        builder: (ctx, snapshot) {
          final List<Contact> contacts = snapshot.data;
          return Visibility(
            visible: snapshot.connectionState == ConnectionState.done,
            child: ListView.builder(
              itemBuilder: (ctx, index) {
                return _ContactItem(contacts[index]);
              },
              itemCount: contacts.length,
            ),
            replacement: Center(
              child: CircularProgressIndicator(),
            ),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          await Navigator.of(context)
              .push(MaterialPageRoute(builder: (ctx) => ContactForm()));

          setState(() {});
        },
        child: Icon(Icons.add),
      ),
    );
  }
}

class _ContactItem extends StatelessWidget {
  final Contact contact;

  _ContactItem(this.contact);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        title: Text(
          contact.fullName,
          style: TextStyle(fontSize: 24.0),
        ),
        subtitle: Text(
          contact.accountNumber.toString(),
          style: TextStyle(fontSize: 16.0),
        ),
      ),
    );
  }
}
