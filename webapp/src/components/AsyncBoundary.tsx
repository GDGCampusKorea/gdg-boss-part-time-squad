import { ErrorBoundary, ErrorBoundaryProps } from "@sentry/react";
import {
  ComponentProps,
  forwardRef,
  Ref,
  Suspense,
  SuspenseProps,
  useImperativeHandle,
  useRef,
} from "react";

type Props = Omit<SuspenseProps, "fallback"> &
  Omit<ErrorBoundaryProps, "fallback"> & {
    rejectedFallback?: ComponentProps<typeof ErrorBoundary>["fallback"];
    pendingFallback?: ComponentProps<typeof Suspense>["fallback"];
  };

interface ResetRef {
  reset?(): void;
}

const AsyncBoundary = forwardRef(
  (
    {
      pendingFallback,
      rejectedFallback,
      children,
      ...errorBoundaryProps
    }: Props,
    resetRef: Ref<ResetRef>
  ) => {
    const ref = useRef<ErrorBoundary | null>(null);

    useImperativeHandle(resetRef, () => ({
      reset: () => ref.current?.resetErrorBoundary(),
    }));

    return (
      <ErrorBoundary
        ref={ref}
        {...errorBoundaryProps}
        fallback={rejectedFallback ?? <></>}
      >
        <Suspense fallback={pendingFallback ?? <></>}>{children}</Suspense>
      </ErrorBoundary>
    );
  }
);

export default AsyncBoundary;
