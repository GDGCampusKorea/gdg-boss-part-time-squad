import { FC } from "react";
import { useForm, SubmitHandler } from "react-hook-form";
import { styled } from "@linaria/react";
import { vars } from "@seed-design/design-token";
import { Flex } from "../../styles/f";

interface Props {
  IsRequired: boolean;
  label: string;
  placeholder: string;
  icon?: string | undefined;
  content: string;
  error?: string;
}

export const TextInput: FC<Props> = ({
  IsRequired,
  label,
  placeholder,
  content,
  icon,
  error,
}) => {
  const {
    register,
    formState: { errors },
  } = useForm<{ content: string }>();

  return (
    <Container>
      <Title>{label}</Title>
      <InputGrid>
        <StyledInput
          placeholder={placeholder}
          defaultValue={content}
          {...register("content", { required: IsRequired })}
        />
        {icon && <StyledImg src={icon} alt="img" />}
      </InputGrid>
    </Container>
  );
};

export const Container = styled(Flex)`
  padding: 0.75rem 0rem;
  flex-direction: column;
  align-items: flex-start;
  gap: 0.75rem;
  align-self: stretch;
`;

export const Title = styled.h1`
  font-size: 1.375rem;
  line-height: 1.375rem;
  font-style: normal;
  font-weight: 700;
  align-self: stretch;
`;

export const InputGrid = styled(Flex)`
  align-items: center;
  gap: 0.625rem;
  align-self: stretch;
  justify-content: space-between;
  padding-right: 1rem;
  border-radius: 0.75rem;
  border: 1px solid #d1d1d1;
`;

const StyledInput = styled.input`
  padding: 10px;
  width: 100%;
  background-color: transparent;
  border: transparent;
  outline: none;
  &:focus {
    border: transparent;
    outline: none;
  }
  &:active,
  &:hover {
    border: transparent;
    outline: none;
  }
`;

const StyledImg = styled.img`
  width: 24px;
  height: 24px;
`;
