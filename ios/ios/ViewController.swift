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
    
    var d:RuKorincRuntimeRxDisposableWrapper?
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
              // Instantiate a cell
        let cell = UITableViewCell(style: .subtitle, reuseIdentifier: "ElementCell")
        
        // Adding the right informations
        
        // Returning the cell
        return cell
    }

   
    
    func accept(withId val: Any!) {
       
    }

}

