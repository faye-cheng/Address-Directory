package for_databaseFA;

public class Name implements Comparable<Name> {
	private String myFirst; //reference to the first name
	private String myMiddle; //reference to the middle name
	private String myFamily; //reference to the last name

	public Name (String theFirst, String theFamily) {
		myFirst = theFirst;
		myMiddle = "";
		myFamily = theFamily;
	} // 2 parameter constructor if no middle name

	public Name (String theFirst, String theMiddle, String theFamily) {
		myFirst = theFirst;
		myMiddle = theMiddle;
		myFamily = theFamily;
	} // 3 parameter constructor with middle name

	public String getFirst() {
		return myFirst;
	} //getFirst

	public void setFirst(String theFirst) {
		myFirst = theFirst;
	} //setFirst

	//EXCERCISE 11.1

	public String getMiddle() {
		return myMiddle;
	} //getMiddle

	public void setMiddle(String theMiddle) {
		myMiddle = theMiddle;
	} //setMiddle

	public String getFamily() {
		return myFamily;
	} //getFamily

	public void setFamily(String theFamily) {
		myFamily = theFamily;
	} //setFamily

	public boolean equals(Object theOtherName) {
		Name theName = (Name)theOtherName;
		return myFamily.equals(theName.myFamily) &&
				myFirst.equals(theName.myFirst) &&
				myMiddle.equals(theName.myMiddle);
	} //equals

	public int compareTo(Name theName) {
		int compareValue = myFamily.compareTo(theName.myFamily);
		if (compareValue !=0) {
			return compareValue;
		} //family names were different

		compareValue = myFirst.compareTo(theName.myFirst);
		if (compareValue !=0) {
			return compareValue;
		} // first names were different with identical family names
		return myMiddle.compareTo(theName.myMiddle);
	} //compareTo

	public boolean before(Name theName) {
		return theName.compareTo(theName) < 0;
	} //before

	public boolean after(Name theName) {
		return theName.compareTo(theName) > 0;
	} //after


	public String toString() {
		return myFamily + ", " + myFirst + " " + myMiddle;
	} //toString

} //Name
