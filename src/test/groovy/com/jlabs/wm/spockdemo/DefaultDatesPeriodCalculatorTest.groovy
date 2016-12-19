package com.jlabs.wm.spockdemo

import spock.lang.Specification

import java.time.LocalDate

class DefaultDatesPeriodCalculatorTest extends Specification {

    def dateParser = Mock(DateParser)
    def underTest = new DefaultDatesPeriodCalculator(dateParser: dateParser)

    def "should calculate days between two dates - test with mock interaction"() {
        given:
        def fromDay = '2015-01-01'
        def toDay = '2015-12-31'

        when:
        def result = underTest.calculateDaysBetween(fromDay, toDay)

        then: "Mocked dataParser should be called twice. For fromDay and toDay."
        1 * dateParser.parse('2015-01-01') >> LocalDate.of(2015, 1, 1)
        1 * dateParser.parse('2015-12-31') >> LocalDate.of(2015, 12, 31)

        result == 364L
    }
}
