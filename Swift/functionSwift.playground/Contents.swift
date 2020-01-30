import UIKit

// First functions
func greet(person: String) -> String{
    let greeting = "Hello, " + person + "!"
    return greeting
}

print(greet(person: "Andrea"))




//Understanding the label work
func funz(_ n2: Int, _ n1: Int) ->(Int, Int){
    let a = n2 + n1
    let b = n2 * n1
    return (a, b)
}

var c = funz(1, 2)
print(c)




//trying to pass a function
func callingFunction(function: (Int, Int) ->(Int, Int), n1:Int, n2:Int) -> (Int, Int){
    return function(n1, n2)
}

var d = callingFunction(function: funz, n1: 2, n2: 1)
print(d)




//Undertanding that the function has been passed via reference
func makeIncrementer(forIncrement amount: Int) -> () -> Int{
    var runningTotal = 0
    
    func incrementer() -> Int{
        runningTotal += amount
        print(runningTotal)
        return runningTotal
    }
    
    return incrementer
}

var a = makeIncrementer(forIncrement: 7)
a()
var b = a
b()
a()




//MAP functional pattern
let worldWord = ["Gerado", "Andrea", "Salvatore", "Biagio", "Domenico", "Emmanuel"]
print(worldWord)
let worldWordCount = worldWord.map{
    $0.count
}
print(worldWordCount)


//FILTER functional pattern
let worldWordFilter = worldWord.filter{
    $0.count > 6
}


//REDUCE functional pattern
//let worldWordReduce = worldWord.reduce(0,{
  //  $0.count, $1.count
    //    in $0 + $1
    //}
//)
