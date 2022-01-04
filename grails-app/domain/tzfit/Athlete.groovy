package tzfit

class Athlete extends User {

    static hasMany = [availableSheets: Sheet]

    static constraints = {
    }

    String toString(){
        super.toString()
    }
}
