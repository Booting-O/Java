package biz;

import java.util.ArrayList;

import dao.SCDao;
import dao.StudentDao;
import entity.SC;
import entity.Student;

public class SCBiz {
	SCDao scDao;
	SC sc;
	private String m=StudentBiz.a;
	private ArrayList xk;
	public  boolean pipei(String courseNO) {
		int b = 0;
		scDao=SCDao.getInstance();
		sc = (SC) scDao.getEntity(m);
		xk=sc.getxk();
		for (int i = 0; i < xk.size(); i++) { 
			if (xk.get(i) == courseNO) { 		  
			b=1;			  					  
			} 			  
			}
		if(b==1){
			return true;
		}else{
			return false;
		}
		// TODO Auto-generated method stub
	}
	public void addxk(String courseNO) {
		// TODO Auto-generated method stub
		scDao=SCDao.getInstance();
		sc = (SC) scDao.getEntity(m);
		xk=sc.getxk();
		xk.add(courseNO);
	}

}
