package dojo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    void "test peers"() {
        given:
        Person splinter = new Person(name: 'Master Splinter')

        Person leo = new Person(name: 'Leonardo')
        Person donnie = new Person(name: 'Donatello')
        Person mikey = new Person(name: 'Michelangelo')
        Person raph = new Person(name: 'Raphael')

        splinter.addToStudents(leo)
        splinter.addToStudents(donnie)
        splinter.addToStudents(mikey)
        splinter.addToStudents(raph)

        leo.peers = [donnie, mikey, raph]
        donnie.peers = [leo, mikey, raph]
        mikey.peers = [leo, donnie, raph]
        raph.peers = [leo, donnie, mikey]

        expect:
        splinter.save(failOnError: true)
    }
}
