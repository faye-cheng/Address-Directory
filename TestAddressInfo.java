package for_databaseFA;

public class TestAddressInfo {
	public static void main (String[] args) {

		AddressInfo AI1 = new AddressInfo("Harry", "James", "Potter", "4 Privet Drive", "The Cupboard Under The Stairs", "Little Whinging", "Surrey", "10101");
		AddressInfo AI2 = new AddressInfo("Faye", "Hiu-Tung", "Cheng", "575 Capitol Drive", "Benicia", "CA", "94510");
		AddressInfo AI3 = new AddressInfo("Faye", "Hiu-Tung", "Cheng", "575 Capitol Drive", "Benicia", "CA", "94510");
		AddressInfo AI4 = new AddressInfo("Sherlock", "", "Holmes");

		System.out.println("Initial Address Info entries and test toString method." + "\n");
		System.out.println("AI1 is: " + "\n" + AI1);
		System.out.println("AI2 is: " + "\n" + AI2);
		System.out.println("AI3 is: " + "\n" + AI3);
		System.out.println("AI4 is: " + "\n" + AI4);

		System.out.println("Test get method. " + "\n");
		System.out.println("The name in AI1 is: " + "\t" + AI1.getName());
		System.out.println("");
		System.out.println("The address in AI1 is: " + "\n" + AI1.getAddress());
		System.out.println("");

		System.out.println("The name in AI2 is: " + "\t" + AI2.getName());
		System.out.println("");
		System.out.println("The address in AI2 is: " + "\n" + AI2.getAddress());
		System.out.println("");

		System.out.println("The name in AI3 is: " + "\t" + AI3.getName());
		System.out.println("");
		System.out.println("The address in AI3 is: " + "\n" + AI3.getAddress());
		System.out.println("");

		// test get()

		System.out.println("Test set method. " + "\n");

		System.out.println("The address in AI1 is now set to: " + AI1.getAddress());

		//test set()

		System.out.println("Test equal method. " + "\n");

		if (AI1.equals(AI2)) {
			System.out.println("AI1 and AI2 are the same");
		} else {
			System.out.println("AI1 and AI2 are not the same");
		} //else
		if (AI2.equals(AI3)) {
			System.out.println("AI2 and AI3 are the same");
		} else {
			System.out.println("AI2 and AI3 are not the same");
		} //else
		if (AI2.equals(AI3)) {
			System.out.println("AI2 and AI3 are the same");
		} else {
			System.out.println("AI2 and AI3 are not the same");
			System.out.println("");
		}
		if (AI3.equals(AI4)) {
			System.out.println("AI3 and AI4 are the same");
		} else {
			System.out.println("AI3 and AI4 are not the same");
		} //else

		//equal()
		System.out.println(" ");
		System.out.println("Test compareTo method. " + "\n");
		int valueReturn = AI1.compareTo(AI3);
		if (valueReturn < 0) {
			System.out.println(AI1 + "\n" + "\n" + "is before:" + "\n" + "\n" + AI3);
		} else if (valueReturn > 0) {
			System.out.println(AI1 + "\n" + "\n" + "is after:" + "\n" + "\n" + AI3);
		} else {
			System.out.println(AI1 + "\n" + "\n" + "is the same as:" + "\n" + "\n" + AI3);
		} //else
		System.out.println("");
		System.out.println("---");

		valueReturn = AI1.compareTo(AI2);
		if (valueReturn < 0) {
			System.out.println(AI1 + "\n" + "is before:" + "\n" + "\n" + AI2);
		} else if (valueReturn > 0) {
			System.out.println(AI1 + "\n" + "is after:" + "\n" + "\n" + AI2);
		} else {
			System.out.println(AI1 + "\n" + "is the same as:" + "\n" + "\n" + AI3);
		} //else
		System.out.println("");
		System.out.println("---");

		valueReturn = AI4.compareTo(AI1);
		if (valueReturn < 0) {
			System.out.println(AI4 + "\n" + "is before:" + "\n" + "\n" + AI1);
		} else if (valueReturn > 0) {
			System.out.println(AI4 + "\n" + "is after:" + "\n" + "\n" + AI1);
		} else {
			System.out.println(AI4 + "\n" + "is the same as:" + "\n" + "\n" + AI1);
		} //else
		System.out.println("");
		System.out.println("---");

		valueReturn = AI2.compareTo(AI3);
		if (valueReturn < 0) {
			System.out.println(AI2 + "\n" + "is before:" + "\n" + "\n" + AI3);
		} else if (valueReturn > 0) {
			System.out.println(AI2 + "\n" + "is after:" + "\n" + "\n" + AI3);
		} else {
			System.out.println(AI2 + "\n" + "is the same as:" + "\n" + "\n" + AI3);
		} //else
		System.out.println("");
		System.out.println("---");


		//test compareTo(), before(), and after()

		System.out.println("Test beforeAlpha  method.");
		System.out.println("");
		if (AI1.beforeAlpha(AI2)) {
			System.out.println(AI1 + "\n" + "\n" + "is beforeAlpha:" + "\n" + "\n" + AI4);
		} else {
			System.out.println(AI1 + "\n" + "\n" + "is afterAlpha:" + "\n" + "\n" + AI4);
		} //else

		if (AI4.beforeAlpha(AI2)) {
			System.out.println(AI4 + "\n" + "\n" + "is beforeAlpha:" + "\n" + "\n" + AI2);
		} else {
			System.out.println(AI4 + "\n" + "\n" + "is afterAlpha:" + "\n" + "\n" + AI2);
		} //else

		if (AI3.beforeAddress(AI4)) {
			System.out.println(AI1 + "\n" + "\n" + "is beforeAlpha:" + "\n" + "\n" + AI4);
		} else {
			System.out.println(AI1 + "\n" + "\n" + "is afterAlpha:" + "\n" + "\n" + AI4);
			System.out.println("---");
		} //else

		//test beforeAlpha()

		System.out.println("Test beforeAddress  method.");
		System.out.println("");
		if (AI1.beforeAlpha(AI2)) {
			System.out.println(AI1 + "\n" + "\n" + "is beforeAddress:" + "\n" + "\n" + AI4);
		} else {
			System.out.println(AI1 + "\n" + "\n" + "is afterAddress:" + "\n" + "\n" + AI4);
			System.out.println("---");
		} //else

		if (AI3.beforeAddress(AI4)) {
			System.out.println(AI1 + "\n" + "\n" + "is beforeAddress:" + "\n" + "\n" + AI4);
		} else {
			System.out.println(AI1 + "\n" + "\n" + "is afterAddress:" + "\n" + "\n" + AI4);
			System.out.println("---");
		} //else

		if (AI4.beforeAddress(AI2)) {
			System.out.println(AI4 + "\n" + "\n" + "is beforeAddress:" + "\n" + "\n" + AI2);
		} else {
			System.out.println(AI4 + "\n" + "\n" + "is afterAddress:" + "\n" + "\n" + AI2);
			System.out.println("---");
		} //else

		//test beforeAddress()

	} //main
}
