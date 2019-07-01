package acme

import grails.converters.JSON
import groovy.json.JsonSlurper

import javax.servlet.ServletException

class VacationsController {

    VacationsService vacationsService

    def index() {
        render vacationsService.listAll() as JSON
    }

    def create() {
        render vacationsService.createVacation(request.getJSON().toString()).asMap() as JSON
    }
}
