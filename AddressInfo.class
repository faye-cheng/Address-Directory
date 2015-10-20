package for_databaseFA;

import java.util.*;

public class AddressInfo implements Comparable<AddressInfo>{
	
	private Name myName;
	private Address myAddress;
	public static final Comparator<AddressInfo> ADDRESS_COMPARATOR = 
			((aI1,aI2) -> {
				return resultForComparator(aI1, aI2);
			});
	
	private static int resultForComparator(AddressInfo aI1, AddressInfo aI2){
		int result = aI1.myAddress.compareTo(aI2.myAddress);
		if(result != 0){
			return result;
		}//if addresses are not the same
		return aI1.myName.compareTo(aI2.myName);		
	}//resultForComparator



	public AddressInfo(String theFirst, String theMiddle, String theFamily, String theStreetAddress, String theStreetAddressOptional, String theCity, String theState, String theZipcode) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myAddress = new Address(theStreetAddress, theStreetAddressOptional, theCity, theState, theZipcode);
	} // 8 parameter constructor

	public AddressInfo(String theFirst, String theMiddle, String theFamily, String theStreetAddress, String theCity, String theState, String theZipcode) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myAddress = new Address(theStreetAddress, theCity, theState, theZipcode);
	} // 7 parameter constructor

	public AddressInfo(String theFirst, String theMiddle, String theFamily) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myAddress = new Address();
	} // 3 parameter constructor

	public Name getName() {
		return myName;
	} // getName

	public Address getAddress() {
		return myAddress;
	} // getAddress

	public void setName(Name theName) {
		myName = theName;
	} // setName

	public void setAddress(Address theAddress) {
		myAddress = theAddress;
	} // setAddress

	public String toString() {
		return myName + "\n" + myAddress;
	}//toString

	public boolean equals(Object theOtherAddressInfo) {
		AddressInfo theAddressInfo = (AddressInfo)theOtherAddressInfo;
		return myName.equals(theAddressInfo.myName);
	} //equals

	public int compareTo(AddressInfo theAddressInfo) {
		return myName.compareTo(theAddressInfo.myName);	
	} //compareTo

	public boolean beforeAlpha(AddressInfo theAddressInfo) {
		return compareTo(theAddressInfo) < 0;
	} //beforeAlpha

	public boolean beforeAddress(AddressInfo theAddressInfo) {
		return myAddress.before(theAddressInfo.myAddress) ||
				(myAddress.equals(theAddressInfo.myAddress) &&
						myName.before(theAddressInfo.myName));
	} //beforeAddress

}//AddressInfo
