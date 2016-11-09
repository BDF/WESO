package org.weso.sor.service.impl;

import java.util.List;

import org.weso.sor.domain.GradesDao;
import org.weso.sor.model.Grade;
import org.weso.sor.service.GradeList;

public class GradeListImpl implements GradeList {
	private GradesDao gradesDao;

	public GradesDao getGradesDao() {
		return gradesDao;
	}

	public void setGradesDao(GradesDao gradesDao) {
		this.gradesDao = gradesDao;
	}
	
	public List<Grade> getGrades() {
		return gradesDao.loadGrades();
	}
	
	public Grade loadGradeById(final Integer gradeId) {
		return gradesDao.loadGradeById(gradeId);
	}

}
