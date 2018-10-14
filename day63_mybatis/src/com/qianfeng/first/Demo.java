package com.qianfeng.first;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			// 读取配置文件，获取Reader对象
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			// 获取SqlSessionFactory对象
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			// 获取session对象
			SqlSession session = sessionFactory.openSession();
			// 执行插入操作， 根据 命名空间+id 的形式找到要执行的sql语句
			session.insert("personMapper.add");
			// 默认开启事务，必须提交
			session.commit();
			
			// 关闭
			session.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
