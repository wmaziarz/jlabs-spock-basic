package com.jlabs.wm.spockdemo;

import java.time.LocalDate;

public interface DateParser {

	LocalDate parse(String maybeDate);
}
