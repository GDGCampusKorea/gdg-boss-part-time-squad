import "@stackflow/plugin-basic-ui/index.css";
import "./styles/globalSeedDesign.ts";

import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.tsx";
import "./index.css";
import { server } from "./api/msw/index.ts";

async function initMsw() {
  async function enableMocking() {
    if (process.env.NODE_ENV !== "development") {
      return;
    }

    console.log("mocking enabled");

    return server.start();
  }

  enableMocking().then(() => {
    const rootNode = document.getElementById("root") as HTMLElement;
    ReactDOM.createRoot(rootNode).render(
      <React.StrictMode>
        <App />
      </React.StrictMode>
    );
  });
}

initMsw();
