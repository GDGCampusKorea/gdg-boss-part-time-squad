//
//  TabItems.swift
//  market
//
//  Created by MK-Mac-413 on 7/19/24.
//

import UIKit

enum TabItems: Int {
    case home
    case recruit
    case post
    
    // MARK: Computed Properties
    // MARK: Public
    var tabBarItem: UITabBarItem {
        UITabBarItem(
            title: title,
            image: image,
            selectedImage: selectedImage
        )
    }
    
    var viewController: UIViewController {
        switch self {
        case .home:     HomeViewController()
        case .recruit:  RecruitListViewController()
        case .post:     PostCreateViewController()
        }
    }
    
    // MARK: Private
    private var title: String {
        switch self {
        case .home:     "홈"
        case .recruit:  "알바모집"
        case .post:     "글쓰기"
        }
    }
    
    private var image: UIImage? {
        switch self {
        case .home:     UIImage(systemName: "house")
        case .recruit:  UIImage(systemName: "person.3")
        case .post:     UIImage(systemName: "pencil.circle")
        }
    }
    
    private var selectedImage: UIImage? {
        switch self {
        case .home:     UIImage(systemName: "house.fill")
        case .recruit:  UIImage(systemName: "person.3.fill")
        case .post:     UIImage(systemName: "pencil.circle.fill")
        }
    }
}

extension TabItems: CaseIterable { }
