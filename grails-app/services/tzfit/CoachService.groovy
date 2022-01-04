package tzfit

import grails.gorm.services.Service

@Service(Coach)
interface CoachService {

    Coach get(Serializable id)

    List<Coach> list(Map args)

    Long count()

    void delete(Serializable id)

    Coach save(Coach coach)

}