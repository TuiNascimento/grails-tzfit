package tzfit

class User {

    String code
    String fullName
    String password
    String email
    Date birthDate

    static constraints = {
        code size: 3..15, blank: false, unique: true
        password maxSize: 255, blank: false, password: true
        email email: true, blank: false
    }

    String toString(){
        fullName
    }
}
