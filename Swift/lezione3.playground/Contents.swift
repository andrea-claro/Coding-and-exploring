import UIKit

var str = "lezione 3"


//prova di classe
class PersonClass{
    var name: String?
}

let paul = PersonClass()
paul.name = "Paul"

let john = paul
john.name = "John"

print(paul.name!)
print(john.name!)


//prova di struttura
struct PersonStruct{
    var name: String?
}

var poul = PersonStruct()
poul.name = "Paul"

let jihn = paul
jihn.name = "John"

print("\n", poul.name!)
print(jihn.name!)



class Person{
    var name: String?
    var numero: Int {
        return 3
    }
    init(name: String) {
        self.name = name
    }
    
    func printingName(){
        print(self.name ?? "Non ho nome")
    }
}

struct Department{
    let amministrator: Persona
}

struct Persona{
    var nome: String?
}

var persona: Persona = Persona()
persona.nome = "Gigi"
print("\n \(persona.nome!)")

let andrea = Person(name: "Andrea")

var d1 = Department(amministrator: persona)
var d2 = Department(amministrator: persona)

print("\n", d1.amministrator.nome!)
print(d2.amministrator.nome!)

persona.nome = "Gerardo"

print(d1.amministrator.nome!)
print(d2.amministrator.nome!)



//getter e setter
struct Temperature{
    var celsius: Int = 0
    var kelvin: Int{
        get{
            return celsius + 273
        }
        set(newKelvin){
            celsius = newKelvin - 273
        }
    }
}

var temp = Temperature(celsius: 10)
print("\nTemperature is: \(temp.kelvin)")
print("Temperature is: \(temp.celsius)")

temp.celsius = 10
temp.kelvin = 22

print("Temperature is: \(temp.kelvin)")
print("Temperature is: \(temp.celsius)")



//Osservatori
class EquiTriangle{
    var side: Double = 0.0{
        willSet{
            if newValue < 0{
                print("\nThe value \(newValue) is invalid")
            }
        }
        didSet{
            if side < 0{
                side = oldValue
            }
        }
    }
}
var triangle = EquiTriangle()
triangle.side = -5
print("Side: \(triangle.side)")


//Polygon class
class Polygon{
    var description: String?
    
    var nSides: Int = 3{
        didSet{
            if nSides < 3{
                nSides = oldValue
            }
            
            switch nSides{
            case 3:
                description = "Triangle"
            case 4:
                description = "Square"
            default:
                description = "This is a polygon"
            }
        }
    }
    
    var sideSize: Int = 5
    var perimeter: Int{
        get{
            return self.nSides*self.sideSize
        }
    }
    
    lazy var area: String = {
        return "sono l'area di \(nSides) lati"
    }()
    
    init(nSides: Int = 0){
        self.nSides = nSides
    }
    
    func printing(){
        print(self.description!)
        print(self.nSides)
        print(self.sideSize)
        print(self.perimeter)
        print(self.area)
    }
}

var polygon = Polygon(nSides: 2)
print("\n",polygon.description ?? "no description")
polygon.nSides = 4
print(polygon.description!)
print(polygon.area)
polygon.nSides = 5
print(polygon.description!)
print(polygon.area)
print("\n\n")
polygon.printing()



class Student: Person{
    override func printingName() {
        print("ho fatto l'override")
        super.printingName()
    }
    override var numero: Int {
        return super.numero*4
    }
}
 
let sub: Student = Student(name: "Filippo")
print("\n", sub.name ?? "Non ha nome")
sub.printingName()
print(sub.numero)



class Town{
    var population: Int
    var buildings: Int
    var name: String?
    
    init(population: Int, buildings: Int, name: String){
        self.population = population
        self.buildings = buildings
        self.name = name
    }
    
    func afterDestruction(population: Int, buildings: Int){
        self.population -= population
        self.buildings -= buildings
    }
    
    func printInfo(){
        print("In town there are \(population) people still alive and \(buildings) still working")
    }
}

class Monster{
    var name: String?
    var cityToInvade: Town
    
    init(name: String, toInvade city: Town){
        self.name = name
        self.cityToInvade = city
    }
    func destruction(persons killed: Int, buildings destroyed: Int){
        print("Tasse da pagare:")
        self.cityToInvade.afterDestruction(population: killed, buildings: destroyed)
    }
    
    func printInfo(){
        print("The monster's name is \(name!) and the city that it wants to invade is \(cityToInvade.name!)")
    }
}

class SuperMonster: Monster{
    var tasseDaPagare: Int
    
    init(daPagare tasse: Int, name: String, toInvade city: Town){
        self.tasseDaPagare = tasse
        super.init(name: name, toInvade: city)
    }

     func destruction(tasse: Int, persons killed: Int, buildings destroyed: Int) {
        super.destruction(persons: killed, buildings: destroyed)
        self.tasseDaPagare = tasse
        print("sono arrivate a \(tasseDaPagare) euro")
    }
}

class Hero{
    var name: String?
    var monsterToDestroy: SuperMonster
    
    init(name: String, toDestry monster: SuperMonster){
        self.name = name
        self.monsterToDestroy = monster
    }
    
    func printingInfo(){
        print("\(name!) wants to save the world, let's see if it's capable of it")
    }
    
    func savePeople(taxes: Int, people: Int, structures: Int){
        print("The \(monsterToDestroy.name!) monster is running away, and is everything like it was before him")
        monsterToDestroy.destruction(tasse: taxes, persons: -people, buildings: -structures)
    }
}


print("\n\n")
var city = Town(population: 120, buildings: 60, name: "Fisciano")
city.printInfo()
var monster = SuperMonster(daPagare: 30, name: "Canone Rai", toInvade: city)
monster.printInfo()
monster.destruction(persons: 20, buildings: 10)
city.printInfo()
var hero = Hero(name: "Gabibbo", toDestry: monster)
hero.printingInfo()
hero.savePeople(taxes: 0, people: 20, structures: 10)
