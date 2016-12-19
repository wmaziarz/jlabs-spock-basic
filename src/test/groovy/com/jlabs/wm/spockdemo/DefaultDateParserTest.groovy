package com.jlabs.wm.spockdemo

import spock.lang.Specification

import java.time.LocalDate
import java.time.format.DateTimeParseException

class DefaultDateParserTest extends Specification {

    def underTest = new DefaultDateParser()

    def "should parse date string to LocalDate object - single test"() {
        given: "some correctly formatted date"
        def maybeDate = '1999-03-06'

        expect: "date parsed to LocalDate object"
        underTest.parse(maybeDate) == LocalDate.of(1999, 3, 6)
    }

    def "should parse date string to LocalDate object - repeat for many inputs"() {
        expect:
        underTest.parse(maybeDate) == expectedResult

        where: "repeat test for different input strings defined in the data table"
        maybeDate   | expectedResult
        '1951-03-01'| LocalDate.of(1951, 3, 1)
        '2016-12-31'| LocalDate.of(2016, 12, 31)
        '2020-01-01'| LocalDate.of(2020, 1, 1)
    }

    def "should fail on parsing date string - exception expected"() {
        given: "some incorrectly formatted date"
        def maybeDate = '1999/03/06'

        when: "should throw an exception while parsing the date"
        underTest.parse(maybeDate)

        then: "expect exception thrown from underTest.parse method"
        thrown(DateTimeParseException)
    }

}
