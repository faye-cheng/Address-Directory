package for_databaseFA;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class UtilityMethods {

	public static JButton makeButton(int theX, int theY, int theWidth, int theHeight, String theText,
			Color myCustomButtonColor, ActionListener theHandler, Container myCP, boolean theEnabled) {

		JButton buttonToReturn = new JButton(theText);
		buttonToReturn.setLocation(theX, theY);
		buttonToReturn.setSize(theWidth, theHeight);
		buttonToReturn.setBackground(myCustomButtonColor);
		buttonToReturn.addActionListener(theHandler);
		myCP.add(buttonToReturn);
		return buttonToReturn;
	}//9 parameter makeButton

	public static JLabel makeLabel(String text, int x, int y, int w, int h, Container theCP){
		JLabel labelToReturn = new JLabel(text);
		labelToReturn.setLocation(x, y);
		labelToReturn.setSize(w, h);
		theCP.add(labelToReturn);
		return labelToReturn;
	}//makeLabel


	public static JScrollPane makeScrollPane(JTextArea theClient, int x, int y, int w, int h, Container theCP){
		JScrollPane scrollPaneToReturn = new JScrollPane(theClient,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneToReturn.setLocation(x, y);
		scrollPaneToReturn.setSize(w, h);
		theCP.add(scrollPaneToReturn);
		return scrollPaneToReturn;
	}//makeLabel

	public static JTextField makeTextField(String text, int x, int y, int w, int h, Container theCP){
		JTextField textFieldToReturn = new JTextField(text);
		textFieldToReturn.setLocation(x, y);
		textFieldToReturn.setSize(w, h);
		theCP.add(textFieldToReturn);
		return textFieldToReturn;
	}//makeTextField

	public static void closingCausesExit(JFrame theWindow) {
		theWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line
	}//closingCausesExit

	private static <E> void swap (E[] theArray, int firstPos, int otherPos) {
		E temp = theArray[firstPos];
		theArray[firstPos] = theArray[otherPos];
		theArray[otherPos] = temp;
	}//swap

	public static <E extends Comparable<E>> void 
	sort( E[] theArray,int theSize){
		for(int passNum = 1; passNum < theSize; passNum++) {
			for (int j = 0; j < theSize - passNum; j++) {
				if(theArray[j+1].compareTo(theArray[j])<0) {
					swap(theArray,j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//sort by compareTo

	public static <E > void 
	sort( E[] theArray,int theSize, Comparator<E> theComparator){
		for(int passNum = 1; passNum < theSize; passNum++) {
			for (int j = 0; j < theSize - passNum; j++) {
				if(theComparator.compare(theArray[j+1],theArray[j])<0) {
					swap(theArray,j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//sort by compareTo

	public static <E> String arrayToString(E[] theArray, int theSize){
		String stringToReturn = "";
		for (int j = 0; j < theSize; j++) {
			stringToReturn += theArray [j] + "\n" + "\n"; //"\n" for the new line character
		}//for
		return stringToReturn;
	}//arrayToString


}//UtilityMethods
