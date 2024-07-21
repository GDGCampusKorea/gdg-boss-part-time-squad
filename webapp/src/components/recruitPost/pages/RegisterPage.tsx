import { AppScreen } from "@stackflow/plugin-basic-ui";
import AsyncBoundary from "../../AsyncBoundary";
import { TextInput } from "../TextInput";
import time from "../../../assets/time.svg";
import location from "../../../assets/location.svg";

import { zodResolver } from "@hookform/resolvers/zod";
import { useForm, SubmitHandler } from "react-hook-form";
import { z } from "zod";
import { recruitPost } from "../../../api/schema/index";

type RecruitPostType = z.infer<typeof recruitPost>;

type Props = {};

export const RegisterPage = (props: Props) => {
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
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<RecruitPostType>({
    resolver: zodResolver(recruitPost),
  });

  const onSubmit: SubmitHandler<RecruitPostType> = (data) => {
    console.log(data);
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)} style={{ padding: "1rem" }}>
      <TextInput
        IsRequired
        label="제목"
        placeholder="GDG 회사 알바생 모집"
        content=""
      />
      <TextInput
        IsRequired
        label="시간"
        placeholder="주 7일, 1 개월"
        content=""
        icon={time}
      />
      <TextInput IsRequired label="시급" placeholder="200,000" content="" />
      <TextInput
        IsRequired
        label="위치"
        placeholder="삼성동"
        content=""
        icon={location}
      />
      <button type="submit">Submit</button>
    </form>
  );
};
