package com.OneToOne;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 吴俊俏
 * Date: 2018/8/9 0009
 * Time: 23:00
 */
public class OneToOneTest {
    public static void main(String[] args) {
        String resoure = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resoure);
            //创建会话工厂。传入MyBatis配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //通过会话工厂创建会话session
            SqlSession session = sqlSessionFactory.openSession();
            //第一种直接调用sqlseesion的对象方法进行查询
            Person person1=session.selectOne("selectPersonById",1);
            System.out.println(person1);
            //第二种获得mapper接口的代理对象进行查询
            /*PersonMapper personMapper=session.getMapper(PersonMapper.class);
            //直接调用接口的方法，查询id为1的person数据
            Person person=personMapper.selectPersonById(1);
            System.out.println(person);
            System.out.println(person.getCard());*/
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}