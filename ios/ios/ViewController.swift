//
//  ViewController.swift
//  ios
//
//  Created by g.putintsev on 13.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var addCount: UIButton!
    @IBOutlet weak var result: UITextField!

    @IBOutlet weak var pb: UIActivityIndicatorView!
    @IBAction func click(_ sender: UIButton) {
        
        //AppCore.sharedActor().model?.count(with: 4)
        
    }
    
    var d:RuKorincRuntimeRxDisposableWrapper?
    override func viewDidLoad() {
        super.viewDidLoad()
        
        pb.startAnimating()
        // Do any additional setup after loading the view, typically from a nib.
        
        //let res = AppCore.sharedActor().model?.subscribeCount().observeOnMain()
        //res?.subscribe(with: CountListenerToText(et: result))
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    deinit {
        d?.dispose()
    }


}

class CountListenerToText:NSObject, RuKorincRuntimeRxConsumer{
    var et: UITextField?
    
    init(et: UITextField) {
        self.et = et
    }
    
    func accept(withId val: Any!) {
        et?.text = val as! String?
    }
}

