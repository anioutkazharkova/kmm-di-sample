//
//  InjectInView.swift
//  iosApp
//
//  Created by Anna Zharkova on 04.04.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

@propertyWrapper
struct InjectedInView<T:AnyObject> {
    private var service: T?
    public  var container: DIManager = Util.shared.container
    public weak var view: IView?
    
    public init(){}
    public init(container: DIManager){
        self.container = container
    }
    
    public var wrappedValue: T? {
        mutating get {
            if self.service == nil {
              
                guard let view = self.view else {return service}
                self.service = container.resolve(view: view) as? T
            }
            return service
        }
        mutating set { service = newValue  }
    }
    public var projectedValue: InjectedInView<T> {
        get { return self }
        mutating set { self = newValue }
    }
}

