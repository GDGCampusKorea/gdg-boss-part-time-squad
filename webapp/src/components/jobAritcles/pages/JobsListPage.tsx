import { AppScreen, cssVars } from "@stackflow/plugin-basic-ui";
import AsyncBoundary from "../../AsyncBoundary"; // 현대 웹에서 Suspense 컴포넌트의 로딩
// 컴포넌트마다 상태를 격리
// 에러가 발생하면, 그 컴포넌트만 에러가 발생하고 나머지 컴포넌트는 정상적으로 작동
// 에러가 상위앱에서 전파되지 않도록
// 센트리? 에러가 전파된 곳을 에러로그로

import { styled } from "@linaria/react";
import FeedCard from "../components/FeedCard";
import {
  PosAbsFull,
  FlexColumn,
  RootLineHeight,
  Flex,
  FlexAlignCenter,
  Flex1,
  OverflowScroll,
} from "../../../styles/f";
import { useJobArticles } from "../../../api/hooks/useGetJobArticles";

export const JobsListPage = () => {
  return (
    <AsyncBoundary>
      <AppScreen
        appBar={{
          title: "Jobs",
        }}
      >
        <JobsList />
      </AppScreen>
    </AsyncBoundary>
  );
};

export const JobsList = () => {
  const { data } = useJobArticles();

  if (!data) return <>empty</>;

  return (
    <Wrapper>
      <Scrollable>
        {data.map((card) => (
          <FeedCard
            key={card.articleId}
            articleId={card.articleId}
            title={card.title}
            price={card.price}
            region={card.region}
            daysAgo={card.daysAgo}
          />
        ))}
      </Scrollable>
    </Wrapper>
  );
};

// styled 상속, 
// zero-runtime styled-component loading 시간이 걸림
// 최근에는 빠르게 띄우는게 추세 ex)서버 컴포넌트 / 서스펜스 / SSR
// css 파일을 불러오고 전통적인 방법 / 번들크기를 늘리지 않음
// 면접 단 골 질 문
// 프론트엔드는 CSS 
// 

export const Wrapper = styled(PosAbsFull)`
  ${FlexColumn}
  ${RootLineHeight}
`;

export const AppBarLeft = styled(Flex)`
  font-size: 1.125rem;
  font-weight: 700;
  margin-left: 0.5rem;
`;

export const AppBarLeftIcon = styled(FlexAlignCenter)`
  margin-left: 0.5rem;
`;

export const AppBarRight = styled.div`
  display: grid;
  grid-template-columns: 1.5rem 1.5rem 1.5rem;
  gap: 1rem;
  margin-right: 0.5rem;
`;

export const Scrollable = styled(Flex1)`
  ${OverflowScroll}
  padding-top: ${cssVars.appBar.height};
  @supports (padding-top: constant(safe-area-inset-top)) {
    padding-top: calc(${cssVars.appBar.height} + constant(safe-area-inset-top));
  }
  @supports (padding-top: env(safe-area-inset-top)) {
    padding-top: calc(${cssVars.appBar.height} + env(safe-area-inset-top));
  }
`;
