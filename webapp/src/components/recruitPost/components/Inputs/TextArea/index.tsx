import { forwardRef, TextareaHTMLAttributes } from "react";
import * as S from "./styled";
import { UseFormWatch } from "react-hook-form";
import { RecruitPostType } from "../../../../../api/types";

interface TextAreaProps extends TextareaHTMLAttributes<HTMLTextAreaElement> {
  labelText: string;
  errorMessage?: string;
  watch: UseFormWatch<RecruitPostType>;
}

const TextArea = forwardRef<HTMLTextAreaElement, TextAreaProps>(
  ({ labelText, errorMessage, watch, ...restProps }, ref) => {
    const textLengthWatch = watch("content");

    return (
      <S.Container>
        <S.Label htmlFor={labelText}>{labelText}</S.Label>
        <S.TextArea id={labelText} {...restProps} ref={ref} />
        <S.FooterBox isError={Boolean(errorMessage)}>
          {errorMessage && (
            <S.ErrorMessage>{errorMessage.toString()}</S.ErrorMessage>
          )}
          <S.TextLengthCount>{`${textLengthWatch.length} /${restProps.maxLength}`}</S.TextLengthCount>
        </S.FooterBox>
      </S.Container>
    );
  }
);

export default TextArea;
