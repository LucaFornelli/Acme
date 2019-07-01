package acme

import grails.converters.JSON
import groovy.json.JsonSlurper

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
            try {
                vacations.save()
            } catch (Exception e) {
                handleException(e, "There was an error while attempting to save vacations object")
            }
        } catch (Exception e) {
            handleException(e, "There was an error while attempting to parse input JSON")
        }

    }

    private void handleException(Exception e, String message) {
        flash.message = message
        String eMessage = ExceptionUtils.getRootCauseMessage(e)
        log.error message(code: "sic.log.error.ExceptionOccurred", args: ["${eMessage}", "${e}"])
        redirect(action:index)
    }
}
