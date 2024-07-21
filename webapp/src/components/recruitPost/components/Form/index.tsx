import TextArea from "../Inputs/TextArea";
import { useForm } from "react-hook-form";
import { RecruitPostType } from "../../../../api/types";
import { RecruitSchema } from "../../../../api/schema";
import { zodResolver } from "@hookform/resolvers/zod";
import * as S from "./styled";

function RecruitPostForm() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors, isValid },
  } = useForm<RecruitPostType>({
    mode: "all",
    defaultValues: {
      title: "",
      content: "",
      workTime: "",
      hourlyWage: 0,
      location: "",
    },
    resolver: zodResolver(RecruitSchema),
  });

  const onSubmit = (data: RecruitPostType) => {
    console.log(data);
  };

  return (
    <S.Form onSubmit={handleSubmit(onSubmit)}>
      <TextArea
        labelText="내용"
        maxLength={2000}
        {...register("content")}
        errorMessage={errors?.content?.message}
        watch={watch}
      />
      <S.Footer>
        <S.SubmitButton disabled={!isValid} type="submit">
          작성 완료
        </S.SubmitButton>
      </S.Footer>
    </S.Form>
  );
}

export default RecruitPostForm;
