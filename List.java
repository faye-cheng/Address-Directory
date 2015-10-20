package for_databaseFA;

import java.io.*;
import java.awt.*;
import java.awt.Event;
import java.util.*;
import javax.swing.*;

public class List <E extends Comparable<E>>{
	private E myArray[]; //array of E's
	private int myCount; // current count of E's in list
	private static final int MAX = 4;
	private Comparator<E> myComparator;
	
	public List(){
	myArray = (E[]) new Comparable[MAX];
	myCount = 0;
	myComparator = null;
	}//0 parameter constructor 
	
	public List (int theMax) {
		myArray = (E[])new Comparable[theMax];
		myCount = 0;
		myComparator = null;
	}// 1 parameter constructor

	public List (Comparator<E> theComparator) {
		myArray = (E[])new Comparable[MAX];
		myCount = 0;
		myComparator = theComparator;
	}// 1 Comparator parameter constructor
	
	public List (int theMax, Comparator<E> theComparator) {
		myArray = (E[])new Comparable[theMax];
		myCount = 0;
		myComparator = theComparator;
	}// 2 Comparator parameter constructor
	
	private int myCompare(E theFirst, E theSecond){
		if(myComparator == null){
			return theFirst.compareTo(theSecond);
		}// no comparator
		return myComparator.compare(theFirst, theSecond);
	}//myCompare
	
	private void swap (int firstPos, int otherPos) {
		E temp = myArray[firstPos];
		myArray[firstPos] = myArray[otherPos];
		myArray[otherPos] = temp;
	}//swap
	
	public boolean isFull() {
		return myCount == myArray.length;
	}//isFull
	
	public boolean isEmpty() {
		return myCount == 0;
	}//isEmpty
	
	public boolean add(E addMe) {
		if(search(addMe) != null){
			return false;
		}//if
		try{
			if(isFull()){
				E tempArray[] = (E[]) new Comparable[myArray.length * 2];
				for(int i = 0; i < myCount; i++){
					tempArray[i] = myArray[i];
				}//for
				myArray = tempArray;
			}//if array was full
			myArray [myCount++] = addMe;
			return true;
		}//try
		catch (Exception e){
			return false;
		}//catch
	}//add
	
	public String toString() {
		String stringToReturn = "";
		for (int i = 0; i < myCount; i++) {
			stringToReturn += "\n" + myArray [i] + "\n";
			//"\n" for the new line character
		}//for
		return stringToReturn;
	}//toString
	
	public void bubbleSort() {
		for(int passNum = 1; passNum < myCount; passNum++) {
			for (int j = 0; j < myCount - passNum; j++) {
				if(myCompare(myArray[j+1],myArray[j])<0) {
					swap(j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//bubbleSort
	
	public E search (E searchMe) {
		int i = 0;
		while ( i < myCount && !(myArray[i].equals(searchMe))){
			i++;
		}//while
		return (i < myCount ? myArray[i] : null); 
	}//search
	
	public boolean delete(E deleteMe){
		if (search(deleteMe) == null) {
			return false;
		}//if
		int i = 0; 
		while(i < myCount && !(myArray[i].equals(deleteMe))){
			i++;
		}//while
		for(int j = i; j < myCount - 1; j++){
			myArray[j] = myArray[j+1];
		}//for
		myCount--;
		return true;
	}//delete
	
	public String loadFromFile(String fileName) {
		String toReturn = "";
		try {
			ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(
					fileName));
			while (true) {
				E fromFile = (E) (oIS.readObject());
				E found = (E) search(fromFile);
				if (found == null) {// person not already in DB
					if (add(fromFile)) {
						toReturn += fromFile + " successfully added to DB.\n";
					} else {
						toReturn += fromFile
								+ " not successfully added to DB.\n";
					}// inner else
				} else {
					toReturn += found + " already in DB.\n"
							+ "record not added from file!\n";
				}// else
			}// while
		}// try
		catch (EOFException eOF) {
		}// catch
		catch (Exception e) {
			toReturn += e;
		}// catch
		return toReturn;
	}// loadFromFile

	public String saveToFile(String fileName){
		String messageFromSave = "";
		try{
			ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
				for(int i= 0; i < myCount; i++){
					oOS.writeObject(myArray[i]);
				}//for
				oOS.flush();
				oOS.close();
			}//try 
		catch(Exception e){
			messageFromSave = e.toString();
		}//catch
		return messageFromSave;
	}//saveToFile

	
}//List
