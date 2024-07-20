import "@seed-design/stylesheet/global.css";

(function () {
  function isIOS() {
    return /iphone|ipad|ipod/i.test(window.navigator.userAgent.toLowerCase());
  }
  var ios = isIOS();
  var prefersLight = window.matchMedia("(prefers-color-scheme: light)");
  var prefersDark = window.matchMedia("(prefers-color-scheme: dark)");
  var el = document.documentElement;

  el.dataset.seedScaleLetterSpacing = ios ? "ios" : "android";
  el.dataset.seed = "";

  if (prefersLight.matches) {
    if ("addEventListener" in prefersLight) {
      prefersLight.addEventListener("change", apply);
    } else if ("addListener" in prefersLight) {
      // @ts-ignore
      prefersLight.addListener(apply);
    }
  } else if (prefersDark.matches) {
    if ("addEventListener" in prefersDark) {
      prefersDark.addEventListener("change", apply);
    } else if ("addListener" in prefersDark) {
      // @ts-ignore
      prefersDark.addListener(apply);
    }
  }

  function apply() {
    document.documentElement.dataset.seedScaleColor = prefersDark.matches
      ? "dark"
      : "light";
  }

  apply();
})();
