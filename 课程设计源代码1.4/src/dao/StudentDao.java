package dao;
import entity.IEntity;
import entity.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class StudentDao implements IDao {
	 
   
	private static StudentDao instance;
	private HashMap<String,IEntity> students;
	private Student student;
	private StudentDao() {
		students = new HashMap<String,IEntity>();
		student = new Student();
		student.setStudentNo("164801001");
		student.setStudentName("����");
		student.setStudentGender("��");
		student.setStudentPassword("123456");
		student.setStudentAge(20);
		student.setStudentDepartment("���ѧԺ");
		students.put(student.getStudentNo(), student);
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
		save();
	}

	@Override
	public void delete() {       //ɾ��ѧ����Ϣ
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {          //�޸�ѧ����Ϣ
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {     //�õ����еļ�ֵ�Լ�ѧ����Ϣ���ݿ�
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public IEntity getEntity(String Id) {          //���ݼ�ID1�õ�ֵ
		// TODO Auto-generated method stub		
		return students.get(Id);
	}
	public void save(){
		  try {
	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.txt"));
	            StudentDao stu = getInstance();
	            oos.writeObject(stu);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}
	 public StudentDao read(){
		  
	    	try {
	         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Student.txt"));
	         instance = (StudentDao) ois.readObject();
	       
	     } catch(Exception e) {
	         e.printStackTrace();
	     }
	    	
			return instance;
	    }
     
}
