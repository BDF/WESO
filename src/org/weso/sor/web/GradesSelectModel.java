package org.weso.sor.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;
import org.weso.sor.model.Grade;

public class GradesSelectModel extends AbstractSelectModel {
	private List<OptionModel> gradesModel;
	
	public GradesSelectModel(List<Grade> inGrades) {
		gradesModel = new ArrayList<OptionModel>(inGrades.size());
		for (Grade currGrade : inGrades) {
			gradesModel.add(new GradeOptionModel(currGrade.getGradeId(), currGrade.getGradeDesc()));
		}
	}
	
	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		return gradesModel;
	}
}
