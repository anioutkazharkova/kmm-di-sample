//
//  MoviesCell.swift
//  iosApp
//
//  Created by Anna Zharkova on 18.12.2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import UIKit
import Kingfisher
import shared

class MoviesCell: UITableViewCell {

    @IBOutlet weak var movieOverview: UILabel!
    @IBOutlet weak var movieTitle: UILabel!
    @IBOutlet weak var movieImage: UIImageView!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

   func setupData(item: MoviesItem){
        self.movieTitle.text = item.title
        self.movieOverview.text = item.overview
        self.movieImage.kf.setImage(with: URL(string: item.imagePath()))
    }
}
