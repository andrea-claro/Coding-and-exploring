import UIKit

var str = "lezione 1"
print(str+"\n")

var a:String
a = "12"
print(a)



print("\n########## TUPLE:")
var tuple = ("ciao", "sono", "andrea")
print(tuple)
print(tuple.0)
print(tuple.1)
print(tuple.2)

var namedTuple = (nome: "Andrea", cognome: "Claro")
print(namedTuple.nome)
print(namedTuple.cognome)



print("\n########## ARRAY:")
var c = Array<Int>(repeating: 2, count: 3)
print(c)

var d = [Int]()
d.append(3)
d.append(4)
d.append(5)
d.remove(at: 2)
print(d)

var addingArray = c + d
print(addingArray)

d.insert(5, at: 2)
print(d)

print(d.count)
print(d[1...2])



print("\n########## CHALLENGE ARRAY:")
var consoleGames = Array<(title:String, console:String)>()
print(consoleGames)
consoleGames.append((title:"Uncharted", console:"PS"))
print(consoleGames)
consoleGames.append((title:"Halo", console:"XBOX"))
print(consoleGames)


var gamesTitle = [(title:String, console:String)]()
gamesTitle.append(("Super Mario Bros","NES"))
gamesTitle.append(("Age of Empires","PC"))
print(gamesTitle)



print("\n########## SET:")
var firstSet = Set<Int>()
print(firstSet)
firstSet.insert(1)
firstSet.insert(2)
firstSet.insert(3)
firstSet.insert(1)
print(firstSet)

var secondSet = Set<Int>()
secondSet.insert(4)
secondSet.insert(1)
secondSet.insert(6)
print(secondSet)

var interSet = firstSet.intersection(secondSet)
print(interSet)

var symmSet = firstSet.symmetricDifference(secondSet)
print(symmSet)

var unionSet = firstSet.union(secondSet)
print(unionSet)

var diffSet = firstSet.subtracting(secondSet)
print(diffSet)



print("\n########## DICTIONARIES:")
var dict = Dictionary<Int, String>()
dict[0] = "Sciacallo"
dict[1] = "Uccello"
print(dict)
print(dict[1])
print(dict[1]!)



print("\n########## CHALLENGE CONDITIONS:")
var grade:Double = 5

if grade < 0.87{
    print("F-")
}
else if 0.87 < grade && grade < 1.69 {
    print("F+")
}
else if 1.70 < grade && grade < 2.52 {
    print("E-")
}
else if 2.53 < grade && grade < 3.35 {
    print("E+")
}
else if 3.36 < grade && grade < 4.18 {
    print("D-")
}
else if 4.19 < grade && grade < 5.01 {
    print("D+")
}
else if 5.02 < grade && grade < 5.84 {
    print("C-")
}
else if 5.85 < grade && grade < 6.67 {
    print("C+")
}
else if 6.68 < grade && grade < 7.5 {
    print("B-")
}
else if 7.51 < grade && grade < 8.33 {
    print("B+")
}
else if 8.34 < grade && grade < 10 {
    print("A+")
}

//switch grade{
//    case 0.87 < grade && grade < 1.69:
//    print("oh")
//    default:
//    print("ciao")
//}

var name = "Andrea"
switch name.count{
case 5:
    print("oh")
case 6:
    print("Mmm")
    fallthrough
default:
    print("Shh")
}
