package dao;
import entity.IEntity;
import entity.Student;
import entity.Course;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;

public class CourseDao implements IDao {
	private static CourseDao instance;
	private HashMap<String,IEntity> courses;
	private Course course;
	private CourseDao() {
		courses = new HashMap<String, IEntity>();
		course = new Course();
		getcourseFromInputStream("course.txt");
	}
	public void processUserString(String userString){
		String [] userFields = userString.split(",");
		Course u = new Course();
		u.setCourseNo(userFields[0]);
		u.setCourseName(userFields[1]);
		u.setCourseGrade(Integer.parseInt(userFields[2]));
		courses.put(u.getCourseNo(),u);
	}

	private void getcourseFromInputStream(String isName){
		try{
			FileInputStream fs = new FileInputStream(isName);
			byte[] content = new byte[1024];
			int i=0;
			int conInteger = 0;
			while(true){
			    try{
			        conInteger = fs.read();
			    } catch (Exception e){
			       e.printStackTrace();
			    }
			    if(-1 == conInteger){
			         break;
			    }else if('\r' == (char)conInteger || '\n' == (char)conInteger){
			        try{
			        	this.processUserString(new String(content,"GBK").trim());
				         i=0;
			        } catch (Exception e){
			           e.printStackTrace();
			        }
			        continue;
			    } else{
			        content[i] = (byte)conInteger;
			        i++;
			    }   
			}
		}catch(Exception e){
			e.printStackTrace();
		}
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
	public void update() {
		// TODO Auto-generated method stub
		Set<String> userSet=courses.keySet();
		StringBuffer uStringBuffer=new StringBuffer();
		for(String CourseNo:userSet) {
			Course u=(Course)courses.get(CourseNo);
			String uString=u.getCourseNo()+","
					+u.getCourseName()+","
					+u.getCourseGrade()+"\r\n";
			uStringBuffer.append(uString);
		}
		putcoursesToFile(uStringBuffer.toString(),"course.txt");
	}

	private void putcoursesToFile(String uString,String osName) {
		try {
			FileOutputStream fos = new FileOutputStream(osName);
			try {
				fos.write(uString.getBytes("GBK"));
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
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
