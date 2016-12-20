package com.jlabs.wm.spockdemo;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DefaultDatesPeriodCalculator implements DatesPeriodCalculator {

	private static DateParser dateParser;

	@Override
	public long calculateDaysBetween(String fromDay, String toDay) {
		LocalDate from = dateParser.parse(fromDay);
		LocalDate to = dateParser.parse(toDay);

		return ChronoUnit.DAYS.between(from, to);
	}

}
