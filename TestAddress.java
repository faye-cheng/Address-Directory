package for_databaseFA;

public class TestAddress {

	public static void main (String[] args) {

		Address A1 = new Address("575 Capitol Drive", "Suite 1", "Benicia", "CA", "94510");
		Address A2 = new Address("5000 MacArther Blvd", "Oakland", "CA", "92613");
		Address A3 = new Address("5000 MacArther Blvd", "Oakland", "CA", "92613");

		System.out.println("Initial addresses and test toString method." + "\n");
		System.out.println("A1 is: " + "\n" + A1);
		System.out.println("");
		System.out.println("A2 is: " + "\n" + A2);
		System.out.println("");
		System.out.println("A3 is: " + "\n" + A3);
		System.out.println("");

		System.out.println("Test get method. " + "\n");
		System.out.println("The street address in A1 is: " + "\t" + A1.getStreetAddress());
		System.out.println("The optional street address in A1 is: " + "\t" + A1.getStreetAddressOptional());
		System.out.println("The city in A1 is: " + "\t" + A1.getCity());
		System.out.println("The state in A1 is: " + "\t" + A1.getState());
		System.out.println("The zipcode in A1 is: " + "\t" + A1.getZipcode());
		System.out.println("");
		// test get()

		System.out.println("Test set method. " + "\n");
		A1.setStreetAddress("521 Capitol Drive");
		System.out.println("The street address in A1 is now set to: " + A1.getStreetAddress());
		A1.setStreetAddressOptional("");
		System.out.println("The optional street address in A1 is now set to: " + A1.getStreetAddressOptional());
		A1.setCity("Vallejo");
		System.out.println("The city in A1 is now set to: " + A1.getCity());
		A1.setState("NY");
		System.out.println("The state in A1 is now set to: " + A1.getState());
		A1.setZipcode("53612");
		System.out.println("The zipcode in A1 is now set to: " + A1.getZipcode());
		System.out.println("");
		System.out.println("A1 has been changed to: " + "\n" + A1);
		System.out.println("");
		//test set()

		System.out.println("Test equal method. " + "\n");
		System.out.println("A1 is: " + "\n" + A1);
		System.out.println("");
		System.out.println("A2 is: " + "\n" + A2);
		System.out.println("");
		System.out.println("A3 is: " + "\n" + A3);
		System.out.println("");
		if (A1.equals(A2)) {
			System.out.println("A1 and A2 are the same");
		} else {
			System.out.println("A1 and A2 are not the same");
		} //else
		if (A2.equals(A3)) {
			System.out.println("A2 and A3 are the same");
		} else {
			System.out.println("A2 and A3 are not the same");
		} //else

		System.out.println("");
		//test equal()

		System.out.println("Test compareTo, before, and after methods. " + "\n");
		int valueReturn = A1.compareTo(A3);
		if (valueReturn < 0) {
			System.out.println(A1 + "\n" + "\n" + "is before:" + "\n" + "\n" + A3);
		} else if (valueReturn > 0) {
			System.out.println(A1 + "\n" + "\n" + "is after:" + "\n" + "\n" + A3);
		} else {
			System.out.println(A1 + "\n" + "\n" + "is the same as:" + "\n" + "\n" + A3);
		} //else
		System.out.println("");
		System.out.println("---");

		valueReturn = A1.compareTo(A2);
		if (valueReturn < 0) {
			System.out.println(A1 + "\n" + "\n" + "is before:" + "\n" + "\n" + A2);
		} else if (valueReturn > 0) {
			System.out.println(A1 + "\n" + "\n" + "is after:" + "\n" + "\n" + A2);
		} else {
			System.out.println(A1 + "\n" + "\n" + "is the same as:" + "\n" + "\n" + A3);
		} //else
		System.out.println("");
		System.out.println("---");

		//compareTo()

		if (A2.before(A1)) {
			System.out.println(A2 + "\n" + "\n" + "is before:" + "\n" + "\n" + A1);
		} else if (valueReturn > 0) {
			System.out.println(A2 + "\n" + "\n" + "is after:" + "\n" + "\n" + A1);
		} else {
			System.out.println(A2 + "\n" + "\n" + "is the same as:" + "\n" + "\n" + A1);
		} //else
		System.out.println("");
		System.out.println("---");

		//before()

		if (A2.after(A3)) {
			System.out.println(A2 + "\n" + "\n" + "is before:" + "\n" + "\n" + A3);
		} else if (valueReturn > 0) {
			System.out.println(A2 + "\n" + "\n" + "is after:" + "\n" + "\n" + A3);
		} else {
			System.out.println(A2 + "\n" + "\n" + "is the same as:" + "\n" + "\n" + A3);
		} //else

		//after()

	}//main
} //TestAddress
