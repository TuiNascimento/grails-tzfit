import grails.plugin.springsecurity.SpringSecurityUtils

class SimpleTagLib {

    def hasRole = {attrs, body ->
        if(SpringSecurityUtils.ifAllGranted(attrs.role)){
            out << body()
        }
    }

}
