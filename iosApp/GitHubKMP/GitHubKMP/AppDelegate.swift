//
//  AppDelegate.swift
//  GitHubKMP
//
//  Created by Eduardo Pool Ake on 5/1/19.
//  Copyright © 2019 Eduardo Pool. All rights reserved.
//

import UIKit
import shared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    
    public lazy var dataRepository = { MembersDataRepository(api: GithubApi()) }()

    var window: UIWindow?

    static var appDelegate: AppDelegate {
        return UIApplication.shared.delegate as! AppDelegate
    }

}

