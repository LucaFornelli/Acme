package acme

class UrlMappings {

    static mappings = {
        "/v1/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/v1/vacations/" (controller: 'vacations') {
            action = [GET: 'index', POST: 'create']
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
