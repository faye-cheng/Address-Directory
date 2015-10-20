package for_databaseFA;

import java.util.Comparator;
import java.io.*;

public class WCSLinkedList<E extends Comparable<E>> {
	private Node<E> myHead; //reference to the first Node
	private int mySize; //the number of Nodes in the linked list
	private Comparator<E> myComparator;
	private E[] tempArray;

	public WCSLinkedList(){
		myHead = null;
		mySize = 0;
		myComparator = null;
	} // 0 parameter constructor

	public WCSLinkedList(Comparator<E> theComparator) {
		myHead = null;
		mySize = 0;
		myComparator = theComparator;
	} // 1 parameter constructor

	public boolean add(E theData){
		try{
			myHead = new Node<>(theData, myHead);
			mySize++;
			return true;
		} //try
		catch (Exception e) {
			return false;
		} //catch
	} //add

	public E search(E findMe) {
		Node<E> mover = myHead;
		while(mover != null){
			E checkMe = mover.getData(); 
			if(checkMe.equals(findMe)){
				return checkMe;
			}//if found it
			mover = mover.getLink();
		}//while
		return null;
	}//search

	public boolean delete(E deleteMe){
		if(myHead == null){
			return false;
		}//emptyList
		if(myHead.getData().equals(deleteMe)){
			myHead = myHead.getLink();
			mySize--;
			return true;
		}//if deleting first Node
		Node<E> mover = myHead.getLink();
		Node<E> trailer = myHead;
		while(mover!= null){
			if(mover.getData().equals(deleteMe)){
				trailer.setLink(mover.getLink());
				mySize--;
				return true;
			}//if
			trailer = mover; 
			mover = mover.getLink();
		}//while
		return false;
	}//delete

	private void createArray(){
		tempArray = (E[])new Comparable[mySize];
		Node<E> mover = myHead;
		int i = 0;
		while(mover != null){
			tempArray[i++] = mover.getData();
			mover = mover.getLink();
		}//while
	}//createArray

	private void sortArray(){
		if(myComparator == null){
			UtilityMethods.sort(tempArray, mySize);
		} else {
			UtilityMethods.sort(tempArray, mySize, myComparator);
		}//else
	}//sortArray

	public String toString(){
		createArray();
		sortArray();
		return UtilityMethods.arrayToString(tempArray,mySize);
	}//toString


	public boolean isEmpty() {
		return mySize == 0;
	}//isEmpty

	public String saveToFile(String fileName){
		String messageFromSave = "";
		try{
			ObjectOutputStream oOS = new ObjectOutputStream(
					new FileOutputStream(fileName));
			Node<E> mover = myHead;
			while(mover != null){
				oOS.writeObject(mover.getData());
				mover = mover.getLink();
			}//while
			oOS.flush();
			oOS.close();
		}//try 
		catch(Exception e){
			messageFromSave = e.toString();
		}//catch
		return messageFromSave;
	}//saveToFile

	public String loadFromFile(String fileName){
		String toReturn = "";
		try{
			ObjectInputStream oIS =
					new ObjectInputStream(new FileInputStream(fileName));
			while(true){
				E fromFile = (E)(oIS.readObject());
				E found = search(fromFile);
				if(found == null){
					if(add(fromFile)){
						toReturn += fromFile + "\n-- successfully added to List.\n" + "\n";
					}else{
						toReturn += fromFile + "\n-- not successfully added to List.\n" + "\n";
					}//innerelse
				}else{
					toReturn += found + "\n--already in Database."
							+ " Record not added from file!\n" + "\n";
				}//else
			}//while
		}//try
		catch(EOFException eOF) {
		}//catch
		catch(Exception e){
			toReturn += e;
		}//catch
		return toReturn;
	}//loadFromFile

}//WCSLinkedList
