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
		System.out.println("请输入要退选课程编号");
		String courseNo = scanner.nextLine();
		csBiz.DelCourse(courseNo);
		
	}
}
