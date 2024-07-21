import { useQuery } from "@tanstack/react-query";
import { fetchInstance } from "../instance";
import { AxiosResponse } from "axios";
import { JobsArticleDetailResponse } from "../types";

// API URL
export const JOB_ARTICLE_DETAIL_URL =
  "http://localhost:8081/api/recruit-posts/";

// 데이터를 가져오는 함수 정의
export const getJobArticleDetail = async () => {
  const { data } = await fetchInstance().get<
    undefined,
    AxiosResponse<JobsArticleDetailResponse>
  >(JOB_ARTICLE_DETAIL_URL);

  return data;
};

// 데이터를 가져오는 커스텀 훅 정의
export const useGetJobArticleDetail = () => {
  const { data, error, isLoading, isFetching } = useQuery({
    queryKey: ["jobArticleDetail"],
    queryFn: getJobArticleDetail,
  });

  return { data, error, isLoading, isFetching };
};
