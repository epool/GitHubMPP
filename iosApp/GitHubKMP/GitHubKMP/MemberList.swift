//
//  MemberList.swift
//  GitHubKMP
//
//  Created by Eduardo Pool Ake on 5/1/19.
//  Copyright © 2019 Eduardo Pool. All rights reserved.
//

import Foundation
import shared

class MemberList {
    
    var members: [Member] = []
    
    func updateMembers(_ newMembers: [Member]) {
        members.removeAll()
        members.append(contentsOf: newMembers)
    }
    
}
