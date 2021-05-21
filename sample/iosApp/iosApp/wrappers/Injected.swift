//
//  Inject.swift
//  iosApp
//
//  Created by Anna Zharkova on 04.04.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

@propertyWrapper
struct Injected<T:AnyObject> {
    private var service: T?
    public  var container: DIManager? = nil
    public var name: String?
    public init() {}
    public init(name: String? = nil, container: DIManager? = Util.shared.container) {
        self.name = name
        self.container = container
    }
    public var wrappedValue: T? {
        mutating get {
            if self.service == nil {
                if container == nil {
                    self.container = Util.shared.container
                }
                self.service = container?.resolve(clazz: T.self) as? T
            }
            return service
        }
        mutating set { service = newValue  }
    }
    public var projectedValue: Injected<T> {
        get { return self }
        mutating set { self = newValue }
    }
}
