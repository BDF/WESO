package org.weso.sor.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tapestry5.AbstractOptionModel;
import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

public class YesNoSelectModel extends AbstractSelectModel {
	private List<OptionModel> yesNoModels;
	private final String[] sizes = { "", "Yes, I Give Permission", "No, I do not ", };
	private Map<Integer, String> keyToValue;

	public YesNoSelectModel() {
		yesNoModels = new ArrayList<OptionModel>();
		keyToValue = new HashMap<Integer, String>(sizes.length);
		for (int i = 0; i < sizes.length; i++) {
			final String childSize = sizes[i];
			final Integer key = Integer.valueOf(i);
			addToModel(key, childSize);
			keyToValue.put(key, childSize);
		}
	}

	/**
	 * No Sub-Selects
	 */
	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		return yesNoModels;
	}

	public String findValue(final Integer key) {
		return keyToValue.get(key);
	}	
	private void addToModel(final Integer value, final String childSize) {
		yesNoModels.add(new AbstractOptionModel() {
			final Integer _value = value;
			final String _childSize = childSize;

			public String getLabel() {
				return _childSize;
			}

			public Object getValue() {
				return _value;
			}
		});
	}

}
