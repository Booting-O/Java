package dao;
import entity.IEntity;
import entity.Student;
import entity.Course;

import java.util.HashMap;

public class CourseDao implements IDao {
	private static CourseDao instance;
	private HashMap<String,IEntity> courses;
	private Course course;
	private CourseDao() {
		courses = new HashMap<String,IEntity>();
		Course course1= new Course();
		course1.setCourseNo("001");
		course1.setCourseName("大学物理");
		course1.setCourseGrade(5);
		courses.put(course1.getCourseNo(),course1);		
	 /*   
		Course course2= new Course();
		course2.setCourseNo("002");
		course2.setCourseName("高等数学");
		course2.setCourseGrade(4);
		courses.put(course.getCourseNo(),course2);
	
		Course course3= new Course();
		course3.setCourseNo("003");
		course3.setCourseName("概率论");
		course3.setCourseGrade(4);
		courses.put(course.getCourseNo(),course3);
		
		
		Course course4= new Course();
		course4.setCourseNo("004");
		course4.setCourseName("linux");
		course4.setCourseGrade(3);
		courses.put(course.getCourseNo(),course4);
		
	
		Course course5= new Course();
		course5.setCourseNo("005");
		course5.setCourseName("java面向对象");
		course5.setCourseGrade(5);
		courses.put(course.getCourseNo(),course5);*/
	}
	public static CourseDao getInstance() {
		if(instance == null) {
			synchronized(CourseDao.class) {
				if(instance == null) {
					instance = new CourseDao();
					return instance;
				}
			}
		}
		return instance;
	}
	public void insert(IEntity entity) {     //管理员调用
		// TODO Auto-generated method stub
		Course st = (Course)entity;
		courses.put(st.getCourseNo(), st);
	}


	

	@Override
	public void delete() {       //管理员
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {        //管理员
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String,IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return courses;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return courses.get(Id);
	}

}
