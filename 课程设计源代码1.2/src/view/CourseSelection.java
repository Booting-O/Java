package view;
import java.util.Scanner;

import biz.*;
import dao.*;
public class CourseSelection {

	private static CourseBiz courseBiz;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//StudentDao studentDao;
		  
		
			MainUI.show();
		
	}

	public static void show() {
		CourseBiz.list();
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫѡ�γ̱��");
		String courseNo = scanner.nextLine();
		courseBiz = new CourseBiz();
		courseBiz.selection(courseNo);
		}
	}
}
