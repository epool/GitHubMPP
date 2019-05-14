//
//  ViewController.swift
//  GitHubKMP
//
//  Created by Eduardo Pool Ake on 5/1/19.
//  Copyright © 2019 Eduardo Pool. All rights reserved.
//

import UIKit
import SDWebImage
import shared

class ViewController: UIViewController, MembersView {

    var members: [Member] = []

    lazy var presenter: MembersPresenter = {
        MembersPresenter(view: self, repository: AppDelegate.appDelegate.dataRepository)
    }()

    var isUpdating = false

    @IBOutlet weak var greeting: UILabel!
    @IBOutlet weak var membersTableView: UITableView!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        greeting.text = Greeting().greeting()
        
        membersTableView.register(UINib(nibName: "MemberCellTableViewCell", bundle: nil), forCellReuseIdentifier: "MemberCell")
    }

    override func viewWillAppear(_ animated: Bool) {
        presenter.onCreate()
    }

    override func viewWillDisappear(_ animated: Bool) {
        presenter.onDestroy()
    }

    func onUpdate(members: [Member]) {
        self.members.removeAll()
        self.members.append(contentsOf: members)
        self.membersTableView.reloadData()
    }

}

extension ViewController: UITableViewDataSource {

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.members.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "MemberCell", for: indexPath) as! MemberCellTableViewCell
        let member = self.members[indexPath.row]
        cell.memberLogin.text = member.login
        cell.memberAvatar?.sd_setImage(with: URL(string: member.avatarUrl), placeholderImage: nil)
        return cell
    }

}
