package acme

import acme.vacation.Includes
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class IncludesSpec extends Specification implements DomainUnitTest<Includes> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
