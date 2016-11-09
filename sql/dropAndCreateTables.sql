use weso;
show warnings;

DROP TABLE IF EXISTS event_To_Grade;
DROP TABLE IF EXISTS student_To_Guardian;
DROP TABLE IF EXISTS student_Event_Choices;
DROP TABLE IF EXISTS teacher_To_Grade;
DROP TABLE IF EXISTS guardian_volunteer_choices;
DROP TABLE IF EXISTS guardian_Event_Choices;

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS grade;
DROP TABLE IF EXISTS guardian;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS volunteer_Activities;


CREATE TABLE WESO.guardian (
  guardian_id INT  unsigned NOT NULL auto_increment,
  user_name  VARCHAR(64) NOT NULL,
  last_name  VARCHAR(64) NOT NULL,
  first_name VARCHAR(64) NOT NULL,
  password   VARCHAR(30) DEFAULT NULL,
  date_created TIMESTAMP  DEFAULT now(),
  primary_email_address VARCHAR(64)  NOT NULL,
  secondary_email_address VARCHAR(64)  DEFAULT NULL,
  primary_phone_number VARCHAR(12)  NOT NULL,
  secondary_phone_number VARCHAR(12) DEFAULT NULL,
  photo_permisson   boolean NOT NULL,
  t_shirt_size  VARCHAR(24) NOT NULL,
  PRIMARY KEY (guardian_id),
  UNIQUE KEY user_name (user_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.events (
  events_id INT  unsigned NOT NULL auto_increment,
  event_name  VARCHAR(64) NOT NULL,
  description  VARCHAR(1024) DEFAULT NULL,
  PRIMARY KEY (events_id),
  UNIQUE KEY event_name (event_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.volunteer_Activities (
	id INT  unsigned NOT NULL auto_increment,
	name VARCHAR(64) NOT NULL,
    num_Of_People  VARCHAR(16) NOT NULL,	
	timing         VARCHAR(64) NOT NULL,
	description   VARCHAR(1024) DEFAULT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY name (name)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.grade (
  grade_id INT  unsigned NOT NULL auto_increment,
  grade_numb int unsigned NOT NULL,
  grade_desc VARCHAR(32) DEFAULT NULL,
  UNIQUE KEY grade_desc (grade_desc),
  UNIQUE KEY grade_numb (grade_numb),
  PRIMARY KEY (grade_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.teacher (
	teacher_id INT  unsigned NOT NULL auto_increment,
    teacher_name  VARCHAR(64) NOT NULL,
  	PRIMARY KEY (teacher_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.student (
  student_id INT  unsigned NOT NULL auto_increment,
  last_name  VARCHAR(64) NOT NULL,
  first_name VARCHAR(64) NOT NULL,
  grade     INT  unsigned NOT NULL, 
  teacher   INT  unsigned NOT NULL,
  phone_number VARCHAR(12) NOT NULL,
  t_shirt_size VARCHAR(24)  NOT NULL,
  number_of_events int unsigned NOT NULL,
  date_created TIMESTAMP  DEFAULT now(),
  CONSTRAINT  fk_student_grade  FOREIGN KEY (grade)  REFERENCES grade(grade_id),
  CONSTRAINT  fk_student_teacher  FOREIGN KEY (teacher)  REFERENCES teacher(teacher_id),
  PRIMARY KEY (student_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.teacher_To_Grade (
	ttg_id INT  unsigned NOT NULL auto_increment,
	ttg_teacher_id INT  unsigned NOT NULL,
	ttg_grade_id  INT  unsigned NOT NULL,
	PRIMARY KEY (ttg_id),
	unique key (ttg_teacher_id, ttg_grade_id),
	CONSTRAINT fk_ttg_teacher_id FOREIGN KEY (ttg_teacher_id) REFERENCES Teacher(teacher_id),
	CONSTRAINT fk_ttg_grade_id  FOREIGN KEY (ttg_grade_id) REFERENCES grade(grade_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.event_To_Grade (
  etg_id INT  unsigned NOT NULL auto_increment,
  etg_events_id INT unsigned NOT NULL,
  etg_grade_id INT unsigned NOT NULL,
  PRIMARY KEY (etg_id),
  unique key (etg_events_id, etg_grade_id),
  CONSTRAINT fk_etg_events_id  FOREIGN KEY (etg_events_id) REFERENCES events(events_id),
  CONSTRAINT fk_grade_id      FOREIGN KEY (etg_grade_id) REFERENCES grade(grade_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.student_Event_Choices (
	student_Event_Choices_id INT  unsigned NOT NULL auto_increment,
	sec_student_id   INT unsigned NOT NULL,
	sec_events_id INT unsigned NOT NULL,
	ranking INT unsigned NOT NULL,
	alternate BOOLEAN DEFAULT false,
-- A student can only have one ranking per event.
-- A student can only choose the event once.
-- Each event per student can only have one ranking.
	UNIQUE KEY (sec_student_id, sec_events_id),
	CONSTRAINT  fk_eventChoice_student FOREIGN KEY (sec_student_id)  REFERENCES student(student_id),
	CONSTRAINT  fk_eventChoice_event   FOREIGN KEY (sec_events_id)  REFERENCES events(events_id),
	PRIMARY KEY (student_Event_Choices_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.guardian_Event_Choices (
	guardian_Event_Choices_id INT  unsigned NOT NULL auto_increment,
	pec_guardian_id INT unsigned NOT NULL,
	pec_events_id INT unsigned NOT NULL,
	ranking INT unsigned NOT NULL,
-- A student can only have one ranking per event.
-- A student can only choose the event once.
-- Each event per student can only have one ranking.
	UNIQUE KEY (pec_guardian_id, pec_events_id),
	UNIQUE KEY (pec_guardian_id, ranking),
	CONSTRAINT  fk_guardianEventChoice_guardian FOREIGN KEY (pec_guardian_id)  REFERENCES guardian(guardian_id),
	CONSTRAINT  fk_guardianEventChoice_event  FOREIGN KEY (pec_events_id)  REFERENCES events(events_id),
	PRIMARY KEY (guardian_Event_Choices_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.guardian_volunteer_choices (
	id INT  unsigned NOT NULL auto_increment,
	pvc_guardian_id INT unsigned NOT NULL,
	pvc_activity_id INT unsigned NOT NULL,
	ranking INT unsigned NOT NULL,
-- A student can only have one ranking per event.
-- A student can only choose the event once.
-- Each event per student can only have one ranking.
	UNIQUE KEY (pvc_guardian_id, pvc_activity_id),
	UNIQUE KEY (pvc_activity_id, ranking),
	CONSTRAINT  fk_vol_choice_guardian FOREIGN KEY (pvc_guardian_id)  REFERENCES guardian(guardian_id),
	CONSTRAINT  fk_vol_activity   FOREIGN KEY (pvc_activity_id)  REFERENCES volunteer_Activities(id),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WESO.student_To_Guardian (
  std_id INT  unsigned NOT NULL auto_increment,
  std_guardian_id INT unsigned NOT NULL,
  std_student_id INT unsigned NOT NULL,
  UNIQUE KEY (std_guardian_id, std_student_id),
  CONSTRAINT fk_std_guardian_id FOREIGN KEY (std_guardian_id)  REFERENCES guardian(guardian_id),
  CONSTRAINT fk_std_student_id  FOREIGN KEY (std_student_id)   REFERENCES student(student_id),
  PRIMARY KEY (std_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
