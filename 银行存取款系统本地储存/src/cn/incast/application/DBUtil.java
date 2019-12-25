package cn.incast.application;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;
//模拟银行系统中的账户信息，相当于数据库的功能
public class DBUtil {
	private static DBUtil instance=null;
	private HashMap<String,User> users=new HashMap<String,User>();
	
	private DBUtil(){
		getUsersFromInputStream("C:\\user.txt");
	}
	private void getUsersFromInputStream(String isName){
		try{
			FileInputStream fs=new FileInputStream(isName);
			byte[] content=new byte[1204];
			int i=0;
			int conInteger=0;
			while(true){//此处仅仅是打印读出来的行
				try{
					conInteger=fs.read();
				} catch (IOException e){
					e.printStackTrace();
				}
				if(-1==conInteger){
					break;
				}else if('\r'==(char)conInteger||'\n'==(char)conInteger){
					try{
						this.processUserString(new String(content,"GBK").trim());
						i=0;
					} catch(UnsupportedEncodingException e){
						e.printStackTrace();
					}
					continue;
				}
				else{
					content[i]=(byte)conInteger;
					i++;
				}
			}
			fs.close();
	}
		catch(Exception e){
			}
		}
	public void processUserString(String userString){
		String [] userFields=userString.split(",");
		User u=new User();
		u.setCardId(userFields[0]);
		u.setCardPwd(userFields[1]);
		u.setUserName(userFields[2]);
		u.setCall(userFields[3]);
		u.setAccount(Integer.parseInt(userFields[4]));
		users.put(u.getCardId(), u);
	}
	//懒汉式单例模式
			public static DBUtil getInstance() {
				if(instance==null){
					synchronized(DBUtil.class){
						if(instance==null){
							instance=new DBUtil();
						}
					}
				}
				return instance;
			}
	//根据银行卡获取对应单个账户的信息
	public User getUser(String cardId){
		User user=(User) users.get(cardId);
		return user;
	}
	//获取所有账户的信息
	public HashMap<String,User> getUsers(){
		return users;
	}
	//增加一个用户
	public void addUer(User u){
		users.put(u.getCardId(),u);
	}
	//存盘操作
		public void update() {
			Set<String> userSet=users.keySet();
			StringBuffer uStringBuffer=new StringBuffer();
			for(String cardId:userSet) {
				User u=(User)users.get(cardId);
				String uString=u.getCardId()+","
						+u.getCardPwd()+","
						+u.getUserName()+","
						+u.getCall()+","
						+u.getAccount()+"\r\n";
				uStringBuffer.append(uString);
			}
			putUsersToFile(uStringBuffer.toString(),"C:\\user.dat");
		}
		//写入文件的函数
		private void putUsersToFile(String uString,String osName) {
			try {
				FileOutputStream fos = new FileOutputStream(osName);
				try {
					fos.write(uString.getBytes("GBK"));
				//	System.out.println(uString);
				}catch(UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				fos.close();
			}catch(Exception e) {
				
			}
			
		}
}
