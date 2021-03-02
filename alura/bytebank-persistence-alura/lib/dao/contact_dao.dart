import 'package:sqflite/sqflite.dart';
import '../database/app_database.dart';
import '../models/contact.dart';

class ContactDAO {

  static const String tableSql = 'CREATE TABLE contacts('
          'id INTEGER PRIMARY KEY, '
          'fullName TEXT, '
          'account_number INTEGER)';
          
  static const String _tableName = 'contacts';
  static const String _id = 'id';
  static const String _fullName = 'fullName';
  static const String _accountNumber = 'account_number';


  Future<int> save(Contact contact) async {
  final Database db = await getDatabase(tableSql);

  Map<String, dynamic> contactMap = _toMap(contact);
  return db.insert(_tableName, contactMap);
}

Future<List<Contact>> findAll() async {
  final Database db = await getDatabase(tableSql);
  final List<Map<String, dynamic>> result = await db.query(_tableName);
  List<Contact> contacts = _toList(result);
  return contacts;
}

Map<String, dynamic> _toMap(Contact contact) {
    final Map<String, dynamic> contactMap = Map();
    contactMap[_fullName] = contact.fullName;
    contactMap[_accountNumber] = contact.accountNumber;
    return contactMap;
  }

List<Contact> _toList(List<Map<String, dynamic>> result) {
  final List<Contact> contacts = List();
  result.forEach((row) {
    final Contact contact = Contact(
      row[_id],
      row[_fullName],
      row[_accountNumber],
    );
    contacts.add(contact);
  });
  return contacts;
}
}