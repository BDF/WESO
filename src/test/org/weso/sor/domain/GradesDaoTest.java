package org.weso.sor.domain;

import java.util.List;

import org.springframework.test.annotation.Rollback;
import org.weso.sor.model.Grade;

public class GradesDaoTest extends AbstractSorJUnit38SpringContextTests {
	
	@Rollback
	public void testFindExpectedGrades() {
		final List<Grade> grades = getGrades();
		assertNotNull(grades);
		assertEquals(4, grades.size());

		assertEquals(2, grades.get(0).getGradeNumb());
		assertEquals(3, grades.get(1).getGradeNumb());
		assertEquals(4, grades.get(2).getGradeNumb());
		assertEquals(5, grades.get(3).getGradeNumb());
	}
	
}
