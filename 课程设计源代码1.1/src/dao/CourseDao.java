package dao;
import entity.IEntity;
import entity.Course;

import java.util.HashMap;

public class CourseDao implements IDao {
	private static CourseDao instance;
	private HashMap<String, Course> Courses;
	private Course course;
	private CourseDao() {
		Courses = new HashMap<String, Course>();
		course = new Course();
		course.setCourseNo("001");
		course.setCourseName("大学物理");
		course.setCourseGrade(5);
		
		Courses.put(course.getCourseNo(),course);
	}

	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, entity.IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
