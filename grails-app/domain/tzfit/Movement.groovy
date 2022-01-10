package tzfit

class Movement {

    String title
    String description
    String videoResource
    int sets
    int repetitions
    int estimatedDuration

    static constraints = {
        title(maxSize: 255, blank: false, unique: true)
        videoResource(nullable: true)
        description(maxSize: 1000, nullable: true)
    }

    String toString(){
        title
    }
}
