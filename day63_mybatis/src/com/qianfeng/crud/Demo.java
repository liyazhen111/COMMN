package com.qianfeng.crud;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//		demo.add1();
//		demo.add2();
//		demo.findAll();
//		demo.findAll2();
//		demo.findAll3();
//		demo.findName();
//		demo.findNameAndAge();
//		demo.findById();
//		demo.findByName();
//		demo.findByName2();
		
//		demo.deleteById();
		demo.updateInfo();
		
		
	}
	
	public void add(){
		SqlSession session = sessionFactory.openSession();
		// Person.class.getName() 返回 包名+类名 的字符串
		session.insert(Person.class.getName() + ".add");
		session.commit();
		session.close();
	}
	
	public void add1(){
		SqlSession session = sessionFactory.openSession();
		// Person.class.getName() 返回 包名+类名 的字符串
		session.insert(Person.class.getName() + ".add1", "heihei");
		session.commit();
		session.close();
	}
	
	public void add2(){
		SqlSession session = sessionFactory.openSession();
		Person p = new Person();
		p.setName("hehe");
//		p.setAge(30);
		// 使用person对象作为参数
		session.insert(Person.class.getName() + ".add2", p);
		session.commit();
		session.close();
	}
	
	public void findAll(){
		SqlSession session = sessionFactory.openSession();
		
		// selectList查询多条语句
		session.selectList(Person.class.getName() + ".findAll", "person");
		session.commit();
		session.close();
	}
	
	public void findAll2(){
		SqlSession session = sessionFactory.openSession();
		
		Map<String,String> map = new HashMap<>();
		map.put("table", "person");
		// selectList查询多条语句
		session.selectList(Person.class.getName() + ".findAll2", map);
		session.commit();
		session.close();
	}

	public void findAll3(){
		SqlSession session = sessionFactory.openSession();
		
		// selectList查询多条语句
		List<Person> list = session.selectList(Person.class.getName() + ".findAll3");
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
		
		session.commit();
		session.close();
	}
	
	public void findName(){
		SqlSession session = sessionFactory.openSession();
		
		// selectList查询多条语句
		List<String> list = session.selectList(Person.class.getName() + ".findName");
		System.out.println(list);
		
		session.commit();
		session.close();
	}
	
	public void findNameAndAge(){
		SqlSession session = sessionFactory.openSession();
		
		// selectList查询多条语句
		// 值为null的数据，不会绑定到map对象中
		List<Map<String,Object>> list = session.selectList(Person.class.getName() + ".findNameAndAge");
		System.out.println(list);
		System.out.println(list.get(0).get("age"));
		
		session.commit();
		session.close();
	}
	
	public void findById(){
		SqlSession session = sessionFactory.openSession();
		
		// selectOne 查询一条记录时使用
		Person person = session.selectOne(Person.class.getName() + ".findById", 5);
		System.out.println(person.getName());
		
		session.commit();
		session.close();
	}
	
	public void findByName(){
		SqlSession session = sessionFactory.openSession();
		
		// selectOne 查询一条记录时使用
		Person person = session.selectOne(Person.class.getName() + ".findByName", "hehe");
		System.out.println(person.getName());
		System.out.println(person.getPerage());
		
		session.commit();
		session.close();
	}
	
	public void findByName2(){
		SqlSession session = sessionFactory.openSession();
		
		// selectOne 查询一条记录时使用
		Person person = session.selectOne(Person.class.getName() + ".findByName2", "hehe");
		System.out.println(person.getName());
		System.out.println(person.getPerage());
		
		session.commit();
		session.close();
	}
	
	public void deleteById(){
		SqlSession session = sessionFactory.openSession();
		
		// 删除
		session.delete(Person.class.getName() + ".deleteById", 3);
		session.commit();
		session.close();
		
	}
	
	public void updateInfo(){
		SqlSession session = sessionFactory.openSession();
		
		Person p = new Person();
		p.setId(5);
		p.setName("zhangsan");
		p.setPerage(20);
		// 更新
		session.update(Person.class.getName() + ".update", p);
		session.commit();
		session.close();
		
	}
}
