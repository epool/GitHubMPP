//
//  MemberCellTableViewCell.swift
//  GitHubKMP
//
//  Created by Eduardo Pool Ake on 5/1/19.
//  Copyright © 2019 Eduardo Pool. All rights reserved.
//

import Foundation
import UIKit
import shared

class MemberCellTableViewCell: UITableViewCell {

    @IBOutlet weak var memberAvatar: UIImageView!
    @IBOutlet weak var memberLogin: UILabel!

    func bind(member: Member) {
        self.memberLogin.text = member.login
        self.memberAvatar?.sd_setImage(with: URL(string: member.avatarUrl), placeholderImage: nil)
    }

}
