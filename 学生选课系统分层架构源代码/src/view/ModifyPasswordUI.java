package view;

import java.util.Scanner;

import biz.*;

public class ModifyPasswordUI {
		
	public static void show() {
	Scanner  scanner = new Scanner(System.in);
		System.out.println("����ѧ�ţ�");
		String  xh = scanner.nextLine();
		System.out.println("�������룺");
		String  mm= scanner.nextLine();
		System.out.println("���������룺");
		String  xmm= scanner.nextLine();
		System.out.println("���ٴ��������룺");
		String  x2mm= scanner.nextLine();
		StudentBiz studentBiz = new StudentBiz();
		studentBiz.panduan(xh,mm,xmm,x2mm);

	}
	
}
