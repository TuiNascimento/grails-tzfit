package tzfit

class Sheet {

    String title
    Coach sheetCoach

    static hasMany = [movements: Movement, athletes:Athlete]

    static constraints = {
    }

    static mapping = {}

    String toString(){
        "$title - " + sheetCoach + " #$id"
    }
}
