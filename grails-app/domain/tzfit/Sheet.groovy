package tzfit

class Sheet {

    String title
    TZFile coverImage
    Coach sheetCoach
    int estimatedMinutesDuration

    static hasMany = [movements: Movement, athletes:Athlete]

    static constraints = {
    }

    static mapping = {}

    String toString(){
        "$title - " + sheetCoach + " #$id"
    }
}
