package view;
import java.util.Scanner;

import dao.*;
public class CourseSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   StudentDao studentDao;
		  
		
			MainUI.show();
		
	}

	public static void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请选择你的课程：");
		CourseDao courseDao;
		courseDao.bianli();
		System.out.println("请输入要选课程：");
		String courseNo = scanner.nextLine();
		
		
	}
}
