import "./MemoDetail.css";
import { useNavigate } from "react-router-dom";

function MemoDetail() {
  const nav = useNavigate();

  const MemoUpdate = function () {
    nav("/memo/update");
  };
  return (
    <>
      <br />
      <div className="buttonContainer">
        <button onClick={MemoUpdate}>수정하기</button>
        <button>삭제하기</button>
      </div>
      <div>memo detail</div>
    </>
  );
}

export default MemoDetail;
