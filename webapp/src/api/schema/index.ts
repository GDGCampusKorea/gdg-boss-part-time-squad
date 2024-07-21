import { z } from "zod";

export const recruitPost = z.object({
  title: z.string().min(1, "제목을 입력해주세요."),
  workTime: z
    .number()
    .min(0, "근무 시간은 0보다 커야 합니다.")
    .max(24, "근무 시간은 24보다 작아야 합니다."),
  hourlyWage: z
    .number()
    .min(0, "시급은 0보다 커야 합니다.")
    .max(40, "시급은 40보다 작아야 합니다"),
  location: z
    .string()
    .min(1, "위치를 입력해주세요.")
    .max(30, "위치를 입력해주세요."),
});
