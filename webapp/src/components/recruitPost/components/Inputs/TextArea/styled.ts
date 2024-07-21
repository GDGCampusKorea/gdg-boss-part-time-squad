import { styled } from "@linaria/react";

export const Container = styled.div`
  color: #939090;
  padding: 0.75rem;
  font-weight: 500;
  display: flex;
  flex-direction: column;
  border: 1px solid #939090;
  border-radius: 0.75rem;
`;

export const Label = styled.label`
  font-weight: 700;
  color: #3b383e;
  font-size: 1.375rem;
  line-height: 1.75rem;
  display: flex;
  align-items: center;
  margin-bottom: 0.75rem;
`;

export const TextArea = styled.textarea`
  color: #3b383e;
  font-size: 1rem;
  line-height: 1.5rem;
  background-color: #fff;
  outline: none;
  resize: none;
  border: none;
  border: 1px solid rgba(147, 144, 144, 0.35);
  border-radius: 0.5rem;
  height: 7.5rem;
  padding: 0.25rem;
`;

export const FooterBox = styled.div<{ isError: boolean }>`
  display: flex;
  align-items: center;
  justify-content: ${({ isError }) => (isError ? "space-between" : "right")};
  gap: 1rem;
  margin-top: 0.5rem;
`;

export const ErrorMessage = styled.p`
  color: red;
  font-size: 0.875rem;
  line-height: 1.25rem;
`;

export const TextLengthCount = styled.p`
  color: #939090;
  font-size: 0.875rem;
  line-height: 1.25rem;
  float: right;
`;
