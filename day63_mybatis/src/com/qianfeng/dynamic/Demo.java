package com.qianfeng.dynamic;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Demo {

	private static SqlSessionFactory sessionFactory;
	static{
		// 读取配置文件，获取Reader对象
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取SqlSessionFactory对象
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo demo = new Demo();
//		demo.add();
//		demo.add2();
//		demo.find();
//		demo.update();
		demo.delete();
//		demo.delete2();
	}
	
	public void add(){
		SqlSession session = sessionFactory.openSession();
		Employee e = new Employee();
		e.setName("haha");
//		e.setAge(20);
		e.setPhone("121212");
//		e.setQq("343434");
		session.insert(Employee.class.getName() + ".add", e);
		
		session.commit();
		session.close();
		
	}
	
	public void add2(){
		SqlSession session = sessionFactory.openSession();
		Employee e = new Employee();
		e.setName("haha");
		e.setAge(20);
		e.setPhone("121212");
		e.setQq("343434");
		session.insert(Employee.class.getName() + ".add2", e);
		
		session.commit();
		session.close();
		
	}
	
	public void find(){
		SqlSession session = sessionFactory.openSession();
		Employee e = new Employee();
//		e.setName("haha");
		e.setAge(20);

		List<Employee> list = session.selectList(Employee.class.getName() + ".find", e);
		System.out.println(list.size());
		
		session.commit();
		session.close();
		
	}
	
	public void update(){
		SqlSession session = sessionFactory.openSession();
		Employee e = new Employee();
		e.setId(2);
//		e.setName("haha");
		e.setAge(20);

		session.update(Employee.class.getName() + ".update", e);
		
		session.commit();
		session.close();
		
	}
	
	public void delete(){
		SqlSession session = sessionFactory.openSession();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(3);
		session.delete(Employee.class.getName() + ".deleteByIds", ids);
		
		session.commit();
		session.close();
		
	}
	
	public void delete2(){
		SqlSession session = sessionFactory.openSession();
		
		Integer[] ids = new Integer[]{2, 1};
		session.delete(Employee.class.getName() + ".deleteByIds2", ids);
		
		session.commit();
		session.close();
		
	}

}
