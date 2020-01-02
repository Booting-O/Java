package dao;
import entity.IEntity;
import entity.SC;
import entity.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class SCDao implements IDao {
	private static SCDao instance;
	private HashMap<String,IEntity> scs;
	private SC sc;
	private ArrayList xk;
    private SCDao(){
    	scs=new HashMap<String,IEntity>();
    	sc=new SC();
		getscFromInputStream("sc.txt");
    }
    public void processUserString(String userString){
		String [] userFields = userString.split(",");
		SC u = new SC();
		u.setStudentNo(userFields[0]);
		u.addxk(userFields[1]);
		u.addxk(userFields[2]);
		u.addxk(userFields[3]);
		u.addxk(userFields[4]);
		u.addxk(userFields[5]);
		u.addxk(userFields[6]);
		u.addxk(userFields[7]);
		u.addxk(userFields[8]);
		u.addxk(userFields[9]);
		u.addxk(userFields[10]);
		scs.put(u.getStudentNo(),u);
	}

	private void getscFromInputStream(String isName){
		try{
			FileInputStream fs = new FileInputStream(isName);
			byte[] content = new byte[1024];
			int i=0;
			int conInteger = 0;
			while(true){
			    try{
			        conInteger = fs.read();
			    } catch (Exception e){
			       e.printStackTrace();
			    }
			    if(-1 == conInteger){
			         break;
			    }else if('\r' == (char)conInteger || '\n' == (char)conInteger){
			        try{
			        	this.processUserString(new String(content,"GBK").trim());
			            i=0;
			        } catch (Exception e){
			           e.printStackTrace();
			        }
			        continue;
			    } else{
			        content[i] = (byte)conInteger;
			        i++;
			    }   
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static SCDao getInstance() {
		if(instance == null) {
			synchronized(SCDao.class) {
				if(instance == null) {
					instance = new SCDao();
					return instance;
				}
			}
		}
		return instance;
	}	
	

	@Override
	public void insert(IEntity entity) {
        SC sc = (SC)entity;
        scs.put(sc.getStudentNo(), sc);
       
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
        
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		Set<String> userSet=scs.keySet();
		StringBuffer uStringBuffer=new StringBuffer();
		for(String StudentNo:userSet) {
			SC u=(SC)scs.get(StudentNo);
			String uString=u.getStudentNo()+","
					+u.getxk().get(0)+","
					+u.getxk().get(1)+","
					+u.getxk().get(2)+","
					+u.getxk().get(3)+","
					+u.getxk().get(4)+","
					+u.getxk().get(5)+","
					+u.getxk().get(6)+","
					+u.getxk().get(7)+","
					+u.getxk().get(8)+","
					+u.getxk().get(9)+"\r\n";
			uStringBuffer.append(uString);
		}
		putstudentsToFile(uStringBuffer.toString(),"sc.txt");
	}

	private void putstudentsToFile(String uString,String osName) {
		try {
			FileOutputStream fos = new FileOutputStream(osName);
			try {
				fos.write(uString.getBytes("GBK"));
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return scs;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return scs.get(Id);
	}

}
