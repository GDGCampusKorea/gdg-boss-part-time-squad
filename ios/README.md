# GDG Boss iOS 

GDG 상사 iOS 레포지토리 입니다.

# Requirements
아래의 요구사항을 미리 준비해 주세요.
 - Xcode (Latest version)
 - [Homebrew](https://brew.sh/) 

# Set up
스크립트를 실행해 프로젝트를 구성합니다.

    sh init.sh

# Stack
참가자분들의 레포지토리와 자기소개를 기반으로 가장 많이 경험하신 스택을 채택했습니다.

- UIKit(SnapKit)을 통해 UI를 구성합니다.
- 그 외의 dependency는 사용하지 않습니다.
- Combine 등의 추가적인 dependency 없이 가능한 import는 가능합니다.

# Folder
```
ios
├── Project.swift
├── Tuist
│   └── Package.swift
├── gdg
│   ├── Resources
│   │   └── Assets.xcassets (리소스 추가)
│   ├── Sources
│   │   ├── App (사용 필요 X)
│   │   │   ├── AppDelegate.swift
│   │   │   └── SceneDelegate.swift
│   │   └── Modules
│   │       ├── Home (추천 스쿼드)
│   │       ├── Post (리스크 스쿼드)
│   │       ├── Recruit (알바 스쿼드)
│   │       └── TabBar
│   └── SupportingFiles
│       └── Info.plist
└── init.sh (프로젝트 생성 스크립트)
```

각각의 스쿼드에선 `ios/gdg/Sources/Modules/{해당스쿼드}` 경로 파일을 추가해 코드를 작성합니다.
공통 사용을 위한 extension 코드도 위 경로 하위에 폴더를 생성해 주시면 됩니다.
AppDelegate, Info.plist의 파일 수정이 필요한 경우 멘토에게 문의해 주세요.

# Rule
아래의 룰을 참고해 프로젝트를 진행해 주세요.

## Naming

1. 파일: 해당하는 폴더명의 Prefix 붙이기. (Ex: HomeViewController, HomeListCell, HomeEditButton)
2. 리소스: 사용할 화면의 Prefix 붙이기. (Ex: home.edit.button.icon)
3. 클래스, 변수명: 각자 스쿼드 인원들과 적절히 논의해 지어주세요. (알아서 지어도 됩니다.)

## Coding
화면 아래의 레이어에 대해서도 스쿼드 인원들과 논의/담당해 업무분장을 진행해 주세요.

만약 우리의 스쿼드는 MVVM을 채택한다고 하면 View를 구현할 사람, ViewModel을 구현할 사람, Network를 구현할 사람을 나눠주시면 됩니다.

즉, 위의 룰을 제외하고는 자유롭게 코딩을 진행해 주세요.
