package view;

import java.util.Scanner;

import biz.StudentBiz;

public class MainUI {
	
	public static void show() {
		
		System.out.println("******欢迎使用学生选课系统******\r\n");
		System.out.println("\t1-选择课程\r\n"
				+ "\t2-退选课程\r\n"
				+ "\t3-修改密码\r\n"
				+ "\t0-退出登录\r\n");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		
		
		case "1":
			CourseSelection.show();
			break;
		case "2":
			DelCourse.show();
			break;
		case "3":
			ModifyPasswordUI.show();
			break;
		case "0":
			System.out.print("已退出登录\r\n");
			StartUI.show();
		
		}
	}
}
