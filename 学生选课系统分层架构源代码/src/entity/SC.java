package entity;

import java.util.ArrayList;

public class SC implements IEntity {
	private String studentNo;
	public ArrayList<String> xk=new ArrayList<String>();
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public ArrayList<String> getxk(){	
		return xk; 
	}
	public void setxk(ArrayList<String> xk){	
		this.xk=xk;
	}
	public void addxk(String i) {
		// TODO Auto-generated method stub
		this.xk.add(i);
	}
	
	
	
	
}
