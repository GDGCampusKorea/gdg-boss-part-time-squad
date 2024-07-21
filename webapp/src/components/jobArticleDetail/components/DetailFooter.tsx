import React from "react";
import { styled } from "@linaria/react";

export const DetailFooter = () => {
  return (
    <FooterContainer>
      <ApplyButton>지원하기</ApplyButton>
    </FooterContainer>
  );
};

// 스타일 정의
const FooterContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 16px;
  background-color: #f8f8f8; // 배경 색상은 필요에 따라 조정
  position: fixed;
  bottom: 0;
  width: 100%;
  box-shadow: 0 -1px 5px rgba(0, 0, 0, 0.1);
`;

const ApplyButton = styled.button`
  background-color: #ff6b6b;
  color: white;
  border: none;
  padding: 12px 24px;
  font-size: 16px;
  font-weight: bold;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;

  &:hover {
    background-color: #ff5252;
  }
`;
