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
		System.out.println("��ѡ����Ŀγ̣�");
		CourseDao courseDao;
		courseDao.bianli();
		System.out.println("������Ҫѡ�γ̣�");
		String courseNo = scanner.nextLine();
		
		
	}
}
