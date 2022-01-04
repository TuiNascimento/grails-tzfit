package tzfit

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(["ROLE_ADMIN"])
class CoachController {

    CoachService coachService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond coachService.list(params), model:[coachCount: coachService.count()]
    }

    def show(Long id) {
        respond coachService.get(id)
    }

    def create() {
        respond new Coach(params)
    }

    @Transactional
    def save(Coach coach) {
        if (coach == null) {
            notFound()
            return
        }

        try {
            coachService.save(coach)
        } catch (ValidationException e) {
            respond coach.errors, view:'create'
            return
        }

        def coachRole = Role.findOrSaveWhere(authority: "ROLE_COACH")
        if(!coach.authorities.contains(coachRole)){
            UserRole.create(coach, coachRole, true)
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'coach.label', default: 'Coach'), coach.id])
                redirect coach
            }
            '*' { respond coach, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond coachService.get(id)
    }

    def update(Coach coach) {
        if (coach == null) {
            notFound()
            return
        }

        try {
            coachService.save(coach)
        } catch (ValidationException e) {
            respond coach.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'coach.label', default: 'Coach'), coach.id])
                redirect coach
            }
            '*'{ respond coach, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        coachService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'coach.label', default: 'Coach'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'coach.label', default: 'Coach'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
