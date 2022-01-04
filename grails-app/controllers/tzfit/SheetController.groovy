package tzfit

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_COACH', 'ROLE_ATHLETE'])
class SheetController {

    static scaffold = Sheet

}
