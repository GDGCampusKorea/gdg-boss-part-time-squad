import { AppScreen } from "@stackflow/plugin-basic-ui";
import AsyncBoundary from "../../AsyncBoundary";

type Props = {};

export const JobsArticleDetailPage = (props: Props) => {
  return (
    <AppScreen
      appBar={{
        title: "게시글 상세",
      }}
    >
      <AsyncBoundary>
        <JobsList />
      </AsyncBoundary>
    </AppScreen>
  );
};

const JobsList = () => {
  return <div>asd</div>;
};
