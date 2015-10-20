package for_databaseFA;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Database extends JFrame {

	private List myList;

	private JButton addB; // adds user's info to the DB
	private JButton displayAlphaB;// button for displaying info in the DB by
	// Alpha
	private JButton displayAddressB;// button for displaying info in the DB by
	// Address
	private JButton searchB;// searches for name in the DB
	private JButton deleteB;// deletes info from the DB
	private JButton confirmDeleteB;// confirms deletion
	private JButton cancelDeleteB;// cancels deletion
	private JButton loadB;// loads a file
	private JButton saveB;// saves a file
	private JButton clearB;//clear fields

	private JLabel loadL;// label for the load button
	private JLabel saveL;// label for the save button
	private JLabel instructionsL;// label to display instructions to the user
	private JLabel firstNameL;// tells user where to enter their first name
	private JLabel middleNameL;// tells user where to enter their middle name
	private JLabel familyNameL;// tells user where to enter their last name
	private JLabel streetAddressL;// tells user where to enter their street
	// address
	private JLabel streetAddressOptionalL;// tells user where to enter their opt
	// street address
	private JLabel cityL;// tells user where to enter their city
	private JLabel zipcodeL;// tells user where to enter their zip code
	private JLabel fileNameL;// tells user where to enter the file name
	private JLabel stateL;// label for the state combo box
	private JLabel messageL;// label to tell user where messages are displayed

	private JTextField firstNameTF;// where first name should be entered
	private JTextField middleNameTF;// where middle name should be entered
	private JTextField familyNameTF;// where last name should be entered
	private JTextField streetAddressTF;// where street address should be entered
	private JTextField streetAddressOptionalTF;// where street address opt line
	// should be entered
	private JTextField cityTF;// where city name should be entered
	private JTextField zipcodeTF;// where zip code should be entered
	private JTextField fileNameTF;// where file name should be entered
	private JTextField messageTF;// where messages display

	private JComboBox stateCB;// dropdown menu for the states
	private JTextArea infoListTA;// text area to display contents of the
	// database
	private JScrollPane infoListSP;// scroll pane for the text area

	private Container myCP;// reference to the content pane of the JFrame

	// List to hold AddressInfos for address sorting
	private List<AddressInfo> myAddressList = new List<>(
			AddressInfo.ADDRESS_COMPARATOR);
	// List to hold AddressInfos for alphabetical sorting
	private List<AddressInfo> myAlphaList = new List<>();
	private AddressInfo found; 
	private boolean processingDelete;
	private boolean processingSave;
	private boolean duplicateRecord;

	private String fileName; // reference to a file being processed by a save or
	// load command
	private AddressInfo currentPIRecord; // a record currently being entered and
	// a record found in the list memory
	private String errorMsg;// message for validNameInput method
	private String fName;// to pass firstname of validNameInput method
	private String lName;// to pass family name from validNameInput method

	Color myCustomBackgroundColor = new Color(200, 200, 200);
	Color myCustomButtonColor = new Color(243, 243, 243);
	Color myCustomOptionalColor = new Color(190, 190, 190);

	public Database() { // constructor for class Database
		super("Database Entry Form");
		myCP = getContentPane();
		myCP.setLayout(null);
		setSize(850, 520);
		setLocation(100, 100);
		myCP.setBackground(myCustomBackgroundColor);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}// windowClosing
		}); // end of definition of WindowAdapter and semicolon to end the line

		ConstructComboBox();
		ConstructAllButtons();
		ConstructAllLabels();
		ConstructAllTextFields();
		ConstructTextArea();
		ConstructScrollPane();

		processingSave = false;
		processingDelete = false;
		duplicateRecord = false;
		setVisible(true);

	} // Database constructor

	public void ConstructComboBox() {

		stateCB = new JComboBox(Address.STATES);
		stateCB.setSize(60, 22);
		stateCB.setLocation(238, 300);
		myCP.add(stateCB);

	} // ConstructComboBox

	public void ConstructAllButtons() {

		addB = UtilityMethods.makeButton(30, 360, 128, 22, "Add",
				myCustomButtonColor, (ActionEvent e) -> attemptToAdd(), myCP,
				true);
		displayAlphaB = UtilityMethods.makeButton(400, 90, 185, 30,
				"Alpha Display", myCustomButtonColor,
				(ActionEvent e) -> alphaSortAndDisplayClicked(), myCP, true);
		displayAddressB = UtilityMethods.makeButton(610, 90, 185, 30,
				"Address Display", myCustomButtonColor,
				(ActionEvent e) -> addressSortandDisplayClicked(), myCP, true);
		searchB = UtilityMethods.makeButton(400, 180, 185, 30, "Search",
				myCustomButtonColor, (ActionEvent e) -> searchClicked(), myCP,
				true);
		deleteB = UtilityMethods.makeButton(165, 360, 128, 22, "Delete",
				myCustomBackgroundColor, (ActionEvent e) -> deleteClicked(), myCP,
				true);
		confirmDeleteB = UtilityMethods.makeButton(30, 390, 128, 22, "Confirm",
				myCustomButtonColor, (ActionEvent e) -> confirmClicked(), myCP,
				false);
		cancelDeleteB = UtilityMethods.makeButton(165, 390, 128, 22, "Cancel",
				myCustomButtonColor, (ActionEvent e) -> cancelClicked(), myCP,
				false);
		loadB = UtilityMethods.makeButton(165, 425, 128, 22, "Load",
				myCustomButtonColor, (ActionEvent e) -> loadClicked(), myCP,
				true);
		saveB = UtilityMethods.makeButton(30, 425, 128, 22, "Save",
				myCustomButtonColor, (ActionEvent e) -> saveClicked(), myCP,
				true);

		clearB = UtilityMethods.makeButton(610, 180, 185, 30, "Clear",
				myCustomButtonColor, (ActionEvent e) -> reset(), myCP,
				true);
	} // ConstructAllButtons

	private void alphaSortAndDisplayClicked() {

		myAlphaList.bubbleSort();
		infoListTA.setText(myAlphaList.toString());
		messageTF.setText("");
	} // alphaSortAndDisplayClicked

	private void addressSortandDisplayClicked() {
		myAddressList.bubbleSort();
		infoListTA.setText(myAddressList.toString());
		messageTF.setText("");
	} // addressSortAndDisplayClicked

	private void searchClicked() {
		String firstName = firstNameTF.getText();
		String middleName = middleNameTF.getText();
		String lastName = familyNameTF.getText();

		if (firstName.equals("")) {
			messageTF.setText("Error. Please enter first name");
			return;
		}// if
		if (middleName.equals("")) {
			messageTF.setText("Error. Please enter middle name");
			return;
		}// if
		if (lastName.equals("")) {
			messageTF.setText("Error. Please enter last name");
			return;
		}// if
		AddressInfo userInfo = new AddressInfo(firstName, middleName, lastName);
		AddressInfo found = (AddressInfo) myAlphaList.search(userInfo);
		if (found == null) {
			messageTF.setText(userInfo + " was not found.");
		} else {
			infoListTA.setText(found.toString());
			messageTF.setText("");
		} // else
		firstNameTF.setText("");
		middleNameTF.setText("");
		familyNameTF.setText("");
		streetAddressTF.setText("");
		streetAddressOptionalTF.setText("");
		cityTF.setText("");
		stateCB.setSelectedIndex(0);
		zipcodeTF.setText("");

	} // searchClicked

	private void deleteClicked() {
		
		adjustButtons(false);
		
		String firstName = firstNameTF.getText();
		String middleName = middleNameTF.getText();
		String lastName = familyNameTF.getText();

		if (firstName.equals("")) {
			messageTF.setText("Error. Please enter first name");
			return;
		}// if
		if (middleName.equals("")) {
			messageTF.setText("Error. Please enter middle name");
			return;
		}// if
		if (lastName.equals("")) {
			messageTF.setText("Error. Please enter last name");
			return;
		}// if
		AddressInfo userInfo = new AddressInfo(firstName, middleName, lastName);
		found = (AddressInfo) myAlphaList.search(userInfo);
		if (found == null) {
			messageTF.setText(userInfo + " was not found.");
		} else {
			infoListTA.setText(found.toString());
			processingDelete = true;
			messageTF.setText("Please press confirm or cancel to proceed.");
		} // else

		firstNameTF.setText("");
		middleNameTF.setText("");
		familyNameTF.setText("");
		streetAddressTF.setText("");
		streetAddressOptionalTF.setText("");
		cityTF.setText("");
		stateCB.setSelectedIndex(0);
		zipcodeTF.setText("");

	}// deleteClicked

	private void confirmClicked() {
		if (processingDelete) {
			
			if (myAlphaList.delete(found)) {
				messageTF.setText("Delete successful.");
			} else {
				messageTF.setText("Delete failed.");
			} // else
			
			if (myAddressList.delete(found)) {
				messageTF.setText("Delete successful.");
			} else {
				messageTF.setText("Delete failed.");
			} // else
			
			processingDelete = false;
			adjustButtons(true);
		} // if

		if (processingSave) {
			String errmsg = myAlphaList.saveToFile(fileName);
			messageTF.setText(fileName + " overwritten.\n" + errmsg + "\n");
			processingSave = false;
		} else if (duplicateRecord) {
			if (myAlphaList.delete(found)) {
				if (myAlphaList.add(currentPIRecord)) {
					messageTF.setText("\nRecord for" + currentPIRecord.getName() + " changed.\n");
				} else {
					messageTF.setText("\nError in adding new record. " + fName + " " + lName + " delete from DB.\n");
				} //else
			} else {
				messageTF.setText("\nError in deleting old record. No change in DB.\n");
			} //inner else
			duplicateRecord = false;
		} else if (processingDelete) {
			if (myAlphaList.delete(found)) {
				messageTF.setText("The record for " + found + " was deleted.");
			} else {
				messageTF.setText("Failure occurred in deleting " + found + ".\n");
			} //else
			processingDelete = false;
		} //else
		reset();
		adjustButtons(true);
	} // confirmedClicked

	private void cancelClicked() {
		if (processingDelete) {
			messageTF.setText("Delete request cancelled.");
			adjustButtons(true);
		} // if

		if (processingSave) {
			processingSave = false;
			messageTF.setText("Save request cancelled.");
		} //if
		reset();
		adjustButtons(true);
	} // cancelClicked

	private String getUserInput(JTextField theTF, String theText) {
		String userInput = theTF.getText();
		if (userInput.equals("")) {
			errorMsg += "You need to enter a " + theText + " name.\n";
		}// if
		return userInput;
	}// getUserInput

	public boolean validNameInput() {
		errorMsg = "";
		fName = getUserInput(firstNameTF, "first");
		lName = getUserInput(familyNameTF, "family");
		return errorMsg.equals("");
	}// validNameInput method


	private void clearInputFields() {
		familyNameTF.setText("");
		firstNameTF.setText("");
		firstNameTF.setText("");
		middleNameTF.setText("");
		streetAddressTF.setText("");
		streetAddressOptionalTF.setText("");
		cityTF.setText("");
		zipcodeTF.setText("");
		fileNameTF.setText("");

		messageTF.setText("");
		infoListTA.setText("");
	}// clearInputFields

	private void adjustButtons(boolean tFValue) {
		addB.setEnabled(tFValue);
		saveB.setEnabled(tFValue);
		displayAlphaB.setEnabled(tFValue);
		displayAddressB.setEnabled(tFValue);
		searchB.setEnabled(tFValue);
		deleteB.setEnabled(tFValue);
		loadB.setEnabled(tFValue);
		confirmDeleteB.setEnabled(!tFValue);
		cancelDeleteB.setEnabled(!tFValue);
	}// adjustButtons

	private void reset() {
		adjustButtons(true);
		clearInputFields();
	}// reset

	private void loadClicked() {
		messageTF.setText("");
		fileName = fileNameTF.getText();
		if (fileName.compareTo("") > 0) {
			File theFile = new File(fileName);
			if (!theFile.exists()) {
				messageTF.setText(fileName
						+ " does not exist - cannot load data\n");
			} else if (!theFile.canRead()) {
				messageTF.setText("Cannot read from " + fileName + "\n");
			} else if (theFile.isDirectory()) {
				messageTF.setText(fileName + " is a directory. Please enter"
						+ " a file name.");
			} else {
				String fromLoad = myAlphaList.loadFromFile(fileName);
				String fromLoad2 = myAddressList.loadFromFile(fileName);
				messageTF.setText("Data loaded from " + fileName + "\n" + "\n"
						+ fromLoad + "\n");
			}// else
			clearInputFields();
		} else {
			messageTF.setText("You must enter a file name "
					+ "in order to load a file");
		}// else
	}// loadClicked

	private void saveClicked() {
		fileName = fileNameTF.getText();
		infoListTA.setText("");
		String message = "";
		if(fileName.compareTo("") > 0){
			File theFile = new File(fileName);
			if(!theFile.exists()){
				message = myAlphaList.saveToFile(fileName);
				messageTF.setText("Data saved to file " + fileName+ ".\n"
						+ message + "\n");
			}else if(theFile.isDirectory()){
				messageTF.setText("Error: " + fileName + " is a directory.\n");
			}else if(!theFile.canWrite()){
				messageTF.setText("Cannot write data to " + fileName + "\n");
			}else{
				adjustButtons(false);
				processingSave = true;
				messageTF.setText("\nPress confirm to overwrite file " + 
						fileName + "\nor press Cancel to cancel save request.\n");
				infoListTA.setText("");
			}//else
		}else{
			messageTF.setText("You must enter a file name in order to save a file.");
		}//else

	} //saveClicked


	public void ConstructAllLabels() {

		instructionsL = UtilityMethods.makeLabel(
				"[Please Enter All of the Following Information]", 30, 8, 300,
				40, myCP);
		firstNameL = UtilityMethods.makeLabel("First Name:", 30, 50, 200, 20,
				myCP);
		middleNameL = UtilityMethods.makeLabel("Middle Name:", 30, 80, 200, 20,
				myCP);
		familyNameL = UtilityMethods.makeLabel("Last Name:", 30, 110, 200, 20,
				myCP);
		streetAddressL = UtilityMethods.makeLabel("Street Address 1:", 30, 150,
				200, 20, myCP);
		streetAddressOptionalL = UtilityMethods.makeLabel("Street Address 2:",
				30, 200, 200, 20, myCP);
		cityL = UtilityMethods.makeLabel("City:", 30, 262, 200, 20, myCP);
		zipcodeL = UtilityMethods.makeLabel("Zipcode:", 30, 300, 200, 20, myCP);
		stateL = UtilityMethods.makeLabel("State:", 198, 300, 100, 20, myCP);
		fileNameL = UtilityMethods.makeLabel("File Name:", 400, 140, 200, 20,
				myCP);
		messageL = UtilityMethods.makeLabel("Message:", 400, 50, 200, 20, myCP);
	} // ConstructAllLabels

	public void ConstructAllTextFields() {

		firstNameTF = UtilityMethods.makeTextField("", 120, 50, 175, 20, myCP);
		middleNameTF = UtilityMethods.makeTextField("", 120, 80, 175, 20, myCP);
		familyNameTF = UtilityMethods
				.makeTextField("", 120, 110, 175, 20, myCP);
		streetAddressTF = UtilityMethods.makeTextField("", 30, 170, 264, 20,
				myCP);
		streetAddressOptionalTF = UtilityMethods.makeTextField("(Optional)",
				30, 220, 264, 20, myCP);
		streetAddressOptionalTF.setForeground(myCustomOptionalColor);
		cityTF = UtilityMethods.makeTextField("", 85, 262, 210, 20, myCP);
		zipcodeTF = UtilityMethods.makeTextField("", 95, 300, 80, 20, myCP);
		fileNameTF = UtilityMethods.makeTextField("", 470, 140, 320, 20, myCP);
		messageTF = UtilityMethods.makeTextField("", 470, 50, 320, 20, myCP);
	} // ConstructAllTextFields

	public void ConstructTextArea() {

		infoListTA = new JTextArea();
		infoListTA.setSize(390, 225);
		infoListTA.setLocation(400, 230);
		infoListTA.setEditable(false);
		myCP.add(infoListTA);
	} // ConstructTextArea

	public void ConstructScrollPane() {

		infoListSP = UtilityMethods.makeScrollPane(infoListTA, 400, 230, 390,
				225, myCP);
	} // ConstructScrollPane

	public void attemptToAdd() {
		String firstName = firstNameTF.getText();
		String middleName = middleNameTF.getText();
		String lastName = familyNameTF.getText();
		String streetAddress = streetAddressTF.getText();
		String streetAddressOpt = streetAddressOptionalTF.getText();
		String cityName = cityTF.getText();
		String stateName = (String) stateCB.getSelectedItem();
		String zipName = zipcodeTF.getText();

		if (firstName.equals("")) {
			messageTF.setText("Error. Please enter first name");
			return;
		}// if

		if (middleName.equals("")) {
			messageTF.setText("Error. Please enter middle name");
			return;
		}// if

		if (lastName.equals("")) {
			messageTF.setText("Error. Please enter last name");
			return;
		}// if

		if (streetAddress.equals("")) {
			messageTF.setText("Error. Please enter street name");
			return;
		}// if

		if (cityName.equals("")) {
			messageTF.setText("Error. Please enter city name");
			return;
		}// if

		if (stateName.equals("--")) {
			messageTF.setText("Error. Please enter state name");
			return;
		}// if

		if (zipName.equals("")) {
			messageTF.setText("Error. Please enter zip name");
			return;
		}// if

		// Make AddressInfo out of user input
		AddressInfo userInfo = new AddressInfo(firstName, middleName, lastName,
				streetAddress, streetAddressOpt, cityName, stateName, zipName);

		if (myAlphaList.add(userInfo)) {
			messageTF.setText("The AddressInfo was added.");
		} else {
			messageTF.setText("The AddressInfo was not added.");
		}// else

		if (myAddressList.add(userInfo)) {
			messageTF.setText("The AddressInfo was added.");
		} else {
			messageTF.setText("The AddressInfo was not added.");
		}// else

		firstNameTF.setText("");
		middleNameTF.setText("");
		familyNameTF.setText("");
		streetAddressTF.setText("");
		streetAddressOptionalTF.setText("");
		cityTF.setText("");
		stateCB.setSelectedIndex(0);
		zipcodeTF.setText("");
	}// attemptToAdd

	public static void main(String[] args) {
		final Database myAppF = new Database();
	}// main

} // class Database
