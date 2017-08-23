package org.weso.sor.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.Field;

public class Counter {
	private int _counter;
	
	public Counter() {
		_counter = 0;
	}
	
	public int incr() {
		return ++_counter;
	}
	
	public int getCount() {
		return _counter;
	}
	
}
