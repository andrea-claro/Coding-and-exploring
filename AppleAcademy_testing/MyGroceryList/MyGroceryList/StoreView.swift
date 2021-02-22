//
//  StoreView.swift
//  MyGroceryList
//
//  Created by Andrea Claro on 05/02/2020.
//  Copyright © 2020 Andrea Claro. All rights reserved.
//

import UIKit

class StoreView: UITableViewController {

    static var itemStore: ItemStore = ItemStore()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        self.navigationItem.leftBarButtonItem = self.editButtonItem
        
        StoreView.itemStore.insert(item: Item(description: "giallo", name: "color", quantity: 3))
        StoreView.itemStore.insert(item: Item(description: "blue", name: "color", quantity: 1))
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        tableView.reloadData()
    }
    
    @IBAction func createNewItem(_ sender: UIBarButtonItem) {
        StoreView.itemStore.createEmptyItem()

        let indexpath = IndexPath(row: StoreView.itemStore.listItem.count-1, section: 0)
        
        tableView.insertRows(at: [indexpath], with: .automatic)
    }
    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return StoreView.itemStore.listItem.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "cellItem", for: indexPath) as! CellItem
        let item = StoreView.itemStore.listItem[indexPath.row]
        
        cell.nameLabel.text! = item.name!
        cell.descriptionLabel.text! = item.des!
        cell.quantityLabel.text! = String(item.quantity!)
        
        return cell
    }
    
     override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
        StoreView.itemStore.move(from: fromIndexPath.row, to: to.row)
        }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            StoreView.itemStore.listItem.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
        }
    }

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        switch segue.identifier{
            
        case "showDetails"?:
            if let currentIndex = tableView.indexPathForSelectedRow?.row{
                let item = StoreView.itemStore.listItem[currentIndex]
                
                let destinationView = segue.destination as! DetailsView
                
                destinationView.currentItem = item
            }
            
        default: print(#function)
        }
    }
    

}
