import UIKit

var str = "lezione 2"


print("\n########## CHALLENGE FIBONACCI:")
func fibonacci(fib n:Int) -> (Int){
    if n == 0{
        return 1
    }
    else if n == 1{
        return 1
    }
    return fibonacci(fib: n-1) + fibonacci(fib: n-2)
}
print(fibonacci(fib: 6))



print("\n########## CHALLENGE FACTORIAL:")
func fattoriale(fact n:Int) -> (Int){
    if n < 0{
        return -1
    }
    if n == 0{
        return 1
    }
    return n * fattoriale(fact: n-1)
}
print(fattoriale(fact: 6))


let matricola: (String, String?) = (prefisso:"05121", suffisso:nil)
print(matricola.1)
