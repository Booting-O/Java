package view;
import java.util.Scanner;

import biz.*;
import dao.*;
public class CourseSelection {

	static CourseBiz courseBiz;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//StudentDao studentDao;
		  
		//CourseBiz.list();
			MainUI.show();
		
	}
	public static void List(){
		
	}
	
	public static void show() {
		courseBiz = new CourseBiz();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ǰ�γ��У�");
		courseBiz.bianli();
		System.out.println("������Ҫѡ�γ̱��");
		String courseNo = scanner.nextLine();
		courseBiz.selection(courseNo);
		}
	
	}

