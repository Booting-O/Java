package dao;
import entity.IEntity;
import entity.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;

public class StudentDao implements IDao {
	private static StudentDao instance;
	private HashMap<String, Student> students;
	private Student student;
	private StudentDao() {
		students = new HashMap<String, Student>();
		student = new Student();
		getstudentFromInputStream("student.txt");
	}
	
	public void processUserString(String userString){
		String [] userFields = userString.split(",");
		Student u = new Student();
		u.setStudentNo(userFields[0]);
		u.setStudentName(userFields[1]);
		u.setStudentGender(userFields[2]);
		u.setStudentAge(Integer.parseInt(userFields[3]));
		u.setStudentDepartment(userFields[4]);
		u.setStudentPassword(userFields[5]);
		students.put(u.getStudentNo(),u);
	}

	private void getstudentFromInputStream(String isName){
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
	public static StudentDao getInstance() {
		if(instance == null) {
			synchronized(StudentDao.class) {
				if(instance == null) {
					instance = new StudentDao();
					return instance;
				}
			}
		}
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Set<String> userSet=students.keySet();
		StringBuffer uStringBuffer=new StringBuffer();
		for(String StudentNo:userSet) {
			Student u=(Student)students.get(StudentNo);
			String uString=u.getStudentNo()+","
					+u.getStudentName()+","
					+u.getStudentGender()+","
					+u.getStudentAge()+","
					+u.getStudentDepartment()+","
					+u.getStudentPassword()+"\r\n";
			uStringBuffer.append(uString);
		}
		putstudentsToFile(uStringBuffer.toString(),"student.txt");
	}

	private void putstudentsToFile(String uString,String osName) {
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
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return students.get(Id);
	}
     
}
