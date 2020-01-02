package biz;

import java.util.ArrayList;
import java.util.HashMap;

import dao.CourseDao;
import dao.SCDao;
import dao.StudentDao;
import entity.Course;
import entity.IEntity;
import entity.SC;
import entity.Student;
import view.DelCourse;
import view.MainUI;

public class SCBiz {
	SCDao scDao;
	SC sc;
	CourseDao courseDao;
	Course course;
	private HashMap<String,IEntity> scs;
	String m=StudentBiz.a;
	ArrayList<String> xk;
	private String a,c;
	public  boolean pipei(String courseNO) {
		int b = 0;
		a=courseNO;
		scDao=SCDao.getInstance();
		sc=(SC)scDao.getEntity(m); 
		xk=sc.getxk();
		for (int i = 0; i < xk.size(); i++) { 
			this.c=xk.get(i);
			if (a.equals(c)) { 	
			b=1;
			break;
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
	    
	    xk.add(0, courseNO);
	    sc.setxk(xk);
	    scDao.insert(sc);
	    save();
	}
	
	
	public void bianli() {
		// TODO Auto-generated method stub
		int b=0;
		 scDao=SCDao.getInstance();
		  sc=(SC) scDao.getEntity(m);
		  xk=sc.getxk();
		  courseDao = CourseDao.getInstance();
		  
			for(int i=0;i<xk.size();i++){
				course = (Course)courseDao.getEntity(xk.get(i));
				if(course!=null) {
				System.out.println("课程号："+course.getCourseNo());
		        System.out.println("课程名："+course.getCourseName());
		        System.out.println("课程学分："+course.getCourseGrade());	
				}else {
					b=1;
					break;
				}	
				}
			if(b==1) {
				System.out.println("你还没有选择任何课程");
				MainUI.show(); 
			}	
	}
	
	public void DelCourse(String courseNo) {
		// TODO Auto-generated method stub
		int a=0,b=0,c=0;
		  scDao=SCDao.getInstance();
		  sc=(SC) scDao.getEntity(m);
		  xk=sc.getxk();  
		  b=xk.size();
		  for(int i=0;i<b;i++){
			  if(xk.get(i).equals(courseNo)){
				  a=1;	  
				  xk.remove(i);
				  xk.add(b-1, null);
				  sc.setxk(xk);
				  scDao.insert(sc);
				  save();
				  System.out.println("退选成功");
				  break;
			  }
			  
		  }
		  if(a==0) {
			  System.out.println("退选失败，还没有选择该课程：");
			  MainUI.show();
		  }else{
			 MainUI.show(); 
		  }  
	}
	public void save() {
		// TODO Auto-generated method stub
		SCDao saveSCDao = SCDao.getInstance();
		saveSCDao.update();
	}
	

}
