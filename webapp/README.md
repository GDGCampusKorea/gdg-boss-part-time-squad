## 사전 준비 사항

- https://vitejs.dev/guide/ 에 접속해주세요.

- 아래의 명령어를 차례로 입력할 수 있고 오류가 발생하지 않도록 환경을 만들어주세요. 명령어 입력 후 웹에서 react 실행화면을 볼 수 있어야해요.
  yarn이 설치되어야 해요. 윈도우 같은경우 리눅스 기반의 명령어가 입력 가능하도록 wsl을 설치해주세요.

```
yarn create vite
yarn create vite my-vue-app --template vue
```

- 필수 설치
  - vscode
  - git
  - yarn

## Folder

```
project-root
│
├── src
│ ├── api
│ │ ├── hooks
│ │ ├── instance
│ │ └── msw
│ │
│ ├── assets
│ │
│ ├── components
│ │ ├── domain // 목적 단위로 폴더를 분리해주세요. 예를들어 알바에서 게시글, 알바 목록 이런형태로 분리할 수 있습니다.
│ │ │ ├── pages
│ │ │ └── components
│ │ │
│ │ └── ... (기타 컴포넌트 폴더)
│ │
│ ├── lib
│ │ ├── stackflow 라이브러리 관련 세팅이 담겨있습니다.
│ └── styles
│
├── public
│
├── node_modules
│
├── package.json
│
└── ...
```

## skill

- Vite + React 기반의 웹앱입니다.
- [Stackflow](https://stackflow.so/)가 적용되어 있습니다.
  - Stackflow는 웹앱 기반에서 화면전환 애니메이션 및 스타일 킷을 제공합니다.
  - 처음 접할 때 헷갈림은 있을 수 있겠으나 짧은 시간안에 완성도 높은 웹앱을 구현할 수 있기에 채택했습니다.
  - 멘토분들께서는 Activity 화면 등록부분만 가이드 잘 주시면 좋을 것 같습니다.
- [tanstack/react-query](https://tanstack.com/query/latest)로 api가 연동되어있습니다.
  - api 폴더 내부 구현을 참고하시되, 내부적인 깊은 구현에 대한 탐구 보다는 hook을 작성하게 유도해주세요.
- 백엔드와 api 연동이 원활하지 않을 수 있습니다. 만약 그런경우에 [msw](https://mswjs.io/)를 활용해주세요.
  - yarn dev:MOCK 명령어를 사용하시면, mock 모드로 진입할 수 있습니다.
  - api/msw에서 도메인에 맞는 mock 함수를 구현하시면 백엔드 없이 api를 확인할 수 있습니다.
- [linaria](https://github.com/callstack/linaria)로 스타일링을 합니다. 평소 익숙하신 방법으로 스타일링 해주세요.
