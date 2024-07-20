import ProjectDescription

let project = Project(
    name: "gdg-boss",
    organizationName: "com.gdg",
    targets: [
        Target.appTarget()
    ]
)

public extension Target {
    static func appTarget() -> Target {
        .target(
            name: "gdg-boss",
            destinations: .iOS,
            product: .app,
            bundleId: "com.gdg.boss",
            infoPlist: "gdg/SupportingFiles/Info.plist",
            sources: ["gdg/Sources/**"],
            resources: ["gdg/Resources/**"],
            dependencies: [
                .external(name: "SnapKit")
            ],
            settings: Settings.settings(
                base: [
                    "CURRENT_PROJECT_VERSION": "1",
                    "MARKETING_VERSION": "1.0"
                ],
                defaultSettings: .recommended
            )
        )
    }
}
