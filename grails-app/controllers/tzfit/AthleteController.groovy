package tzfit

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN', 'ROLE_COACH'])
class AthleteController {

    AthleteService athleteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond athleteService.list(params), model:[athleteCount: athleteService.count()]
    }

    def show(Long id) {
        respond athleteService.get(id)
    }

    def create() {
        respond new Athlete(params)
    }

    @Transactional
    def save(Athlete athlete) {
        if (athlete == null) {
            notFound()
            return
        }

        try {
            athleteService.save(athlete)
        } catch (ValidationException e) {
            respond athlete.errors, view:'create'
            return
        }

        def athleteRole = Role.findOrSaveWhere(authority: "ROLE_ATHLETE")
        if(!athlete.authorities.contains(athleteRole)){
            UserRole.create(athlete, athleteRole, true)
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'athlete.label', default: 'Athlete'), athlete.id])
                redirect athlete
            }
            '*' { respond athlete, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond athleteService.get(id)
    }

    def update(Athlete athlete) {
        if (athlete == null) {
            notFound()
            return
        }

        try {
            athleteService.save(athlete)
        } catch (ValidationException e) {
            respond athlete.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'athlete.label', default: 'Athlete'), athlete.id])
                redirect athlete
            }
            '*'{ respond athlete, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        athleteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'athlete.label', default: 'Athlete'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'athlete.label', default: 'Athlete'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
