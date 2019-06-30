package acme

import acme.vacation.Destinations
import acme.vacation.Includes
import acme.vacation.Offer
import org.apache.catalina.User

class BootStrap {

    def init = { servletContext ->
        new Users(fullname: "Luca Fornelli", username: "lfornelli", password: "lfornelli").save()

        new Vacations(name: "vacation1", description: "description", type: "resort", destinations: new Destinations(city: "Rome", country:"Italy"),
                includes: [new Includes(what: "flight", description:"from New York to Rome")], numberOfNights: 15, pricePP: 908.72f,
                offer: new Offer(discount:10, description:"discount1", expires: new Date()), validTill: new Date(), soldout: false).save()
        new Vacations(name: "vacation2", description: "description2", type: "resort", destinations: new Destinations(city: "Milan", country:"Italy"),
                includes: [new Includes(what: "flight", description:"from New York to Milan")], numberOfNights: 10, pricePP: 708.72f,
                offer: new Offer(discount:20, description:"discount2", expires: new Date()), validTill: new Date(), soldout: false).save()
    }
    def destroy = {
    }
}
