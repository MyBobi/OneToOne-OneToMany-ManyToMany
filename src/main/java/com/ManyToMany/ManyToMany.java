package com.ManyToMany;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by 吴俊俏
 * Date: 2018/8/10 0010
 * Time: 21:36
 */
public class ManyToMany {
    public static void main(String[] args) throws IOException {
        String resoure = "mybatis-config.xml";
        Reader reader = null;
        reader = Resources.getResourceAsReader(resoure);
        //创建会话工厂。传入MyBatis配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过会话工厂创建会话session
        SqlSession session = sqlSessionFactory.openSession();
        //一对多的查询
        /*UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.selectUserById(2);
        System.out.println(user);*/
        //根据订单id查询订单信息
        OrderMapper orderMapper=session.getMapper(OrderMapper.class);
        Order order=orderMapper.selectOrderById(1);
        System.out.println(order);
        //查询order对象关联的用户信息
        User user=order.getUser();
        System.out.println(user);
        //查询order对象关联的商品信息
        List<Article> articles=order.getArticles();
        for (Article article:articles){
            System.out.println(article);
        }
        session.commit();
        session.close();

    }
}
