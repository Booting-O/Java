package view;

import java.util.Scanner;

import biz.StudentBiz;

public class MainUI {
	
	public static void show() {
		
		System.out.println("******��ӭʹ��ѧ��ѡ��ϵͳ******\r\n");
		System.out.println("\t1-ѡ��γ�\r\n"
				+ "\t2-��ѡ�γ�\r\n"
				+ "\t3-�޸�����\r\n"
				+ "\t0-�˳���¼\r\n");
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
			System.out.print("���˳���¼\r\n");
			StartUI.show();
		
		}
	}
}
