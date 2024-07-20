import { styled } from "@linaria/react";
import { vars } from "@seed-design/design-token";

export const Grid = styled.div`
  display: grid;
`;

export const Flex = styled.div`
  display: flex;
`;

export const FlexAlignCenter = styled(Flex)`
  align-items: center;
`;

export const FlexJustifyCenter = styled(Flex)`
  justify-content: center;
`;

export const FlexColumn = styled(Flex)`
  flex-direction: column;
`;

export const Flex1 = styled.div`
  flex: 1;
`;

export const PosAbs = styled.div`
  position: absolute;
`;

export const PosRel = styled.div`
  position: relative;
`;

export const Top0 = styled.div`
  top: 0;
`;

export const Left0 = styled.div`
  left: 0;
`;

export const FullWidth = styled.div`
  width: 100%;
`;

export const FullHeight = styled.div`
  height: 100%;
`;

export const PosAbsFull = styled(PosAbs)`
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
`;

export const Nowrap = styled.div`
  white-space: nowrap;
`;

export const ResetButton = styled.button`
  appearance: none;
  border: 0;
  padding: 0;
  background: none;
  color: ${vars.$scale.color.gray900};
  text-align: left;
`;

export const CursorPointer = styled.div`
  cursor: pointer;
  -webkit-tap-highlight-color: transparent;
`;

export const OverflowHidden = styled.div`
  overflow: hidden;
  transform: translate3d(0, 0, 0);
  -webkit-mask-image: radial-gradient(white, black);
`;

export const OverflowScroll = styled.div`
  overflow-y: scroll;
  -webkit-overflow-scrolling: touch;
  ::-webkit-scrollbar {
    display: none;
  }
`;

export const RootLineHeight = styled.div`
  line-height: 1.15;
`;
