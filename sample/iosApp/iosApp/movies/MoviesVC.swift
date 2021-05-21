//
//  MoviesVC.swift
//  iosApp
//
//  Created by Anna Zharkova on 18.12.2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import UIKit
import shared

class MoviesVC: UIViewController, IMoviesListView {
    
    override init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) {
        super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil)
        $interactor.view = self
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        $interactor.view = self
    }
    
    @InjectedInView  var interactor: IMoviesListInteractor?
    
    private var adapter = MoviesAdapter()
    
    @IBOutlet weak var listView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        $interactor.view = self
        self.listView.register(UINib(nibName: "MoviesCell", bundle: nil), forCellReuseIdentifier: "MoviesCell")
    }
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.adapter.delegate = self
        self.listView.delegate = adapter
        self.listView.dataSource = adapter
        self.interactor?.attachView()
        self.interactor?.loadMovies()
      
     
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        self.listView.delegate = nil
        self.listView.dataSource = nil
        self.adapter.delegate = nil
        self.interactor?.detachView()
        super.viewWillDisappear(animated)
    }
    
    func setup(items: [MoviesItem]) {
        self.adapter.updateItems(items: items)
        self.adapter.delegate = self
        self.listView.delegate = adapter
        self.listView.dataSource = adapter
        self.listView.reloadData()
    }

}

extension MoviesVC : TableOwner {
    func select(index: Int) {
     
    }
}


