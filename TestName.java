package for_databaseFA;

public class TestName {
	public static void main (String[] args) {
		Name n1 = new Name ("Fay", "Hiu-Tung", "Chan");
		Name n2 = new Name ("Maiyah", "Matsumura"); //without middle name
		Name n3 = new Name ("Anthony", "Trevon", "Bates");
		Name n4 = new Name ("Clifford", "P", "Cheng"); //same last name

		System.out.println("Initial name assignments and test toString method." + "\n");
		System.out.println("n1 is: " + "\t" + n1);
		System.out.println("n2 is: " + "\t" + n2);
		System.out.println("n3 is: " + "\t" + n3);
		System.out.println("n4 is: " + "\t" + n4);
		System.out.println("");

		System.out.println("Test get method. " + "\n");
		System.out.println("The first name in n1 is: " + "\t" + n1.getFirst());
		System.out.println("The middle name in n1 is: " + "\t" + n1.getMiddle());
		System.out.println("The family name in n1 is: " + "\t" + n1.getFamily());
		System.out.println("");
		// test get()

		System.out.println("Test set method. " + "\n");
		n1.setFirst("Faye");
		System.out.println("The first name in n1 is now set to: " + "\t" + n1.getFirst());
		n1.setMiddle("H");
		System.out.println("The middle name in n1 is now set to: " + "\t" + n1.getMiddle());
		n1.setFamily("Cheng");
		System.out.println("The family name in n1 is now set to: " + "\t" + n1.getFamily());
		System.out.println("");
		//test set()

		System.out.println("Test equal method. " + "\t" + "\n");
		n4.setFirst("Faye");
		n4.setMiddle("H");
		n4.setFamily("Cheng");
		System.out.println("n4 is now set to: " + "\t" + n4);
		System.out.println("n1 is: " + "\t" + n1);
		System.out.println("n3 is: " + "\t" + n3);
		System.out.println("n4 is: " + "\t" + n4);
		System.out.println("");
		if (n4.equals(n1)) {
			System.out.println("n4 and n1 are the same.");
		} else {
			System.out.println("n4 and n1 are not the same.");
		} //else
		if (n3.equals(n1)) {
			System.out.println("n3 and n1 are the same.");
		} else {
			System.out.println("n3 and n1 are not the same.");
		} //else

		System.out.println("");
		//test equal()

		System.out.println("Test compareTo, before, and after methods. " + "\n");
		int valueReturn = n2.compareTo(n3);
		if (valueReturn < 0) {
			System.out.println(n2 + " is before " + n3);
		} else if (valueReturn > 0) {
			System.out.println(n2 + " is after " + n3);
		} else {
			System.out.println(n2 + " is the same as " + n3);
		} //else

		valueReturn = n1.compareTo(n2);
		if (valueReturn < 0) {
			System.out.println(n1 + " is before " + n2);
		} else if (valueReturn > 0) {
			System.out.println(n1 + " is after " + n2);
		} else {
			System.out.println(n1 + " is the same as " + n2);
		} //else
		//compareTo()

		if (n1.before(n4)) {
			System.out.println(n1 + " is before " + n4);
		} else if (valueReturn > 0) {
			System.out.println(n1 + " is not before " + n4);
		} else {
			System.out.println(n1 + " is the same as " + n4);
		} //else

		//before()

		if (n2.after(n3)) {
			System.out.println(n2 + " is after " + n3);
		} else if (valueReturn > 0) {
			System.out.println(n2 + " is not after " + n3);
		} else {
			System.out.println(n2 + " is the same as " + n3);
		} //else
		//after()

	}//main
} //TestName
