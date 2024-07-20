import React from "react";
import { LazyLoadImage } from "react-lazy-load-image-component";
import { useFlow } from "../../../lib/stackflow"; // Import useFlow from stackflow
import { styled } from "@linaria/react";
import { vars } from "@seed-design/design-token";
import {
  Flex,
  ResetButton,
  CursorPointer,
  OverflowHidden,
  Flex1,
} from "../../../styles/f";

interface FeedCardProps {
  articleId: string;
  title: string;
  region: string;
  price: number;
  daysAgo: number;
}

export const FeedCard: React.FC<FeedCardProps> = ({
  articleId,
  title,
  price,
  region,
  daysAgo,
}) => {
  const { push } = useFlow();

  const imageUrl = `https://picsum.photos/800/800/?id=${articleId}`;

  const onClick = () => {
    push("JobsArticleDetailPage", {
      articleId: String(articleId),
      title,
    });
  };

  return (
    <Container>
      <Button onClick={onClick}>
        <Left>
          <Title>{title}</Title>
          <Subtitle>
            {region} · {daysAgo} days ago
          </Subtitle>
          <Price>{price.toLocaleString()}원</Price>
        </Left>
        <Thumbnail>
          <LazyLoadImage
            src={imageUrl}
            effect="opacity"
            width={108}
            height={108}
          />
        </Thumbnail>
      </Button>
    </Container>
  );
};

export default FeedCard;

export const Container = styled(Flex)`
  padding: 1rem 1rem 0;
`;

export const Button = styled(ResetButton)`
  display: flex;
  ${CursorPointer}
  box-shadow: 0 1px 0 0 ${vars.$semantic.color.divider1};
  padding-bottom: 1rem;
  width: 100%;
`;

export const Thumbnail = styled(OverflowHidden)`
  width: 6.75rem;
  height: 6.75rem;
  background-color: ${vars.$scale.color.gray100};
  border-radius: 0.375rem;
  margin-right: 1rem;
  background-size: cover;
  background-position: 50% 50%;
`;

export const Left = styled(Flex1)``;

export const Title = styled.h1`
  font-size: 1rem;
  line-height: 1.375rem;
`;

export const Subtitle = styled.h2`
  font-size: 0.8125rem;
  line-height: 1.25rem;
  color: ${vars.$scale.color.gray600};
`;

export const Price = styled.span`
  font-size: 0.875rem;
  font-weight: bold;
  line-height: 1.25rem;
`;
