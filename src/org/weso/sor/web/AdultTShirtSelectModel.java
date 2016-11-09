package org.weso.sor.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tapestry5.AbstractOptionModel;
import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

public class AdultTShirtSelectModel extends AbstractSelectModel {
	private List<OptionModel> adultTShirtModels;
	private final String[] sizes = { "No Shirt", "Adult Small",
			"Adult Medium", "Adult XL", "Adult XXL", "Adult XXXL" };
	private Map<Integer, String> keyToValue;

	public AdultTShirtSelectModel() {
		adultTShirtModels = new ArrayList<OptionModel>();
		keyToValue = new HashMap<Integer, String>(sizes.length);
		for (int i = 0; i < sizes.length; i++) {
			final String childSize = sizes[i];
			final Integer key = Integer.valueOf(i);
			addSize(key, childSize);
			keyToValue.put(key, childSize);
		}
	}

	private void addSize(final Integer value, final String childSize) {
		adultTShirtModels.add(new AbstractOptionModel() {
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

	/**
	 * No Sub-Selects
	 */
	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		return adultTShirtModels;
	}

	public String findValue(final Integer key) {
		return keyToValue.get(key);
	}
}
