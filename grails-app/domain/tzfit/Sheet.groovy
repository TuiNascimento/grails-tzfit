package tzfit

class Sheet {

    String title
    TZFile coverImage
    Coach sheetCoach

    static hasMany = [movements: Movement, athletes:Athlete]

    static constraints = {
    }

    static mapping = {}

    String toString(){
        "$title - " + sheetCoach + " #$id"
    }

    int getEstimatedDuration() {
        int estimatedDuration
        for (Movement movement : movements) {
            estimatedDuration += movement.estimatedDuration
        }
        return estimatedDuration
    }
}
