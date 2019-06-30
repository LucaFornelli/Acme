package acme.vacation

class Includes {

    String what
    String description

    static constraints = {
        what(inList: ["flight", "meals", "cruise", "hotel", "rentalcar", "excursions", "misc"])
    }
}
