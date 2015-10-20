package for_databaseFA;

import java.util.*; 
import java.io.*; 

public class WCSBinaryTree<E extends Comparable <E>> {

	private TreeNode<E> myRoot;  //First node for the tree
	private boolean addSuccessful; //Add is successful
	private boolean deleteSuccessful; //Delete is successful 
	private E objectBeingAdded;  //Data being added
	private E objectSearchedFor; //Object being search for 
	private E objectToDelete; //Object to delete.
	private Comparator<E> myComparator; //The comparator 
	private int myCount; //The number of items in the list. 
	private String messageFromSave;//Message displayed
	private ObjectOutputStream oOS; 

	public WCSBinaryTree() {
		myRoot = null;
		myComparator = null; 
		myCount = 0;
	}//0 parameter constructor 

	public WCSBinaryTree(Comparator <E> theComparator){
		myRoot = null; 
		myComparator = theComparator; 
		myCount = 0;

	}//1 parameter constructor 

	private int myCompare (E firstE, E secondE){
		if(myComparator == null){
			return firstE.compareTo(secondE);
		}//no comparator 
		return myComparator.compare(firstE, secondE);
	}

	public int getCount(){
		return myCount;
	}// get count 

	public boolean isEmpty(){
		return myRoot==null;
	}

	public boolean add(E addMe){
		addSuccessful = false; 
		objectBeingAdded = addMe;
		myRoot = add(myRoot);
		if(addSuccessful){
			myCount++;
		}//if add successful
		return addSuccessful; 
	}// public add

	private TreeNode<E> add(TreeNode<E> currentRoot){
		if(currentRoot == null) {
			addSuccessful = true;
			return new TreeNode<E> (objectBeingAdded);
		}//we found correct place for the add
		if(objectBeingAdded.equals(currentRoot.myData)){
			return currentRoot;
		}// duplicate found 
		if(myCompare(objectBeingAdded, currentRoot.myData)<0){
			currentRoot.myLeft = add(currentRoot.myLeft);
			return currentRoot; 
		}// if we recurse left
		currentRoot.myRight = add(currentRoot.myRight);
		return currentRoot; 
	}// private add

	public String toString(){
		return toString(myRoot);		
	}

	private String toString(TreeNode<E> currentRoot){
		if(currentRoot == null){
			return ""; 
		}//if
		return toString(currentRoot.myLeft) + currentRoot.myData + " " + toString(currentRoot.myRight);
	}//private toString

	public E search(E findMe){
		objectSearchedFor = findMe;
		return search(myRoot);
	}//public search

	private E search(TreeNode<E> currentRoot){
		if(currentRoot == null){
			return null;
		}//if object not in tree
		if(objectSearchedFor.equals(currentRoot.myData)){
			return currentRoot.myData;
		}//found the object 
		if(myCompare(objectSearchedFor, currentRoot.myData)<0){
			return search(currentRoot.myLeft);
		}//search left sub tree
		return search(currentRoot.myRight); //search right subtree
	}//private search 

	public boolean delete(E deleteMe){
		objectToDelete = deleteMe;
		deleteSuccessful = false;
		myRoot = delete(myRoot);
		if(deleteSuccessful){
			myCount--;
		}
		return deleteSuccessful;
	}//public delete


	private TreeNode<E> delete(TreeNode<E> currentRoot){
		if(currentRoot == null) {
			deleteSuccessful = true;
			return currentRoot;
		}//no deletion
		if(objectToDelete.equals(currentRoot.myData)){
			deleteSuccessful = true; 
			if(currentRoot.myRight ==null && currentRoot.myLeft == null){
				return null;
			}//if no children 
			if(currentRoot.myLeft == null){
				return currentRoot.myRight;
			}//if there was one child on the right
			if(currentRoot.myRight == null){
				return currentRoot.myLeft;
			}//if there was one child on the left
			TreeNode<E> temp = currentRoot.myLeft;
			while(temp.myRight != null){
				temp = temp.myRight;
			}//while
			temp.myRight = currentRoot.myRight; 
			return currentRoot.myLeft;
		}// duplicate found 
		if(myCompare(objectToDelete, currentRoot.myData)<0){
			currentRoot.myRight = delete(currentRoot.myRight);
			return currentRoot; 
		}// if we recurse left
		currentRoot.myRight = delete(currentRoot.myRight);
		return currentRoot; 
	}// private add

	public String saveToFile(String fileName){
		messageFromSave = "";
		try{
			ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
			saveToFile(myRoot);
			oOS.flush();
			oOS.close();
		}//try
		catch(Exception e){
			messageFromSave = e.toString();
		}//catch
		return messageFromSave;
	}//public saveToFile 


	private void saveToFile(TreeNode<E> currentRoot){
		try{
			if(currentRoot != null){
				oOS.writeObject(currentRoot.myData);
				saveToFile(currentRoot.myLeft);
				saveToFile(currentRoot.myRight);
			}// if
		}//try 
		catch(Exception e){
			messageFromSave +=e.toString();
		}//catch
	}//private saveToFile

}///WCSBinaryTree
