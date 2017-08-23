package org.weso.sor.domain;

import java.util.List;

import org.weso.sor.model.Grade;

/**
 * 
 * @author bforester
 */
public interface GradesDao {
	
	List<Grade> loadGrades();
	Grade loadGrade(final Integer gradeNumber);
	Grade loadGradeById(final Integer gradeNumber);
}
