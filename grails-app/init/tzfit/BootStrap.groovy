package tzfit

import grails.gorm.transactions.Transactional


class BootStrap {

    def init = { servletContext ->
        createAdmin()
        createTestUsers()
        createMovements()
        createFiles()
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

    @Transactional
    void createTestUsers() {

        //Coaches
        def coach = Coach.findOrSaveWhere(username: 'coach', password: 'adm',
                fullName: 'Coach', enabled: true, accountExpired: false, accountLocked: false,
                passwordExpired:  false )
        def coachRole = Role.findOrSaveWhere(authority: "ROLE_COACH")

        if(!coach.authorities.contains(coachRole)){
            UserRole.create(coach, coachRole, true)
        }


        //Athletes
        def ath = Athlete.findOrSaveWhere(username: 'athlete', password: 'adm',
                fullName: 'Athlete', enabled: true, accountExpired: false, accountLocked: false,
                passwordExpired:  false )
        def ath2 = Athlete.findOrSaveWhere(username: 'athlete2', password: 'adm',
                fullName: 'Athlete2', enabled: true, accountExpired: false, accountLocked: false,
                passwordExpired:  false )
        def athleteRole = Role.findOrSaveWhere(authority: "ROLE_ATHLETE")

        if(!ath.authorities.contains(athleteRole)){
            UserRole.create(ath, athleteRole, true)
        }
        if(!ath2.authorities.contains(athleteRole)){
            UserRole.create(ath2, athleteRole, true)
        }

    }

    @Transactional
    void createMovements() {
        def mov1 = Movement.findOrSaveWhere(title: "The Legless Rope climb", videoResource: "https://youtu.be/rfr-Tw3Pxh8", description: "The Legless Rope Climb consists of climbing the rope without the help of your legs. It helps corporal balance and arms strenght.")
        def mov2 = Movement.findOrSaveWhere(title: "The Butterfly Pull-Up", videoResource: "https://youtu.be/U_MhBXnlInE")
        def mov3 = Movement.findOrSaveWhere(title: "The Strict Toes-to-Rings", videoResource: "https://youtu.be/1zp-B1Vb_Vs")
    }

    @Transactional
    createFiles() {
        def img1 = TZFile.findOrSaveWhere(title: "hero", path: "../../assets/crossfit/hero.jpg")
        def img2 = TZFile.findOrSaveWhere(title: "exhausted", path: "../../assets/crossfit/exhausted.jpg")
        def img3 = TZFile.findOrSaveWhere(title: "pistol", path: "../../assets/crossfit/pistol.jpg")
        def img4 = TZFile.findOrSaveWhere(title: "pullup", path: "../../assets/crossfit/pullup.jpg")
        def img5 = TZFile.findOrSaveWhere(title: "rings", path: "../../assets/crossfit/rings.jpg")
        def img6 = TZFile.findOrSaveWhere(title: "rings-superman", path: "../../assets/crossfit/rings-superman.jpg")
        def img7 = TZFile.findOrSaveWhere(title: "snatch-car", path: "../../assets/crossfit/snatch-car.jpg")
    }
    def destroy = {
    }
}
