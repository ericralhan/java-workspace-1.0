package codesample;

import java.util.ArrayList;
import java.util.List;

public class IdentifyRunTimeExceptions {

	public static void main(String args[]) {
		Company company = new Company();
		getMainContactPhoneNumber(company);
	}

	private static String getMainContactPhoneNumber(Company company) {
		Contact c = company.getContacts().get(0);
		// below exceptions in above line
		// null for company
		// null if getContacts() return null list;
		// IndexOutOfboundsException if there is nothing in the list at get(0)
		PhoneNumber ph = c.getPhoneNumber();
		// There wont be any exception in above line if first line passes
		return ph.getFormattedPhoneNumber();
		// null pointer if PhoneNumber Class is null
	}
}

class Company {

	List<Contact> contacts = new ArrayList<Contact>();

	public List<Contact> getContacts() {
		Contact c = new Contact();
		c.setPhoneNumber(new PhoneNumber());
		contacts.add(c);
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}

class Contact {
	PhoneNumber phoneNumber;

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

class PhoneNumber {

	String formattedPhoneNumber;

	public String getFormattedPhoneNumber() {
		return formattedPhoneNumber;
	}

	public void setFormattedPhoneNumber(String formattedPhoneNumber) {
		this.formattedPhoneNumber = formattedPhoneNumber;
	}

}
