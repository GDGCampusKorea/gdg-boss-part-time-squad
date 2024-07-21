import { AppScreen } from "@stackflow/plugin-basic-ui";
import AsyncBoundary from "../../AsyncBoundary";
import { styled } from "@linaria/react";
import { useJobArticles } from "../../../api/hooks/useGetJobArticles";
//icons
import { FaRegClock } from "react-icons/fa6";
import { CgSmileMouthOpen } from "react-icons/cg";
import { IoLocationSharp } from "react-icons/io5";
import { DetailFooter } from "../components/DetailFooter";
type Props = {};

export const JobsArticleDetailPage = (props: Props) => {
  return (
    <AppScreen
      appBar={{
        title: "상세",
      }}
    >
      <AsyncBoundary>
        <JobsList />
      </AsyncBoundary>
    </AppScreen>
  );
};

const JobsList = () => {
  const dummy=[{"title":"GDG회사 알바생 모집","workTime":"주 7일 , 1개월 이상","hourlyWage":200000,"location":"삼성동","content":"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer metus nunc, malesuada sit amet luctus ut, pretium vel arcu. Aliquam nec tortor id libero tempus dapibus. Suspendisse gravida ligula in."}];

  const job = dummy[0];

  return (
    <form>
      <TotalWrapper>
        <Inner>
          <ImageWrapper>
            <img src="/src/assets/Media.png" alt="Job Media"/>
          </ImageWrapper>
          <span className="titleText">{job.title}</span>
          <InfoBox>
            <p>
              <span className="icon"><FaRegClock/></span> {job.workTime}
            </p>
            <p>
              <span className="icon"><CgSmileMouthOpen/></span> {job.hourlyWage}
            </p>
            <p>
            <span className="icon"><IoLocationSharp/></span> {job.location}
            </p>
          </InfoBox>

          <InfoTitle><span>모집 내용</span></InfoTitle>
          <InfoArticle>
            <p>{job.content}</p>
          </InfoArticle>
          </Inner>
          <DetailFooter/>
      </TotalWrapper>
    </form>
  );
};

export const TotalWrapper=styled.div`
  width:360px;
  .titleText{
    font-size:28px;
    font-weight:22px;
  }
  .infoTitle{
    height:64px;
    font-size:28px;
    font-weight:22px;
  }
`
export const Inner=styled.div`
  width:328px;
  position: relative;
  left:16px;
`
export const ImageWrapper=styled.div`
  position:relative;
  width:100%;
  margin:16px auto 16px;
`

export const InfoBox = styled.div`
  position: relative;
  border: solid 1px gray;
  margin-top: 16px;
  border-radius: 12px;
  height: 108px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  padding: 8px;
  width:100%;
  p {
    font-size: 16px;
    line-height: 20px;
    margin: 8px 0;
    
    .icon {
      font-size: 16px;
    }
  }
`;
export const InfoTitle = styled.div`
  position: relative;
  margin-top:16px;
  height:64px;
  width:100%;
  span{
    position: relative;
    height:24px;
    font-size:28px;
    font-weight:22px;
  }
`
export const InfoArticle = styled.div`
  
`
