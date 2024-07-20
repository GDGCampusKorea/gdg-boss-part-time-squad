# GDG Market 프로젝트

이 프로젝트는 GDG Market 애플리케이션을 구축하기 위한 Spring Boot 기반의 Java 애플리케이션입니다.

## 사전 요구 사항

- **JDK**: Java Development Kit 17 이상
- **Gradle**: 8.0 이상
- **IDE**: IntelliJ IDEA (Community 포함) 또는 다른 Java IDE

## 설치 및 환경 설정

1. **프로젝트 클론**

   ```bash
   git clone https://github.com/BartKim-J/gdg-boss-server-core.git
   cd gdg-boss-server-core
   ```


### 설명
1. **Makefile**:
    - `all` 타겟은 기본적으로 `build`와 `run` 작업을 순서대로 실행합니다.
    - `wrapper` 타겟은 `gradle wrapper` 명령어를 실행하여 Gradle Wrapper 를 생성합니다.
    - `build` 타겟은 `./gradlew clean build` 명령어를 실행하여 프로젝트를 빌드합니다.
    - `run` 타겟은 `./gradlew bootRun` 명령어를 실행하여 애플리케이션을 실행합니다.
    - `clean` 타겟은 `./gradlew clean` 명령어를 실행하여 빌드 아티팩트를 제거합니다.
    - `test` 타겟은 `./gradlew test` 명령어를 실행하여 테스트를 실행합니다.
