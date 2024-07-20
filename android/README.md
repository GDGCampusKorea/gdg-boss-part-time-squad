# GDG Boss Android

GDG 상사 Android 레포지토리 입니다.

# Requirements
아래의 요구사항을 미리 준비해 주세요.
 - Android Studio Lguana 이상
 - Android Gradle Plugin 8.0 이상 

# Stack
참가자분들의 레포지토리와 자기소개를 기반으로 가장 많이 경험하신 스택을 채택했습니다.

- `ComposeMainActivity`와 `XmlMainActivity` 두개가 존재합니다. 
    - Compose 에 익숙한 참가자 분들은 ComposeMainActivity 를 사용.
    - View 에 익숙한 참가자 분들은 XmlMainActivity 를 사용해주시면 됩니다. 
- dependency injection 은 hilt 를 사용하였습니다. 혹여 hilt 를 사용해보지 않았거나, 사용이 아직 어색한 참가자 분들은 제거해도 무방합니다.
- network 통신은 retrofit/okhttp 로 구성하였습니다.
- 그 외 추가적인 library 는 자유롭게 사용 가능합니다.

모든 library 셋팅은 템플릿이며, 참가자분들의 스타일에 맞추어 자유롭게 변경해도 무방합니다. 


# Folder
```
android
├── com.gdg.boss
│   ├── theme (compose 전용)
│   ├── ui
│   │   ├── ComposeMainActivity (compose 전용)
│   │   └── XmlMainActivity (xml 전용)
│   ├── App (사용X)
│   ├── DataModule
│   ├── TestApi
│   ├── TestRepository
│   ├── Entity
│   └── res
│        └── activity_main.xml (xml 전용)
```


## Rule
네이밍 컨벤션 및 관련 룰은 멘토와 논의하에 자유롭게 진행하시면 됩니다.

## Coding
화면 아래의 레이어에 대해서도 스쿼드 인원들과 논의/담당해 업무분장을 진행해 주세요.

만약 우리의 스쿼드는 MVVM을 채택한다고 하면 View를 구현할 사람, ViewModel을 구현할 사람, Network를 구현할 사람을 나눠주시면 됩니다.

즉, 위의 룰을 제외하고는 자유롭게 코딩을 진행해 주세요.

