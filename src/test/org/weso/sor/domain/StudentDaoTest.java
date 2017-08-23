package org.weso.sor.domain;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.test.annotation.Rollback;
import org.weso.sor.model.Guardian;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;
import org.weso.sor.model.StudentToGuardian;

public class StudentDaoTest extends AbstractSorJUnit38SpringContextTests {

	@Rollback
	public void xtestAddStudent() {
		Student aStudent = addTestStudent();
		assertEquals("Forester23", aStudent.getLastName());
		
		final StudentDao studentDao2 = (StudentDao) applicationContext.getBean("studentDao");
		Student fStudent = studentDao2.findStudent("Forester23", "Celeste23");
		assertEquals("Forester23", fStudent.getLastName());
	}
	
	
	public class SECComparator implements Comparator<StudentEventChoices> {

		@Override
		public int compare(StudentEventChoices o1, StudentEventChoices o2) {
//			final String keyOne = String.format("%b-%d", o1.getAlternate(), o1.getRanking() );
//			final String keyTwo = String.format("%b-%d", o2.getAlternate(), o2.getRanking() );
			final String keyOne = o1.getEvents().getEventName();
			final String keyTwo = o2.getEvents().getEventName();

			return keyOne.compareTo(keyTwo);
		}
	}
	
	@Rollback
	public void xtestListStudentsByGrade() {
		final StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
		final List<Integer> grades = new ArrayList<Integer>();
		grades.add(Integer.valueOf(4));
		grades.add(Integer.valueOf(5));
		final List<Student> results = studentDao.listStudentsByGrades("4");
		results.clear();
	}

	@Rollback
	public void testDumpTheData() {
		final StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
		final String [] grades = new String [] {"2", "3", "4", "5" };
		for (String grade : grades) {
			final List<Student> results = studentDao.listStudentsByGrades(grade);
			final SortedSet<StudentEventChoices> sortedChoices = new TreeSet<StudentEventChoices>(new SECComparator());
			final StringBuilder builder = new StringBuilder();
			
			final Student header = results.get(0);
			builder.append("LastName, ");
			builder.append("FirstName, ");
			sortedChoices.addAll(header.getStudentEventChoiceses());
			for (StudentEventChoices sec : sortedChoices) {
				builder.append(sec.getEvents().getEventName()).append(", ");
			}
			builder.append("Number of Acedemic, ");
			builder.append("NumberOfEvents, ");
			builder.append("Teacher, ");
			builder.append("PhoneNumber, ");
			builder.append("T-Shirt, ");
			builder.append("Grade, ");
			builder.append("Parent One, ");
			builder.append("Parent Two");
			System.out.println(builder.toString());
			
			for (Student student : results) {
				builder.setLength(0);
				sortedChoices.clear();
				final String lastName = student.getLastName();
				final String firstName = student.getFirstName();
				final Set<StudentEventChoices> choices = student.getStudentEventChoiceses();
				builder.append(lastName).append(", ");
				builder.append(firstName).append(", ");
				sortedChoices.addAll(choices);
				
				for (StudentEventChoices sec : sortedChoices) {
					if (sec.getRanking() < 6) {
						builder.append(sec.getRanking()).append(", ");
					} else if (sec.getRanking() == 6 && sec.getAlternate().booleanValue()) {
						builder.append("Yes").append(", ");
					} else if (sec.getRanking() == 6 && sec.getAlternate().booleanValue() == false){
						builder.append("No").append(", ");
					} else {
						builder.append("Unk").append(", ");
					}
				}
				builder.append(student.getNumberOfAcedemic()).append(", ");
				builder.append(student.getNumberOfEvents()).append(", ");
				builder.append(student.getTeacher().getTeacherName()).append(", ");
				builder.append(student.getPhoneNumber()).append(", ");
				builder.append(student.getTShirtSize()).append(", ");
				builder.append(student.getGrade().getGradeNumb()).append(", ");
				Set<StudentToGuardian> parents = student.getStudentToGuardians();
				Iterator<StudentToGuardian> stgIter = parents.iterator();
				final Guardian g1 = stgIter.next().getGuardian();
				builder.append("\"");
				builder.append(g1.getLastName()).append(" ");
				builder.append(g1.getFirstName());
				builder.append("\"");
				builder.append(", ");
				if (stgIter.hasNext()) {
					final Guardian g2 = stgIter.next().getGuardian();
					builder.append("\"");
					builder.append(g2.getLastName()).append(" ");
					builder.append(g2.getFirstName());
					builder.append("\"");
				} else {
					builder.append("\"");
					builder.append("\"");
				}
				System.out.println(builder.toString());
			}
		}
	}

}
