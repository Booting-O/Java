package biz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import dao.CourseDao;
import dao.StudentDao;
import entity.Course;
import entity.IEntity;
import entity.Student;
import view.MainUI;


/*public class CourseBiz {       //��ʾ�γ���Ϣ
     public static void show(){
    	 
    	 CourseDao courseDao = new CourseDao();
    	 Set keySet = courseDao.getAllEntities().keySet();
    	 Iterator it = keySet.iterator();
    	     System.out.println("------------�����ѧ�ڿ�ѡ�γ��б�------------");
    	 while(it.hasNext()){
    		 Object key = it.next();
    		 Course value = (Course)courseDao.getAllEntities().get(key);
    		 System.out.println("*�γ̱�ţ�"+key+"------�γ����ƣ�"+value.getCourseName()+"-----�γ�ѧ�֣�"+value.getCourseGrade()+"*");
    	 }
    	     System.out.println("----------------------------------------");
     }
}*/
public class CourseBiz {
	CourseDao courseDao;
	private Course course;
	SCBiz scBiz;
	String m=StudentBiz.a;
	private HashMap<String,IEntity> courses;
	public void selection(String courseNO){
	  courseDao = CourseDao.getInstance();
	  course = (Course) courseDao.getEntity(courseNO);
	  scBiz=new SCBiz();
	  System.out.println("��ǰ�û�"+StudentBiz.a);
	  if (course == null) {
			System.out.println("�γ̲�����");
			MainUI.show();
		} else if (!scBiz.pipei(courseNO)) {
			System.out.println("�ÿγ��Ѿ�ѡ��");
			MainUI.show();
		} else {
			scBiz.addxk(courseNO);
			System.out.println("ѡ�γɹ�");
			MainUI.show();
		}
	}
	public void bianli() {
		// TODO Auto-generated method stub
	courses=courseDao.getAllEntities();
		
		
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