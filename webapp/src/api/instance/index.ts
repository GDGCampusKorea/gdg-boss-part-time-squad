import { QueryClient } from "@tanstack/react-query";
import axios, { AxiosInstance, AxiosRequestConfig } from "axios";

export const API_ENDPOINT = "https://api.gdg-campus.com/v1";

export const initFetchInstance = (
  config: AxiosRequestConfig
): AxiosInstance => {
  const instance = axios.create({
    timeout: 5000,
    ...config,
    headers: {
      Accept: "application/json",
      ...config.headers,
    },
  });
  instance.interceptors.request.use(
    function (config) {
      return config;
    },
    function (error) {
      return Promise.reject(error);
    }
  );

  return instance;
};

export const fetchInstance = () =>
  initFetchInstance({
    baseURL: API_ENDPOINT,
  });

export interface ErrorResponse {
  timestamp: string;
  status: number;
  error: string;
  path: string;
  code: number;
  type: string;
  message: string;
}

export const handleAxiosError = (error: unknown) => {
  if (axios.isAxiosError(error)) {
    return error.response ?? { data: null };
  }

  throw error;
};

export const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      retry: 3,
      refetchOnMount: true,
      refetchOnReconnect: true,
      refetchOnWindowFocus: true,
    },
  },
});

export const getAxiosInstanceParams = () => ({
  axios: fetchInstance(),
});
