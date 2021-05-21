//
//  SearchVC.swift
//  MoviesIOS
//
//  Created by Anna Zharkova on 25.01.2021.
//

import UIKit
import shared

class SearchVC: UIViewController {
    
    @IBOutlet weak var searchBar: UISearchBar!
    @IBOutlet weak var listView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.listView.register(UINib(nibName: "MoviesCell", bundle: nil), forCellReuseIdentifier: "MoviesCell")
       
    }
}
    /*func bindViewModel() {
        self.viewModel.moviesList.bind {  [weak self](list) in
            guard let self = self else {return}
            if let items = list?.results {
                self.adapter.updateItems(items: items)
                self.listView.reloadData()
            }
        }
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.listView.delegate = adapter
        self.listView.dataSource = adapter
        self.adapter.delegate = self
        self.searchBar.delegate = self
        
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        self.listView.delegate = nil
        self.listView.dataSource = nil
        self.searchBar.delegate = nil
        self.adapter.delegate = nil
        super.viewWillDisappear(animated)
    }
    
    
}

extension SearchVC : UISearchBarDelegate {
    func searchBar(_ searchBar: UISearchBar, textDidChange searchText: String) {
        self.viewModel.queryMovies(query: searchText)
    }
    
    func searchBarSearchButtonClicked(_ searchBar: UISearchBar) {
        searchBar.resignFirstResponder()
        searchBar.endEditing(true)
    }
    
    func searchBarCancelButtonClicked(_ searchBar: UISearchBar) {
        
        searchBar.text = ""
        searchBar.resignFirstResponder()
        searchBar.endEditing(true)
    }
}
extension SearchVC : TableOwner {
    func select(index: Int) {
       
    }
}
*/
