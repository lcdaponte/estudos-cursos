class Contact {
  final int id;
  final String fullName;
  final int accountNumber;

  Contact(this.id, this.fullName, this.accountNumber);

  @override
  String toString() {
    return 'Contact(id: ${this.id}, name: ${this.fullName}, accountNumber: ${this.accountNumber})';
  }
}