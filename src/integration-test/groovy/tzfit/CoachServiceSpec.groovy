package tzfit

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CoachServiceSpec extends Specification {

    CoachService coachService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Coach(...).save(flush: true, failOnError: true)
        //new Coach(...).save(flush: true, failOnError: true)
        //Coach coach = new Coach(...).save(flush: true, failOnError: true)
        //new Coach(...).save(flush: true, failOnError: true)
        //new Coach(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //coach.id
    }

    void "test get"() {
        setupData()

        expect:
        coachService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Coach> coachList = coachService.list(max: 2, offset: 2)

        then:
        coachList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        coachService.count() == 5
    }

    void "test delete"() {
        Long coachId = setupData()

        expect:
        coachService.count() == 5

        when:
        coachService.delete(coachId)
        sessionFactory.currentSession.flush()

        then:
        coachService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Coach coach = new Coach()
        coachService.save(coach)

        then:
        coach.id != null
    }
}
