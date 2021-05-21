//
//  Util.swift
//  iosApp
//
//  Created by Anna Zharkova on 04.04.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class Util{
    static var shared = Util()
    private lazy var config: ConfigurationApp = {
       return ConfigurationApp()
    }()
    
    lazy var container: DIManager = {
        return config.appContainer
    }()
}
