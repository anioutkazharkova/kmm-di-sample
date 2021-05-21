//
//  MainTabVC.swift
//  MoviesIOS
//
//  Created by Anna Zharkova on 25.01.2021.
//

import UIKit

class MainTabVC: UITabBarController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let movies = MoviesVC()
        movies.tabBarItem =  UITabBarItem(tabBarSystemItem: .bookmarks, tag: 0)
        
        let search = SearchVC()
        search.tabBarItem =  UITabBarItem(tabBarSystemItem: .search, tag: 1)
        self.viewControllers = [UINavigationController(rootViewController: movies),
                                UINavigationController(rootViewController: search)]
    }
}
