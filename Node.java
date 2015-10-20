package for_databaseFA;

public class Node <E>{

	private E myData;//reference to the data
	private Node<E> myLink;//reference to the next Node

	public Node(E theData, Node<E> theLink){
		myData = theData;
		myLink = theLink;
	}//2 param constructor

	public Node(E theData){
		myData = theData;
		myLink = null;
	}//1 param constructor

	public E getData(){
		return myData;
	}//getData

	public Node<E> getLink(){
		return myLink;
	}//getLink

	public void setData(E theData){
		myData = theData;
	}//setData

	public void setLink(Node<E> theLink){
		myLink = theLink;
	}//setLink

}//Node
