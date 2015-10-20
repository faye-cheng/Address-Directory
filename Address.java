package for_databaseFA;

public class Address implements Comparable<Address>{
	private String myStreetAddress;
	private String myStreetAddressOptional;
	private String myCity;
	private String myState;
	private String myZipcode;

	public Address(String theStreetAddress, String theStreetAddressOptional, String theCity, String theState, String theZipcode) {
		myStreetAddress = theStreetAddress;
		myStreetAddressOptional = theStreetAddressOptional;
		myCity = theCity;
		myState = theState;
		myZipcode = theZipcode;
	} // 5 parameter constructor

	public Address(String theStreetAddress, String theCity, String theState, String theZipcode) {
		myStreetAddress = theStreetAddress;
		myStreetAddressOptional = "";
		myCity = theCity;
		myState = theState;
		myZipcode = theZipcode;

	} // 4 parameter constructor

	public Address() {
		myStreetAddress = "";
		myStreetAddressOptional = "";
		myCity = "";
		myState = "";
		myZipcode = "";
	} // 0 parameter constructor
	
	public static final String[] STATES = {"--",
		"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
		"HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
		"MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
		"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
		"SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

	public String getStreetAddress() {
		return myStreetAddress;
	} // getStreetAddress

	public void setStreetAddress(String theStreetAddress) {
		myStreetAddress = theStreetAddress;
	} // setStreetAddress

	public String getStreetAddressOptional() {
		return myStreetAddressOptional;
	} // getStreetAddressOptional

	public void setStreetAddressOptional(String theStreetAddressOptional) {
		myStreetAddressOptional = theStreetAddressOptional;
	} // setStreetAddressOptional

	public String getCity() {
		return myStreetAddress;
	} // getCity

	public void setCity(String theCity) {
		myCity = theCity;
	} // setCity

	public String getState() {
		return myState;
	} // getState

	public void setState(String theState) {
		myState = theState;
	} // setState

	public String getZipcode() {
		return myZipcode;
	} // getZipcode

	public void setZipcode(String theZipcode) {
		myZipcode = theZipcode;
	} // setZipcode

	public boolean equals(Object theOtherAddress) {
		Address theAddress = (Address)theOtherAddress;
		return myStreetAddress.equals(theAddress.myStreetAddress) &&
				myStreetAddressOptional.equals(theAddress.myStreetAddressOptional) &&
				myCity.equals(theAddress.myCity) &&
				myState.equals(theAddress.myState) &&
				myZipcode.equals(theAddress.myZipcode);
	} //equals

	public int compareTo(Address theAddress) {
		int compareValue = myState.compareTo(theAddress.myState);
		if (compareValue !=0) {
			return compareValue;
		} //states were different
		compareValue = myCity.compareTo(theAddress.myCity);
		if (compareValue !=0) {
			return compareValue;
		} // cities were different
		compareValue = myZipcode.compareTo(theAddress.myZipcode);
		if (compareValue !=0) {
			return compareValue;
		} // zipcodes were different
		compareValue = myStreetAddress.compareTo(theAddress.myStreetAddress);
		if (compareValue !=0) {
			return compareValue;
		} // street addresses were different
		return compareValue = myStreetAddressOptional.compareTo(theAddress.myStreetAddressOptional);	
	} //compareTo

	public boolean before(Address theAddress) {
		return theAddress.compareTo(theAddress) < 0;
	} //before

	public boolean after(Address theAddress) {
		return theAddress.compareTo(theAddress) > 0;
	} //after

	public String toString() {
	
		if (myStreetAddress.equals("") && myStreetAddressOptional.equals("") && myCity.equals("") &&
				myState.equals("") && myZipcode.equals("")) {
			return "";
		}
		return myStreetAddress + "\n" + ((myStreetAddressOptional.equals("") || myStreetAddressOptional.equals("(Optional)")) ? "" : myStreetAddressOptional + "\n") +
				myCity + ", " + myState + " " + myZipcode + "\n";
	}//toString

} // Address
