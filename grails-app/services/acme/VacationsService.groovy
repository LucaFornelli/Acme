package acme

import grails.converters.JSON
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

    def createVacation(String jsonObject) {
        def jsonSlurper = new JsonSlurper()
        def vacations
        try {
            vacations = jsonSlurper.parseText(jsonObject) as Vacations
            vacations.validate()
            if (vacations.hasErrors()) {
                throw new Exception("Some problems encountered during JSON validation process, give a better look at JSON")
            } else {
                vacations.save()
                return vacations.asMap()
            }
        } catch (Exception e) {
            return handleException(e)
        }
    }

    def handleException(Exception e, String message) {
        return [message: e.getMessage(), timestamp: new Date(), status: 500]
    }

    def handleException(Exception e) {
        return [message: e.getMessage(), timestamp: new Date(), status: 500]
    }

    def handleException(BadRequestException e) {
        return [message: e.getMessage(), timestamp: new Date(), status: 400]
    }

}
