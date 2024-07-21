import { jobArticlesHandlers } from "./jobArticles";
import { setupWorker } from "msw/browser";

export const server = setupWorker(...jobArticlesHandlers);

// 명세만 가지고도, API 를 연결할 수 있다.
// API 연결을 할 못할 상황을 위해
// 기획 - 디자인 - 논의 - 백엔드 API - 프론트엔드... ㅠㅠㅠㅠㅠㅠ
// 사전에 명세

// 백엔드 속도에 따라 ex) 대규모

// stackflow
// 화면 전환간 내비게이션/ 디자인요소 빠른 웹앱을 위해서 채택
// react-router-dom과 동일, 화면 추가만 다름.

// linaria
// styled-component -> 요즘에 사라지는 추세
// zero-runtime vanila-extract(styled-component 코드구조), pandas
// SSR : 빌드 크기가 커짐 / 속도가 느려짐
