package view;

import java.util.Scanner;

import biz.*;

public class ModifyPasswordUI {
		
	public static void show() {
	Scanner  scanner = new Scanner(System.in);
		System.out.println("输入学号：");
		String  xh = scanner.nextLine();
		System.out.println("输入密码：");
		String  mm= scanner.nextLine();
		System.out.println("输入新密码：");
		String  xmm= scanner.nextLine();
		System.out.println("输再次入新密码：");
		String  x2mm= scanner.nextLine();
		StudentBiz studentBiz = new StudentBiz();
		studentBiz.panduan(xh,mm,xmm,x2mm);

	}
	
}
