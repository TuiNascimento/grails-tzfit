package tzfit

import grails.gorm.transactions.Transactional


class BootStrap {

    def init = { servletContext ->
        createAdmin()
    }

    @Transactional
    void createAdmin() {

        def admin = User.findOrSaveWhere(username: 'adm', password: 'adm',
                fullName: 'Administrador', enabled: true, accountExpired: false, accountLocked: false,
                passwordExpired:  false )

        def adminRole = Role.findOrSaveWhere(authority: "ROLE_ADMIN")
        if(!admin.authorities.contains(adminRole)){
            UserRole.create(admin, adminRole, true)
        }

    }

    def destroy = {
    }
}
