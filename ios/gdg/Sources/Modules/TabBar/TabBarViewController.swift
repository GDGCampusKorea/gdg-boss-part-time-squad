//
//  TabBarViewController.swift
//  market
//
//  Created by MK-Mac-413 on 7/19/24.
//

import UIKit

final class TabBarViewController: UITabBarController {
    
    // MARK: - Initializers
    // MARK: Public
    init() {
        super.init(nibName: nil, bundle: nil)
        configureSubTabs()
        view.backgroundColor = .white
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configureSubTabs()
        view.backgroundColor = .white
    }
    
    // MARK: - Configuration
    // MARK: Private
    private func configureSubTabs() {
        let viewControllers = TabItems.allCases.map { item in
            let controller = item.viewController
            controller.tabBarItem = item.tabBarItem
            return UINavigationController(rootViewController: controller)
        }
        setViewControllers(viewControllers, animated: false)
    }
}
