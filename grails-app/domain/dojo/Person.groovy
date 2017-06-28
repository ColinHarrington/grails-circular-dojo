package dojo

class Person {
    String name

    static belongsTo = [master: Person]

    static hasMany = [students: Person, peers: Person]
    static mappedBy = [students: 'none', peers: 'none']

    static constraints = {
    }
}
