package acme

import acme.vacation.Destinations
import acme.vacation.Includes
import acme.vacation.Offer

class Vacations {

    String name
    String description
    String type
    Destinations destinations
    List<Includes> includes
    Integer numberOfNights
    Float pricePP
    Offer offer
    Date validTill
    Boolean soldout

    static constraints = {
        type(inList: ["resort", "cruise"])
        numberOfNights(blank: false, nullable: false, max: 31)
        description(blank: false, nullable: false)
        validTill(blank: false, nullable: false)
        name index: "name_index_idx"
    }

    public Map asMap() {
        def map = [:] as HashMap
        this.class.getDeclaredFields().each {
            if (it.modifiers == java.lang.reflect.Modifier.PRIVATE) {
                map.put(it.name, this[it.name])
            }
        }
        return map
    }
}
