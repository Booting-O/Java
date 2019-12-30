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


/*public class CourseBiz {       //显示课程信息
     public static void show(){
    	 
    	 CourseDao courseDao = new CourseDao();
    	 Set keySet = courseDao.getAllEntities().keySet();
    	 Iterator it = keySet.iterator();
    	     System.out.println("------------大二上学期可选课程列表------------");
    	 while(it.hasNext()){
    		 Object key = it.next();
    		 Course value = (Course)courseDao.getAllEntities().get(key);
    		 System.out.println("*课程编号："+key+"------课程名称："+value.getCourseName()+"-----课程学分："+value.getCourseGrade()+"*");
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
	  System.out.println("当前用户"+StudentBiz.a);
	  if (course == null) {
			System.out.println("课程不存在");
			MainUI.show();
		} else if (!scBiz.pipei(courseNO)) {
			System.out.println("该课程已经选过");
			MainUI.show();
		} else {
			scBiz.addxk(courseNO);
			System.out.println("选课成功");
			MainUI.show();
		}
	}
	public void bianli() {
		// TODO Auto-generated method stub
	courses=courseDao.getAllEntities();
		
		
	}
	
	
	

}
/* 1、写一个创建课程对象的方法，保存到CourseDao
 * 2、从CourseDao中遍历课程、从StudentDao中遍历学生、从SCDao中遍历已选课程
 * 3、一个学生选择课程的方法，参数为int StudentNo
 * 4、将选的课，放入SCDao中，参数为int StudentNo
 * 5、判断是否已经登陆
 * 	    以防还未登陆就进行选课，思路：将学生ID和判断值用“，”连接在一起，构成一个字符串
 *    在判断是否登陆的方法中，进行解析字符串，分离出这两个值
示例代码：
	 
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