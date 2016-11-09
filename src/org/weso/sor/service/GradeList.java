package org.weso.sor.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Grade;

@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public interface GradeList {
	List<Grade> getGrades();
	
	Grade loadGradeById(Integer gradeId);
}
