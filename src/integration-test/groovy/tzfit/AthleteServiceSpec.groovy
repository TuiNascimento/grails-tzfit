package tzfit

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AthleteServiceSpec extends Specification {

    AthleteService athleteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Athlete(...).save(flush: true, failOnError: true)
        //new Athlete(...).save(flush: true, failOnError: true)
        //Athlete athlete = new Athlete(...).save(flush: true, failOnError: true)
        //new Athlete(...).save(flush: true, failOnError: true)
        //new Athlete(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //athlete.id
    }

    void "test get"() {
        setupData()

        expect:
        athleteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Athlete> athleteList = athleteService.list(max: 2, offset: 2)

        then:
        athleteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        athleteService.count() == 5
    }

    void "test delete"() {
        Long athleteId = setupData()

        expect:
        athleteService.count() == 5

        when:
        athleteService.delete(athleteId)
        sessionFactory.currentSession.flush()

        then:
        athleteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Athlete athlete = new Athlete()
        athleteService.save(athlete)

        then:
        athlete.id != null
    }
}
