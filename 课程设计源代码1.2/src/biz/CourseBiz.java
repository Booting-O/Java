package biz;
import dao.CourseDao;
import dao.StudentDao;
import entity.Course;
import entity.Student;
import view.MainUI;


public class CourseBiz {
	CourseDao courseDao;
	private Course course;
	public void selection(String CourseNO){
	  courseDao = CourseDao.getInstance();
	  course = (Course) courseDao.getEntity(CourseNO);
	  if (course == null) {
			System.out.println("�γ̲�����");
			return;
		} else if (SCBiz.pipei()) {
			System.out.println("�ÿγ��Ѿ�ѡ��");
		} else {
		    
			
		}
	  

		
		
	}
	
	
	

}
/* 1��дһ�������γ̶���ķ��������浽CourseDao
 * 2����CourseDao�б����γ̡���StudentDao�б���ѧ������SCDao�б�����ѡ�γ�
 * 3��һ��ѧ��ѡ��γ̵ķ���������Ϊint StudentNo
 * 4����ѡ�ĿΣ�����SCDao�У�����Ϊint StudentNo
 * 5���ж��Ƿ��Ѿ���½
 * 	    �Է���δ��½�ͽ���ѡ�Σ�˼·����ѧ��ID���ж�ֵ�á�����������һ�𣬹���һ���ַ���
 *    ���ж��Ƿ��½�ķ����У����н����ַ����������������ֵ
ʾ�����룺
	 
	public static void studentChooseCourse() {
		String info=studentLogin();
		while(true){
			String[] infos=info.split(",");
			String flag =infos[1];
			int stuID =Integer.parseInt(infos[0]);
			if (flag.equals("false")) {
				System.out.println("Please login first!");
				info=studentLogin();
			} else {
				studentChooseCourse(stuID);
			}
		}
 }
	

 */