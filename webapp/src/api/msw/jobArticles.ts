import {
  HttpResponse as mswHttpResponse,
  http as mswHttp,
  HttpHandler,
} from "msw";
import {
  JOB_ARTICLES_URL,
  JobArticlesResponse,
} from "../hooks/useGetJobArticles";
import { API_ENDPOINT } from "../instance";

export const jobArticlesMockResponse = [
  {
    articleId: "02542470",
    price: 9000, // 한국 원화 시급
    title: "카페 바리스타",
    region: "서울",
    daysAgo: 2,
  },
  {
    articleId: "11257089",
    price: 8500,
    title: "편의점 야간 근무",
    region: "부산",
    daysAgo: 4,
  },
  {
    articleId: "08407137",
    price: 8800,
    title: "영화관 직원",
    region: "인천",
    daysAgo: 1,
  },
  {
    articleId: "32979422",
    price: 9300,
    title: "도서관 정리직",
    region: "대구",
    daysAgo: 3,
  },
  {
    articleId: "37998208",
    price: 9500,
    title: "레스토랑 서빙",
    region: "광주",
    daysAgo: 5,
  },
  {
    articleId: "01695878",
    price: 10000,
    title: "식품 매장 정리",
    region: "대전",
    daysAgo: 1,
  },
  {
    articleId: "09792471",
    price: 8900,
    title: "피트니스 트레이너 보조",
    region: "울산",
    daysAgo: 2,
  },
  {
    articleId: "23939055",
    price: 9200,
    title: "백화점 정보 데스크",
    region: "수원",
    daysAgo: 6,
  },
  {
    articleId: "94689745",
    price: 8600,
    title: "물류 센터 포장",
    region: "성남",
    daysAgo: 4,
  },
  {
    articleId: "49322156",
    price: 9700,
    title: "호텔 프런트 직원",
    region: "제주",
    daysAgo: 3,
  },
];

const jobArticlesGet = (statusCode: number, response: JobArticlesResponse) =>
  mswHttp.get(`${API_ENDPOINT}/${JOB_ARTICLES_URL}`, () => {
    // ...and respond to them using this JSON response.
    return mswHttpResponse.json(response, { status: statusCode });
  });

export const jobArticlesHandlers: HttpHandler[] = [
  jobArticlesGet(200, jobArticlesMockResponse),
];
