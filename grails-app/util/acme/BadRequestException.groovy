package acme

class BadRequestException extends Exception {
    BadRequestException(String message) {
        super(message)
    }
}
