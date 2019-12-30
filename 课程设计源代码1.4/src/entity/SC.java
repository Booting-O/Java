package entity;

import java.util.ArrayList;

public class SC implements IEntity {
	private String studentNo;
	private ArrayList<String> xk=new ArrayList<String>();
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public ArrayList<String> getxk(){	
		return xk; 
	}
	public void addxk(String i) {
		// TODO Auto-generated method stub
		this.xk.add(i);
	}
	
	
}
