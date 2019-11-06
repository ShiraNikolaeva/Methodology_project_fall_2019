package NikalayevaPfeiffer;

import java.time.LocalDate;
import java.util.ArrayList;

public class Playgroup {
	private String playgroupName;
	ArrayList<Parent>parentList=new ArrayList<Parent>();
	ArrayList<Child>childrenList=new ArrayList<Child>();
	
	public Playgroup(String name) {
		this.playgroupName=name;
	}
	//not adding transportation because it should be asked separately from the rest of the questions. it'll be updated later
	public void addChild(String fname,String lname, Time time,String allergies,
			LocalDate DOB,Parent parent,String num) throws Exception {
		Child ch=new Child(fname,lname,time,allergies,DOB,parent,num);
		//ensure that the child wasn't entered already
		if(!childrenList.isEmpty()) {
			for(int i=0;i<childrenList.size();i++) {
				if(!childrenList.get(i).equals(ch)) {
					childrenList.add(ch);
				}
				else {
					throw new Exception("This child is already in the system.");
				}
			}
		}
		else {
			childrenList.add(ch);
		}
	}
	public void addParent(String fname,String lname,String num,String address) throws Exception {
		Parent p=new Parent(fname,lname,num,address);
		//ensure that the parent wasn't already in the system
		if(!parentList.isEmpty()) {
			for(int i=0;i<parentList.size();i++) {
				if(!parentList.get(i).equals(p)) {
					parentList.add(p);
				}
				else {
					throw new Exception("This parent is already in the system.");
				}
			}
		}
		else {
			parentList.add(p);
		}
	}
	//all the edits for child
	//using fname,lname and DOB to ensure that changing appropriate child
	public void editChildFirstName(String fname,String lname,LocalDate DOB, String newName) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<childrenList.size();i++) {
			if(childrenList.get(i).getFirstName().equalsIgnoreCase(fname)&&childrenList.get(i).getLastName().equalsIgnoreCase(lname)
					&&childrenList.get(i).getDOB().equals(DOB)) {
				childrenList.get(i).setFirstName(newName);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	public void editChildLastName(String fname,String lname,LocalDate DOB, String newName) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<childrenList.size();i++) {
			if(childrenList.get(i).getFirstName().equalsIgnoreCase(fname)&&childrenList.get(i).getLastName().equalsIgnoreCase(lname)
					&&childrenList.get(i).getDOB().equals(DOB)) {
				childrenList.get(i).setLastName(newName);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	public void editTime(String fname,String lname,LocalDate DOB, Time newTime) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<childrenList.size();i++) {
			if(childrenList.get(i).getFirstName().equalsIgnoreCase(fname)&&childrenList.get(i).getLastName().equalsIgnoreCase(lname)
					&&childrenList.get(i).getDOB().equals(DOB)) {
				childrenList.get(i).setTimeInPlaygroup(newTime);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	public void editTransportation(String fname,String lname,LocalDate DOB, boolean tr) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<childrenList.size();i++) {
			if(childrenList.get(i).getFirstName().equalsIgnoreCase(fname)&&childrenList.get(i).getLastName().equalsIgnoreCase(lname)
					&&childrenList.get(i).getDOB().equals(DOB)) {
				childrenList.get(i).setTransportation(tr);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	public void editAllergies(String fname,String lname,LocalDate DOB, String al) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<childrenList.size();i++) {
			if(childrenList.get(i).getFirstName().equalsIgnoreCase(fname)&&childrenList.get(i).getLastName().equalsIgnoreCase(lname)
					&&childrenList.get(i).getDOB().equals(DOB)) {
				childrenList.get(i).setAllergies(al);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	//I'm not sure we need this one. I added it in case if we want to be more flexible
	public void editDOB(String fname,String lname,LocalDate DOB, LocalDate newDOB) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<childrenList.size();i++) {
			if(childrenList.get(i).getFirstName().equalsIgnoreCase(fname)&&childrenList.get(i).getLastName().equalsIgnoreCase(lname)
					&&childrenList.get(i).getDOB().equals(DOB)) {
				childrenList.get(i).setDOB(newDOB);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	public void editEmergencyContact(String fname,String lname,LocalDate DOB, String num) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<childrenList.size();i++) {
			if(childrenList.get(i).getFirstName().equalsIgnoreCase(fname)&&childrenList.get(i).getLastName().equalsIgnoreCase(lname)
					&&childrenList.get(i).getDOB().equals(DOB)) {
				childrenList.get(i).setEmergencyContact(num);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	//in main need to ensure that the parent exists. if not, user should be prompted for the rest of the info, create a parent and then call this method
	public void editChildParent(String fname,String lname,LocalDate DOB, Parent newParent) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<childrenList.size();i++) {
			if(childrenList.get(i).getFirstName().equalsIgnoreCase(fname)&&childrenList.get(i).getLastName().equalsIgnoreCase(lname)
					&&childrenList.get(i).getDOB().equals(DOB)) {
				//look for parent in parentList
				for(int j=0;j<parentList.size();j++) {
					if(parentList.get(j).equals(newParent)) {
						childrenList.get(i).setParent(newParent);
						done=true;
					}
				}
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	//all the parent edits
	public void editParentFirstName(String fname,String lname, String newName) throws Exception {
		//pull up the parent
		boolean done=false;
		for(int i=0;i<parentList.size();i++) {
			if(parentList.get(i).getFirstName().equalsIgnoreCase(fname)&&parentList.get(i).getLastName().equalsIgnoreCase(lname)) {
				parentList.get(i).setFirstName(newName);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	public void editParentLastName(String fname,String lname, String newName) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<parentList.size();i++) {
			if(parentList.get(i).getFirstName().equalsIgnoreCase(fname)&&parentList.get(i).getLastName().equalsIgnoreCase(lname)) {
				parentList.get(i).setLastName(newName);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	public void editParentPhoneNum(String fname,String lname, String newNum) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<parentList.size();i++) {
			if(parentList.get(i).getFirstName().equalsIgnoreCase(fname)&&parentList.get(i).getLastName().equalsIgnoreCase(lname)) {
				parentList.get(i).setPhoneNum(newNum);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	public void editParentAddress(String fname,String lname, String newAddress) throws Exception {
		//pull up the child
		boolean done=false;
		for(int i=0;i<parentList.size();i++) {
			if(parentList.get(i).getFirstName().equalsIgnoreCase(fname)&&parentList.get(i).getLastName().equalsIgnoreCase(lname)) {
				parentList.get(i).setAddress(newAddress);
				done=true;
			}
		}
		if(!done) {
			throw new Exception("There's not such a child in the system.");
		}
	}
	//I'm not sure if we need to protect the data, so I return original lists
	public ArrayList<Parent> listParents(){
		return parentList;
	}
	public ArrayList<Child> listChildren(){
		return childrenList;
	}
}
