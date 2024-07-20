import { jobArticlesHandlers } from "./jobArticles";
import { setupWorker } from "msw/browser";

export const server = setupWorker(...jobArticlesHandlers);
