package tzfit

import grails.gorm.services.Service

@Service(Athlete)
interface AthleteService {

    Athlete get(Serializable id)

    List<Athlete> list(Map args)

    Long count()

    void delete(Serializable id)

    Athlete save(Athlete athlete)

}