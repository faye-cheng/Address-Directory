package for_databaseFA;

public class NameList {

	private Name myArray[]; //refers to the array of Name objects
	private int myCount; // holds the current count of Name objects in the list

	public NameList () {
		myArray = new Name[100];
		myCount = 0;
	}// 0 parameter constructor

	public NameList (int theMax) {
		myArray = new Name[theMax];
		myCount = 0;
	}// 1 parameter constructor

	public boolean isFull() {
		return myCount == myArray.length;
	}//isFull

	public boolean add(Name theName) {
		if(search(theName) != null){
			return false;
		}//if
		try{
			if (isFull()) {
				Name tempArray[] =
						new Name[myArray.length * 2];
				for(int i = 0 ; i < myCount; i++){
					tempArray[i] = myArray[i];
				}//for
				myArray = tempArray;
			}//if array was full
			myArray [myCount++] = theName;
			return true;
		}//try
		catch (Exception e){
			return false;
		}//catch
	}//add
	public String toString() {
		String stringToReturn = "";
		for (int i = 0; i < myCount; i++) {
			stringToReturn += myArray [i] + "\n"; //"\n" for the new line character
		}//for
		return stringToReturn;
	}//toString

	public Name search (Name theName) {
		int i = 0;
		while ( i < myCount && 
				!(myArray[i].equals(theName))){
			i++;
		}//while
		return (i < myCount ? myArray[i] : null); 
	}//search

	private void swap (int firstPos, int otherPos) {
		Name temp = myArray[firstPos];
		myArray[firstPos] = myArray[otherPos];
		myArray[otherPos] = temp;
	}//swap

	public void bubbleSort() {
		for(int passNum = 1; passNum < myCount; passNum++) {
			for (int j = 0; j < myCount - passNum; j++) {
				if(myArray[j+1].before(myArray[j])) {
					swap(j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//bubbleSort
	
	public boolean delete(Name deleteMe){
		int i = 0;
		while ( i < myCount && 
				!(myArray[i].equals(deleteMe))){
			i++;
		}//while
		if(i == myCount){
			return false;
		}//if item not in list
		for(int j = i; j < myCount - 1; j++){
			myArray[j] = myArray[j+1];
		}//for j
		myCount--;
		return true;
	}//delete

	public Name binarySearch(Name nameToFind) {
		int low = 0;
		int high = myCount - 1;
		int middle = (low + high)/2;
		while (low <= high && ! (myArray[middle].equals(nameToFind)) ) {
			if ( nameToFind.compareTo (myArray[middle])<0) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}//else
			middle = (low + high)/2;
		}//while
		return (myArray[middle].equals(nameToFind) ? myArray[middle] : null);
	}//binarySearch

	public void selectionSort() {
		for (int posBeingFixed = 0; posBeingFixed < myCount - 1; posBeingFixed++) {
			int positionOfSmallest = posBeingFixed;
			for (int comparePos = posBeingFixed + 1; comparePos < myCount; comparePos++) {
		 		if (myArray[comparePos].before(myArray[positionOfSmallest])) {
					positionOfSmallest = comparePos;
				} //if
			} //for
			if (posBeingFixed != positionOfSmallest) {
				swap (posBeingFixed, positionOfSmallest);
			} //if
		} //for posBeingFixed
	} //selectionSort

	public void insertSort() {
		for (int toBeInserted = 1; toBeInserted < myCount; toBeInserted++) {
			Name hold = myArray[toBeInserted];
			int correctPos = toBeInserted;

			while (correctPos > 0  && hold.compareTo(myArray[correctPos - 1]) < 0) { //is this number negative = before
				correctPos -= 1;
			} //while either hit 0 or find value that is not before correctPos

			for (int x = toBeInserted; x > correctPos; x--) {
				myArray[x] = myArray[x - 1];
			} //for

			myArray[correctPos] = hold;
		} //for
	} //insertSort

	public boolean searchSorted (Name theName) {
		int i = 0;
		while ( i < myCount) {
			if (myArray[i].after(theName)) {
				return false;
			} //if
			i++;
		}//while
		return true; 
	}//searchSorted

}//NameList
