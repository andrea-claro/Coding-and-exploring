//
//  ItemStore.swift
//  MyGroceryList
//
//  Created by Andrea Claro on 05/02/2020.
//  Copyright © 2020 Andrea Claro. All rights reserved.
//

import UIKit

class ItemStore: NSObject {

    var listItem: [Item]
    
    override init (){
        listItem = [Item]()
    }
    
    func insert(item: Item?){
        listItem.append(item!)
    }
    
    func remove(index: Int?){
        listItem.remove(at: index!)
    }
    
    func move(from index1: Int?, to index2: Int?){
        let temp = listItem[index1!]
        listItem[index1!] = listItem[index2!]
        listItem[index2!] = temp
    }
}
