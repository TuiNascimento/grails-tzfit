package tzfit

class Coach extends User {

    static hasMany = [createdSheets:Sheet]

    static constraints = {
    }

    String toString(){
        super.toString()
    }
}
