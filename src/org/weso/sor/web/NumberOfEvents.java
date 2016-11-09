package org.weso.sor.web;

public enum NumberOfEvents {
	Zero, One, Two, Three;

	public int findNumberOfEvents() {
		final int count;
		switch (this) {
		case Zero:
			count = 0;
			break;
		case One:
			count = 1;
			break;
		case Two:
			count = 2;
			break;
		case Three:
			count = 3;
			break;
		default:
			count = 4;
			break;
		}
		return count;
	}
	
	public NumberOfEvents getZero() {
		return Zero;
	}
	
	public NumberOfEvents getOne() {
		return One;
	}
	
	public NumberOfEvents getTwo() {
		return Two;
	}
	
	public NumberOfEvents getThree() {
		return Three;
	}
}
