import { AppScreen } from "@stackflow/plugin-basic-ui";
import RecruitPostForm from "../components/Form";

function RecruitPostPage() {
  return (
    <AppScreen
      appBar={{
        title: "알바 작성",
      }}
    >
      <RecruitPostForm />
    </AppScreen>
  );
}

export default RecruitPostPage;
