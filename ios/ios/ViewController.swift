//
//  ViewController.swift
//  ios
//
//  Created by g.putintsev on 13.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import UIKit
import RxSwift
class ViewController: UIViewController,  RuKorincRuntimeRxConsumer, UITableViewDataSource, UITableViewDelegate  {
    
    @IBOutlet weak var result: UITextField!

    @IBOutlet weak var list: UITableView!
    
    var res:Array<String> = Array<String>()

    
    var d:RuKorincRuntimeRxDisposableWrapper?
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return res.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // Getting the right element
        let element = res[indexPath.row]
        
        // Instantiate a cell
        let cell = UITableViewCell(style: .default, reuseIdentifier: "ElementCell")
        
        // Adding the right informations
        cell.textLabel?.text = element
        // Returning the cell
        return cell
    }

    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        list.dataSource = self
        
        let searchResults = AppCore.sharedActor().model?.getSearchResults().observeOnMain()
        searchResults?.subscribe(with: self)
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    deinit {
        d?.dispose()
    }
    
    func accept(withId val: Any!) {
        res = (val as! JavaUtilArrayList).toNSArray()
    }


}

