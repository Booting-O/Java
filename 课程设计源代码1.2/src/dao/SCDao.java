package dao;
import entity.IEntity;
import entity.SC;
import entity.Student;

import java.util.ArrayList;


public class SCDao implements IDao {

	private ArrayList xk=new ArrayList();
	public static SC sc=new SC();
	 sc.setStudentNo("164801001");
		

	@Override
	public void insert(IEntity entity) {


	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
