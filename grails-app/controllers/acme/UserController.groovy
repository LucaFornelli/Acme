package acme

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED

class UserController {

    def index() { }

    def login(Users user) {
        if (Users.findByUsernameAndPassword(user.username, user.password)) {
            session.user = user.username
            flash.message = "login succeed"
        } else {
            flash.message = "login failed"
        }
        redirect(action: "index")
    }

    def create() {
        respond new Users(params)
    }

    def save(Users temp) {
        if (temp == null) {
            return
        }

        try {
            temp.save()
        } catch (ValidationException e) {
            respond temp.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = "User: ${temp.username} correctly registered"
                redirect (action: "index")
            }
            '*' { respond temp, [status: CREATED] }
        }
    }

    def logout = {
        session.user = null
        redirect(action: "index")
    }
}
