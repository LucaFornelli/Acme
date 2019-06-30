package acme

class LoginController {

    def index() {

    }

    def login(Users user) {
        Users temp = Users.findByUsername(user.username)
        if (temp) {
            redirect(action: "home", params: [status: 200])
        } else {
            redirect(actionName: "login")
        }
    }

    def home(params) {
        if (params.status == "200")
            render "Welcome", status: 200
        else
            render "Not allowed", status: 403
    }
}
