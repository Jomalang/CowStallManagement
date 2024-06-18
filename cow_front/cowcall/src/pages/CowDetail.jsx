import { useNavigate } from "react-router-dom";
import "./CowDetail.css";

function CowDetail() {
  const nav = useNavigate();

  const CowUpdate = function () {
    nav("/cow/update");
  };
  return (
    <>
      <br />
      <div className="buttonContainer">
        <button onClick={CowUpdate}>수정하기</button>
        <button>삭제하기</button>
      </div>
      <div>cow detail</div>
    </>
  );
}

export default CowDetail;
