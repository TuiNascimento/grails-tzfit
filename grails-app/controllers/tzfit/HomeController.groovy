package tzfit

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.userdetails.GrailsUser
import groovy.transform.CompileStatic

@CompileStatic
@Secured('isAuthenticated()')
class HomeController {

    static responseFormats = ['json']

    static SpringSecurityService springSecurityService

    def index() {
        [name : loggedUserName()]
    }

    public static String loggedUserName(){

        Object principal = springSecurityService.principal;

        if (null == principal) {
            return null
        }
        if(principal instanceof String) {
            return principal;
        }
        if(principal instanceof GrailsUser) {
            return ((GrailsUser) principal).username
        }

        null
    }

}

