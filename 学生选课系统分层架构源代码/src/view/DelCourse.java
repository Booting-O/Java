package view;
import biz.*;
import java.util.Scanner;

public class DelCourse {

	public static void show() {
		// TODO Auto-generated method stub
		SCBiz csBiz = new SCBiz();
		csBiz.bianli();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ��ѡ�γ̱��");
		String courseNo = scanner.nextLine();
		csBiz.DelCourse(courseNo);
		
	}
}
