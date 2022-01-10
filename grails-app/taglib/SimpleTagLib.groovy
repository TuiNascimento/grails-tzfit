import grails.plugin.springsecurity.SpringSecurityUtils

class SimpleTagLib {

    def hasRole = {attrs, body ->
        if(SpringSecurityUtils.ifAllGranted(attrs.role)){
            out << body()
        }
    }

    def fieldLabel = {attrs, body ->
        String forEntity = ${attrs.for};
        //TODO: Implementar tradução
        String capitalizedForEntity = forEntity.charAt(0).toUpperCase() + forEntity.substring(1);
        out << "<label for=\"${forEntity}\">${capitalizedForEntity}:"
        out << "<span class=\"required-indicator\">*</span>"
        out << "</label>"
    }

}
