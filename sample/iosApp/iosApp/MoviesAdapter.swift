//
//  MoviesAdapter.swift
//  iosApp
//
//  Created by Anna Zharkova on 18.12.2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import UIKit
import shared

protocol  TableOwner : class {
    func select(index: Int)
}

class MoviesAdapter : NSObject,  UITableViewDelegate, UITableViewDataSource {
   private var items: [MoviesItem] = [MoviesItem]()
    weak var delegate: TableOwner? = nil
    
    func updateItems(items: [MoviesItem]) {
        self.items = [MoviesItem]()
        self.items.append(contentsOf: items)
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return items.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "MoviesCell", for: indexPath) as? MoviesCell else {
            return UITableViewCell()
        }
        
        cell.setupData(item: items[indexPath.row])
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.delegate?.select(index: indexPath.row)
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return UITableView.automaticDimension
    }
}
