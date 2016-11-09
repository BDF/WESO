package org.weso.sor.web;

import java.util.Map;

import org.weso.sor.utils.Counter;

public enum Ranking {
	First,
	Second,
	Third,
	Fourth,
	Fifth,
	OK,
	No;

	public void addToRank(Map<Ranking, Counter> rankings) {
		final Counter counter = rankings.get(this);
		counter.incr();
	}
	
}
