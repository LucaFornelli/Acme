package acme

class Users {

    String fullname
    String username
    String password

    static constraints = {
        username(unique: true)
        password(nullable: false)
        fullname(nullable: false)
    }
}
