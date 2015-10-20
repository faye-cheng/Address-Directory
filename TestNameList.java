package for_databaseFA;

public class TestNameList {

	public static void main(String[] args) {

		Name n1 = new Name("a", "b", "c");
		Name n2 = new Name("d", "e", "f");
		Name n3 = new Name("a", "b", "d");

		NameList myList = new NameList(3);
		if (myList.add(n1)) {
			System.out.println(n1 + " was added to the list." + "\nThe list is now:\n" + myList);
		} else {
			System.out.println(n1 + " was not added to the list" + "\nThe list is still:\n" + myList);
		} //else
		if (myList.add(n2)) {
			System.out.println(n2 + " was added to the list." + "\nThe list is now:\n" + myList);
		} else {
			System.out.println(n2 + " was not added to the list" + "\nThe list is still:\n" + myList);
		} //else
		if (myList.add(n3)) {
			System.out.println(n3 + " was added to the list." + "\nThe list is now:\n" + myList);
		} else {
			System.out.println(n3 + " was not added to the list" + "\nThe list is still:\n" + myList);
		} //else
		if (myList.add(n1)) {
			System.out.println(n1 + " was added to the list." + "\nThe list is now:\n" + myList);
		} else {
			System.out.println(n1 + " was not added to the list" + "\nThe list is still:\n" + myList);
		} //else

		System.out.println("myList is full? " + myList.isFull());

		System.out.println(n2 + " should not be found in the list.");
		if (myList.search(n2) != null) {
			System.out.println(n2 + " is in the list.");
		} else{ 
			System.out.println(n2 + " is not in the list.");
		} //else

		System.out.println(n1 + " should be found in the list.");
		if (myList.search(n1) != null) {
			System.out.println(n1 + " is in the list.");
		} else{ 
			System.out.println(n1 + " is not in the list.");
		} //else

		//SOP here is the list, bubbleSort, SOP should be sorted now
		
		//delete the first occurrence for delete
		

	} //main

} //TestNameList
