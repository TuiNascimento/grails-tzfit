package tzfit

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN','ROLE_COACH', 'ROLE_ATHLETE'])
class SheetController {

    SheetService sheetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sheetService.list(params), model:[sheetCount: sheetService.count()]
    }

    def show(Long id) {
        respond sheetService.get(id)
    }

    def create() {
        respond new Sheet(params)
    }

    def save(Sheet sheet) {
        if (sheet == null) {
            notFound()
            return
        }

        try {
            sheetService.save(sheet)
        } catch (ValidationException e) {
            respond sheet.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sheet.label', default: 'Sheet'), sheet.id])
                redirect sheet
            }
            '*' { respond sheet, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sheetService.get(id)
    }

    @Transactional
    def update(Sheet sheet) {
        if (sheet == null) {
            notFound()
            return
        }

        try {
            sheet.save(flush: true)
        } catch (ValidationException e) {
            respond sheet.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sheet.label', default: 'Sheet'), sheet.id])
                redirect sheet
            }
            '*'{ respond sheet, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sheetService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sheet.label', default: 'Sheet'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sheet.label', default: 'Sheet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
