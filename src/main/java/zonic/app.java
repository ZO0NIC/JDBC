package zonic;

import java.util.ArrayList;
import java.util.List;

import jdbc.dao.Database;

public class app {

	public static void main(String[] args) {
		Employee Anupam = new Employee();
		Anupam.setId(7);
		Anupam.setName("ZONIC");
		Anupam.setAge("∞");
		Anupam.setGender("GOD");
		Employee pankaj = new Employee();
		pankaj.setId(1);
		pankaj.setName("harry");
		pankaj.setAge("50");
		pankaj.setGender("Male");
		Database db = new Database();
		db.insert(Anupam);
		//db.updateE("age","dqwwda",1,pankaj);
		//db.updateE("name","MOHIT",1,pankaj);

//		db.showEmployees();
		//db.showEmployees();
		//db.update(pankaj);
		//List ex = new ArrayList();
		//ex =db.convo();
		System.out.println(db.convo());
		//db.AddColumn("naya",225,"varchar");

	}

}
