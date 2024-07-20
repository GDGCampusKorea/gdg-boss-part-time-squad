//
//  SceneDelegate.swift
//  market
//
//  Created by MK-Mac-413 on 7/19/24.
//

import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    var window: UIWindow?

    func scene(
        _ scene: UIScene,
        willConnectTo session: UISceneSession,
        options connectionOptions: UIScene.ConnectionOptions
    ) {
        guard let windowScene = (scene as? UIWindowScene) else { return }
        let window = UIWindow(windowScene: windowScene)
        window.rootViewController = TabBarViewController()
        window.makeKeyAndVisible()
        self.window = window
    }
}

