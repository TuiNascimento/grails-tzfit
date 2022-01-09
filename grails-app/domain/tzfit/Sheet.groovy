package tzfit

class Sheet {

    String title
    Coach sheetCoach

    static hasMany = [movements: Movement, athletes:Athlete]

    static constraints = {
    }

    static mapping = {
        movements joinTable: [name: "sheet_movements", key: 'sheet_id']
    }


    String toString(){
        "$title - " + sheetCoach + " #$id"
    }
}
