package view;

import java.util.Scanner;

public class StartUI {
	public static void show() {
		System.out.println("******��ӭʹ��ѧ��ѡ��ϵͳ******\r\n");
		System.out.println("\t1-ע���û�\r\n"
				+ "\t2-�û���¼\r\n"
				+ "\t0-�˳�ϵͳ\r\n");
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
			System.out.print("���˳�");
			break;
		}
		
		
	}
	
	

}
