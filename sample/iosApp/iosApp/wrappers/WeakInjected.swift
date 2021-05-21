//
//  WeakInjected.swift
//  iosApp
//
//  Created by Anna Zharkova on 04.04.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

@propertyWrapper struct WeakLazyInjected<T:AnyObject> {
    private var initialize: Bool = true
    private weak var service: T?
    public var container: DIManager?
    
    public var name: String?
    public var args: Any?
    public init() {}
    public init(name: String? = nil, container: DIManager? = Util.shared.container) {
        self.name = name
        self.container = container
    }
    public var isEmpty: Bool {
        return service == nil
    }
    public var wrappedValue: T? {
        mutating get {
            if initialize {
                self.initialize = false
                if container == nil {
                    self.container = Util.shared.container
                }
                self.service = container?.resolve(clazz: T.self) as? T
            }
            return service
        }
        mutating set { service = newValue  }
    }
    public var projectedValue: WeakLazyInjected<T> {
        get { return self }
        mutating set { self = newValue }
    }
}
