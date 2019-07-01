package acme

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

import javax.servlet.ServletException

@Transactional
class VacationsService {

    def listAll() {
        def result = new ArrayList<Map>()
        Vacations.list().each {
            result.add(it.asMap())
        }
        return result
    }

    Vacations createVacation(String jsonObject) {
        def jsonSlurper = new JsonSlurper()
        def vacations
        try {
            vacations = jsonSlurper.parseText(jsonObject) as Vacations
            vacations.validate()
            if (vacations.hasErrors()) {
                throw new BadRequestException("Some problems encountered during JSON validation process, give a better look at JSON")
            } else {
                vacations.save()
            }
        } catch (ArithmeticException e) {
            return handleException(e)
        } catch (Exception e) {
            handleException(e, "There was an error while attempting to parse input JSON")
        }
        return vacations
    }

    def handleException(Exception e, String message) {
        return [message: e.getMessage(), timestamp: new Date(), status: 500]
    }

    def handleException(ServletException e) {
        return [message: e.getMessage(), timestamp: new Date(), status: 500]
    }

    def handleException(BadRequestException) {
        return [message: e.getMessage(), timestamp: new Date(), status: 400]
    }

}
