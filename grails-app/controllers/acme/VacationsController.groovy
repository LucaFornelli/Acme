package acme

import grails.converters.JSON

class VacationsController {

    VacationsService vacationsService

    def index() {
        render vacationsService.listAll() as JSON
    }

    def create() {
        def result = vacationsService.createVacation(request.getJSON().toString())
        render result as JSON
    }
}
