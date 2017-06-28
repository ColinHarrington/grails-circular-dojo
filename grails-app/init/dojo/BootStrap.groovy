package dojo

class BootStrap {

    def init = { servletContext ->
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
    def destroy = {
    }
}
