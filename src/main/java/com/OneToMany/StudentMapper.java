package com.OneToMany;

import java.util.List;

public interface StudentMapper {

	// 根据id查询学生信息
	List<Student> selectStudentByClazzId(Integer id);
	
}
