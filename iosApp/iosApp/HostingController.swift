//
//  HostingController.swift
//  iosApp
//
//  Created by Clem on 22.12.20.
//  Copyright © 2020 orgName. All rights reserved.
//

import UIKit
import test

class HostingControllerProxy: UIViewController {
    var hostingController: HostingController!
    
    override init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) {
        super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let resources = Resources(logo: "logo")
        hostingController = HostingController(controller: self, content: {
            ContentKt.Content(resources: resources)
        })
        hostingController.viewDidLoad()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        hostingController.refreshContent()
    }
    
    override func viewWillLayoutSubviews() {
        super.viewWillLayoutSubviews()
        hostingController.viewWillLayoutSubviews()
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        hostingController.viewDidLayoutSubviews()
    }
    
    override func viewWillTransition(to size: CGSize, with coordinator: UIViewControllerTransitionCoordinator) {
        super.viewWillTransition(to: size, with: coordinator)
        hostingController.refreshContent()
    }
    
    override func traitCollectionDidChange(_ previousTraitCollection: UITraitCollection?) {
        super.traitCollectionDidChange(previousTraitCollection)
        hostingController.refreshContent()
    }
    
    @available(iOS 11.0, *)
    override func viewSafeAreaInsetsDidChange() {
        super.viewSafeAreaInsetsDidChange()
        hostingController.refreshContent()
    }
}
