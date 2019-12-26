package biz;

import dao.StudentDao;

import entity.IEntity;
import entity.Student;
import view.*;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	public static String a;
	//登录
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在");
			MainUI.show();
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功");
			this.a=studentNo;
			MainUI.show();
		} else {
			System.out.println("密码不正确");
			MainUI.show();
		}

	}
	//注册，业务逻辑实现
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
			System.out.println("注册成功！");
			MainUI.show();
		}else {
			System.out.println("密码输入不一致， 请重新输入！");
			RegisterUI.show();
		}
		
	}
	public void panduan(String xh, String mm, String xmm, String x2mm){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(xh);
		if (student == null) {
			System.out.println("用户不存在!请重新输入：");
			ModifyPasswordUI.show();
			return;
		} else if(student.getStudentPassword().equals(mm)){
			student.setStudentPassword(xmm);
			studentDao.insert(student);
			System.out.println("修改成功！");
			MainUI.show();
		}
	}
	
}
