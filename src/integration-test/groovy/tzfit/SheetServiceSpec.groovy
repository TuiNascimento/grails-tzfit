package tzfit

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SheetServiceSpec extends Specification {

    SheetService sheetService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Sheet(...).save(flush: true, failOnError: true)
        //new Sheet(...).save(flush: true, failOnError: true)
        //Sheet sheet = new Sheet(...).save(flush: true, failOnError: true)
        //new Sheet(...).save(flush: true, failOnError: true)
        //new Sheet(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sheet.id
    }

    void "test get"() {
        setupData()

        expect:
        sheetService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Sheet> sheetList = sheetService.list(max: 2, offset: 2)

        then:
        sheetList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sheetService.count() == 5
    }

    void "test delete"() {
        Long sheetId = setupData()

        expect:
        sheetService.count() == 5

        when:
        sheetService.delete(sheetId)
        sessionFactory.currentSession.flush()

        then:
        sheetService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Sheet sheet = new Sheet()
        sheetService.save(sheet)

        then:
        sheet.id != null
    }
}
