import { z } from "zod";

export const RecruitSchema = z.object({
  title: z
    .string()
    .min(1, "제목을 입력해 주세요.")
    .max(24, "공백 포함 24자 이하만 입력 가능합니다."),
  content: z
    .string()
    .min(1, "업무 내용을 입력해 주세요.")
    .max(2000, "2000자 이하만 입력 가능합니다."),
  workTime: z
    .string()
    .min(1, "업무 시간을 입력해 주세요.")
    .max(24, "공백 포함 24자 이하만 입력 가능합니다."),
  hourly: z
    .number()
    .min(1, "시급을 입력해 주세요.")
    .max(24, "공백 포함 24자 이하만 입력 가능합니다."),
  location: z
    .string()
    .min(1, "동네를 입력해 주세요.")
    .max(24, "공백 포함 24자 이하만 입력 가능합니다."),
});
