//
//  Item.swift
//  MyGroceryList
//
//  Created by Andrea Claro on 05/02/2020.
//  Copyright © 2020 Andrea Claro. All rights reserved.
//

import UIKit

class Item: NSObject {
    
    var des: String?
    var name: String?
    var quantity: Int?
    var data: Date?
    
    init(description: String?, name: String?, quantity: Int?, date: Date = Date()){
        self.des = description
        self.name = name
        self.quantity = quantity
        self.data = date
    }
}
