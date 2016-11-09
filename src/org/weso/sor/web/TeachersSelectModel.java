package org.weso.sor.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;
import org.weso.sor.model.Teacher;

public class TeachersSelectModel  extends AbstractSelectModel {
	private List<OptionModel> teachersModel;
	
	public TeachersSelectModel(List<Teacher> inTeachers) {
		teachersModel = new ArrayList<OptionModel>(inTeachers.size());
		for (Teacher currTeacher: inTeachers) {
			teachersModel.add(new GradeOptionModel(currTeacher.getTeacherId(), currTeacher.getTeacherName()));
		}
	}
	
	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		return teachersModel;
	}
}
