package com.OneToMany;

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
 * Time: 10:54
 */
public class OneToManyTest {

    public static void main(String[] args) throws IOException {
        String resoure = "mybatis-config.xml";
        Reader reader = null;
            reader = Resources.getResourceAsReader(resoure);
            //创建会话工厂。传入MyBatis配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //通过会话工厂创建会话session
            SqlSession session = sqlSessionFactory.openSession();
           //查询班级编号为1的信息
       /* ClazzMapper clazzMapper=session.getMapper(ClazzMapper.class);
        Clazz clazz=clazzMapper.selectClazzById(1);
        System.out.println(class);*/

       //查询班级编号为1的所有学生信息
       StudentMapper studentMapper=session.getMapper(StudentMapper.class);
       List<Student> student=studentMapper.selectStudentByClazzId(1);
        for (Student stu:student){
            System.out.println(stu);
        }
            session.commit();
            session.close();

    }
}