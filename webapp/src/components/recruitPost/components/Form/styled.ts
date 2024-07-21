import { styled } from "@linaria/react";

export const Form = styled.form`
  padding: 0 1rem;
  margin-bottom: 5rem;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  width: calc(100vw - 2rem);
`;

export const Footer = styled.footer`
  position: fixed;
  bottom: 0;
  padding: 0.62rem 0;
  width: 100vw;
`;

export const SubmitButton = styled.button`
  outline: none;
  border: none;
  color: #fff;
  font-size: 1rem;
  font-weight: 700;
  line-height: 1.5rem;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
  padding: 0.75rem 1.5rem;
  border-radius: 0.75rem;
  background-color: #ea4335;
  width: calc(100vw - 2rem);

  &:disabled {
    background-color: #998e8d;
  }
`;
