package biz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import dao.CourseDao;
import dao.StudentDao;
import entity.Course;
import entity.IEntity;
import entity.Student;
import view.MainUI;

public class CourseBiz {
	CourseDao courseDao;
	private Course course;
	SCBiz scBiz;
	String m=StudentBiz.a;
	private HashMap<String,IEntity> courses;
	
	
	public void selection(String courseNO){
	System.out.println("��ǰ�û�"+StudentBiz.a);
	  courseDao = CourseDao.getInstance();
	  course = (Course)courseDao.getEntity(courseNO);
	  scBiz=new SCBiz();
	  if (course == null) {
			System.out.println("�γ̲�����");
			MainUI.show();
		} else if (scBiz.pipei(courseNO)) {
			System.out.println("�ÿγ��Ѿ�ѡ��");
			MainUI.show();
		} else {
			scBiz.addxk(courseNO);
			System.out.println("ѡ�γɹ�");
			MainUI.show();
		}
	}
	public void bianli() {
		// TODO Auto-generated method stub
	courseDao = CourseDao.getInstance();
	  courses=courseDao.getAllEntities();
	   Iterator iter2=courses.keySet().iterator();
       while(iter2.hasNext()){
           String key=(String) iter2.next();
           course = (Course) courseDao.getEntity(key);
           System.out.println("�γ̺ţ�"+course.getCourseNo());
           System.out.println("�γ�����"+course.getCourseName());
           System.out.println("�γ�ѧ�֣�"+course.getCourseGrade());
       }
		
	}
	
	
	

}
