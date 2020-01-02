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
	System.out.println("当前用户"+StudentBiz.a);
	  courseDao = CourseDao.getInstance();
	  course = (Course)courseDao.getEntity(courseNO);
	  scBiz=new SCBiz();
	  if (course == null) {
			System.out.println("课程不存在");
			MainUI.show();
		} else if (scBiz.pipei(courseNO)) {
			System.out.println("该课程已经选过");
			MainUI.show();
		} else {
			scBiz.addxk(courseNO);
			System.out.println("选课成功");
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
           System.out.println("课程号："+course.getCourseNo());
           System.out.println("课程名："+course.getCourseName());
           System.out.println("课程学分："+course.getCourseGrade());
       }
		
	}
	
	
	

}
