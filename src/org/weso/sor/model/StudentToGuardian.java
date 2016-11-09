package org.weso.sor.model;

// Generated Jan 24, 2009 2:26:38 PM by Hibernate Tools 3.2.4.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * StudentToGuardian generated by hbm2java
 */
@Entity
@Table(name = "student_to_guardian", catalog = "weso", uniqueConstraints = @UniqueConstraint(columnNames = {
		"std_guardian_id", "std_student_id" }))
public class StudentToGuardian implements java.io.Serializable {

	private Integer stdId;
	private Guardian guardian;
	private Student student;

	public StudentToGuardian() {
	}

	public StudentToGuardian(Guardian guardian, Student student) {
		this.guardian = guardian;
		this.student = student;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "std_id", unique = true, nullable = false)
	public Integer getStdId() {
		return this.stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "std_guardian_id", nullable = false)
	public Guardian getGuardian() {
		return this.guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "std_student_id", nullable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
