package org.weso.sor.web;

import java.util.Map;

import org.apache.tapestry5.OptionModel;

public class GradeOptionModel implements OptionModel {
	final private Integer _value;
	final private String _label;

	public GradeOptionModel(Integer gradeId, String gradeDesc) {
		_value = gradeId;
		_label = gradeDesc;
	}

	public Map<String, String> getAttributes() {
		return null;
	}

	public String getLabel() {
		return _label;
	}

	public Object getValue() {
		return _value;
	}

	public boolean isDisabled() {
		return false;
	}
}
