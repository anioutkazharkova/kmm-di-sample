//
//  MovieItemVC.swift
//  MoviesIOS
//
//  Created by Anna Zharkova on 25.01.2021.
//

import UIKit
import shared
/*
class MovieItemVC: UIViewController {
    var interactor: IInteractor? {
        get {
            ret
        }
    }
    
   @InjectedInView(self) var interactor: IMoviesListInteractor?

    @IBOutlet weak var movieImageView: UIImageView!
    @IBOutlet weak var titleLabelText: UILabel!
    @IBOutlet weak var movieTextLabel: UILabel!
    
    override init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) {
        super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil)
        self.hidesBottomBarWhenPushed = true
    }
    
    func bindViewModel() {
        self.viewModel.movieItem.bind {  [weak self](item) in
            guard let self = self else {return}
            if let item = item {
            self.titleLabelText.text = item.title
            self.movieTextLabel.text = item.overview
            self.movieImageView.kf.setImage(with: URL(string: item.imagePath()))
            }
        }
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.hidesBottomBarWhenPushed = true
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.bindViewModel()
        self.viewModel.load()
    }
    
    func setup(_ data: Any?) {
        if let data = data as? MoviesItem {
            self.viewModel.setupItem(item: data)
        }
    }
}
*/
