package view;

import java.util.Scanner;

public class StartUI {
	public static void show() {
		System.out.println("******欢迎使用学生选课系统******\r\n");
		System.out.println("\t1-注册用户\r\n"
				+ "\t2-用户登录\r\n"
				+ "\t0-退出系统\r\n");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
switch (option) {
		
		case "1":
			RegisterUI.show();
			break;
		case "2":
			LoginUI.show();ModifyPasswordUI.show();
			break;
		case "0":
			System.out.print("已退出");
			break;
		}
		
		
	}
	
	

}
