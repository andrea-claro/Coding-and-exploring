//
//  ViewController.swift
//  TestProject
//
//  Created by Andrea Claro on 04/02/2020.
//  Copyright © 2020 Andrea Claro. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var op: Bool = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
 
    @IBOutlet weak var primoOperando: UILabel!
    @IBOutlet weak var operazione: UILabel!
    @IBOutlet weak var secondoOperando: UILabel!
    @IBOutlet weak var risultato: UILabel!
    
    @IBAction func buttonPressed(_ sender: UIButton) {
        print(sender.titleLabel!.text!)
        if op == false {
            switch sender.titleLabel!.text! {
            case "0":
                primoOperando.text! += "0"
            case "1":
                primoOperando.text! += "1"
            case "2":
                primoOperando.text! += "2"
            case "3":
                primoOperando.text! += "3"
            case "4":
                primoOperando.text! += "4"
            case "5":
                primoOperando.text! += "5"
            case "6":
                primoOperando.text! += "6"
            case "7":
                primoOperando.text! += "7"
            case "8":
                primoOperando.text! += "8"
            case "9":
                primoOperando.text! += "9"
            case ".":
                primoOperando.text! += "."
            case "+":
                operazione.text! += "+"
                self.op = true
            case "-":
                operazione.text! += "-"
                self.op = true
            case "%":
                operazione.text! += "%"
                self.op = true
            case "*":
                operazione.text! += "*"
                self.op = true
            case "/":
                operazione.text! += "/"
                self.op = true
            case "=":
                break
            default:
                primoOperando.text! = ""
                operazione.text! = ""
                secondoOperando.text! = ""
                risultato.text! = ""
                break
            }
        }
            
            
            
        else {
            let first: Double?
            let second: Double?
            let result: Double?
            
            switch sender.titleLabel!.text! {
            case "0":
                secondoOperando.text! += "0"
            case "1":
                secondoOperando.text! += "1"
            case "2":
                secondoOperando.text! += "2"
            case "3":
                secondoOperando.text! += "3"
            case "4":
                secondoOperando.text! += "4"
            case "5":
                secondoOperando.text! += "5"
            case "6":
                secondoOperando.text! += "6"
            case "7":
                secondoOperando.text! += "7"
            case "8":
                secondoOperando.text! += "8"
            case "9":
                secondoOperando.text! += "9"
            case ".":
                secondoOperando.text! += "."
            case "=":
                if operazione.text! == "+"{
                    first = Double(primoOperando.text!)
                    second = Double(secondoOperando.text!)
                    result = first! + second!
                    risultato.text! = String(result!)
                }
                else if operazione.text! == "*" {
                    first = Double(primoOperando.text!)
                    second = Double(secondoOperando.text!)
                    result = first! * second!
                    risultato.text! = String(result!)
                }
                else if operazione.text! == "-" {
                    first = Double(primoOperando.text!)
                    second = Double(secondoOperando.text!)
                    result = first! - second!
                    risultato.text! = String(result!)
                }
                else if operazione.text! == "/" {
                    first = Double(primoOperando.text!)
                    second = Double(secondoOperando.text!)
                    result = first! / second!
                    risultato.text! = String(result!)
                }
            case "+":
                break
            case "-":
                break
            case "%":
                break
            case "*":
                break
            case "/":
                break
            default:
                secondoOperando.text! = ""
                operazione.text! = ""
                primoOperando.text! = ""
                risultato.text! = ""
                self.op = false
                break
            }
        }
    }
}
