package org.weso.sor.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tapestry5.AbstractOptionModel;
import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

public class ChildTShirtSizeSelectModel extends AbstractSelectModel {
	private List<OptionModel> childTShirtModels;
	private final String[] sizes = { "Child Small(6/8)", "Child Medium(10/12)",
			"Child Large(14/16)", "Adult Small" };
	private Map<Integer, String> keyToValue;

	public ChildTShirtSizeSelectModel() {
		childTShirtModels = new ArrayList<OptionModel>();
		keyToValue = new HashMap<Integer, String>(sizes.length);
		for (int i = 0; i < sizes.length; i++) {
			final String childSize = sizes[i];
			final Integer key = Integer.valueOf(i); 
			addChildSize(key, childSize);
			keyToValue.put(key, childSize);
		}
	}

	private void addChildSize(final Integer value, final String childSize) {
		childTShirtModels.add(new AbstractOptionModel() {
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
		return childTShirtModels;
	}
	
	public String findValue(final Integer key) {
		return keyToValue.get(key);
	}

	public Integer findKey(String tshirtSize) {
		final Set<Map.Entry<Integer, String>>  set = keyToValue.entrySet();
		Integer key = null;
		for (Map.Entry<Integer, String> entry : set) {
			if (entry.getValue() != null && entry.getValue().equals(tshirtSize)) {
				key = entry.getKey();
			}
		}
		return key;
	}

}
