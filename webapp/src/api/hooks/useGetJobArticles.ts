import { useQuery } from "@tanstack/react-query";
import { fetchInstance } from "../instance";
import { AxiosResponse } from "axios";
import { jobArticlesMockResponse } from "../msw/jobArticles";

export const JOB_ARTICLES_URL = "group-job-articles";

export type JobArticlesResponse = typeof jobArticlesMockResponse;


// 이런식으로 많이 사용, 이 훅을 위주로
export const getJobArticles = async () => {
  const { data } = await fetchInstance().get<
    undefined,
    AxiosResponse<JobArticlesResponse>
  >(JOB_ARTICLES_URL);

  return data;
};

export const useJobArticles = () => {
  const { isPending, error, data, isFetching } = useQuery({
    queryKey: ["jobArticles"],
    queryFn: () => getJobArticles(),
  });

  return { data, isPending, error, isFetching };
};
