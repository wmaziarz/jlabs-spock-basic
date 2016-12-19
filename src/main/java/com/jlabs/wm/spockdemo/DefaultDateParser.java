package com.jlabs.wm.spockdemo;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DefaultDateParser implements DateParser {

	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public LocalDate parse(String maybeDate) {
		return LocalDate.parse(maybeDate, DTF);
	}
}
