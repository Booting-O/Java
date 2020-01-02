package biz;

import dao.StudentDao;

import entity.IEntity;
import entity.Student;
import view.*;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	public static String a;
	//��¼
	public void login(String studentNo, String studentPassword) {
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������!\r\n");
			LoginUI.show();
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			this.a=studentNo;
			System.out.println("��¼�ɹ�!");
			MainUI.show();
		} else {
			System.out.println("���벻��ȷ!");
			LoginUI.show();
		}

	}
	//ע�ᣬҵ���߼�ʵ��
	public void register(String studentNo, 
						String studentName, 
						String studentGender, 
						int studentAge, 
						String studentDepartment, 
						String firstPassword, 
						String secondPassword) {
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			save();
			System.out.println("ע��ɹ���");
			
			System.out.println("���¼��");
			LoginUI.show();
		}else {
			System.out.println("�������벻һ�£� ���������룡");
			RegisterUI.show();
		}
	}
	public void panduan(String xh, String mm, String xmm, String x2mm){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(xh);
		if (student == null) {
			System.out.println("�û�������!���������룺");
			LoginUI.show();
			return;
		} else if(student.getStudentPassword().equals(mm)){
			student.setStudentPassword(xmm);
			studentDao.insert(student);
			save();
			System.out.println("�޸ĳɹ���");
			System.out.println("�����������¼:");
			LoginUI.show();
		}
	}
	
	private void save() {
		StudentDao saveStudentDao = StudentDao.getInstance();
		saveStudentDao.update();
	}
	
}
