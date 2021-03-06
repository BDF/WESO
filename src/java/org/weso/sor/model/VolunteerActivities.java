package org.weso.sor.model;

// Generated Jan 24, 2009 2:26:38 PM by Hibernate Tools 3.2.4.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * VolunteerActivities generated by hbm2java
 */
@Entity
@Table(name = "volunteer_activities", catalog = "weso", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class VolunteerActivities implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6809604295265128561L;
	private Integer id;
	private String name;
	private String numOfPeople;
	private String timing;
	private String description;
	private Set<GuardianVolunteerChoices> guardianVolunteerChoiceses = new HashSet<GuardianVolunteerChoices>(
			0);

	public VolunteerActivities() {
	}

	public VolunteerActivities(String name, String numOfPeople, String timing) {
		this.name = name;
		this.numOfPeople = numOfPeople;
		this.timing = timing;
	}

	public VolunteerActivities(String name, String numOfPeople, String timing,
			String description,
			Set<GuardianVolunteerChoices> guardianVolunteerChoiceses) {
		this.name = name;
		this.numOfPeople = numOfPeople;
		this.timing = timing;
		this.description = description;
		this.guardianVolunteerChoiceses = guardianVolunteerChoiceses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "num_Of_People", nullable = false, length = 16)
	public String getNumOfPeople() {
		return this.numOfPeople;
	}

	public void setNumOfPeople(String numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	@Column(name = "timing", nullable = false, length = 64)
	public String getTiming() {
		return this.timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	@Column(name = "description", length = 1024)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "volunteerActivities")
	public Set<GuardianVolunteerChoices> getGuardianVolunteerChoiceses() {
		return this.guardianVolunteerChoiceses;
	}

	public void setGuardianVolunteerChoiceses(
			Set<GuardianVolunteerChoices> guardianVolunteerChoiceses) {
		this.guardianVolunteerChoiceses = guardianVolunteerChoiceses;
	}

}
