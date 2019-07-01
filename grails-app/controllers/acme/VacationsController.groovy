package acme

import grails.converters.JSON
import groovy.json.JsonSlurper

import javax.servlet.ServletException

class VacationsController {

    def index() {
        def result = new ArrayList<Map>()
        Vacations.list().each {
            result.add(it.asMap())
        }
        render result as JSON
    }

    def create() {
        def jsonSlurper = new JsonSlurper()
        def vacations
        try {
            vacations = jsonSlurper.parseText(request.getJSON().toString()) as Vacations
            vacations.validate()
            if (vacations.hasErrors()) {
                response.status = 400
            } else {
                vacations.save()
            }
        } catch (ArithmeticException e) {
            return handleException(e)
        } catch (Exception e) {
            handleException(e, "There was an error while attempting to parse input JSON")
        }
    }

    private void handleException(Exception e, String message) {
        render ([message: e.getMessage(), timestamp: new Date(), status: 500] as JSON, status: 500)
    }

    private void handleException(ServletException e) {
        render ([message: e.getMessage(), timestamp: new Date(), status: 500] as JSON, status: 500)
    }

    private void handleException(ArithmeticException e) {
        render ([message: e.getMessage(), timestamp: new Date(), status: 400] as JSON, status: 400)
    }
}
