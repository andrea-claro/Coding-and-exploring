import UIKit
//Rettangolo
//punti del rettangolo
var p1X = 2, p1Y = 2
var p2X = 4, p2Y = 2
var p3X = 4, p3Y = 8
var p4X = 2, p4Y = 8
//punto da dover visualizzare
var pX = 3, pY = 3
print("Il punto è alle coordinate: ", pX,",", pY)

if(p1X <= pX  &&  pX <= p2X){
    if(p1Y <= pY  &&  pY <= p4Y){
        print("Il punto è dentro: \(pX), \(pY)")
    }
    else{
        print("Il punto è fuori: \(pX), \(pY)")
    }
}
else{
    print("Il punto è fuori: \(pX), \(pY)")
}

var n = 6
var fact = 1;
print("\n", n)
for x in (1...6){
    fact *= x
}
print(fact)
