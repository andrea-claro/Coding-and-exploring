//
//  CellItem.swift
//  MyGroceryList
//
//  Created by Andrea Claro on 05/02/2020.
//  Copyright © 2020 Andrea Claro. All rights reserved.
//

import UIKit

class CellItem: UITableViewCell {

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        // Configure the view for the selected state
    }

    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var quantityLabel: UILabel!
}
