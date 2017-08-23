package org.weso.sor.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Teacher;

@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public interface TeachersList {
	List<Teacher> getTeachers(Integer gradeId);
	Teacher loadTeacher(Integer teacherId);
}
