package tzfit

import grails.gorm.services.Service

@Service(Sheet)
interface SheetService {

    Sheet get(Serializable id)

    List<Sheet> list(Map args)

    Long count()

    void delete(Serializable id)

    Sheet save(Sheet sheet)

}