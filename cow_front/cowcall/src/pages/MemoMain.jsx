import "./MemoMain.css";
import { useNavigate } from "react-router-dom";
import MemoItem from "../components/MemoItem";

function MemoMain() {
  const nav = useNavigate();

  const MemoCreate = function () {
    nav("/memo/create");
  };

  const MemoDetail = function () {
    nav("/memo/detail");
  };

  return (
    <>
      <hr />
      <div>MemoMain</div>
      <div className="addMemoButton">
        <button onClick={MemoCreate}>메모 추가</button>
      </div>
      <hr />
      <div className="searchContainer">
        <input id="searchMemoInput" placeholder="메모 검색" type="text" />
        <button>메모 검색</button>
        <div className="memoItemContainer">
          <div onClick={MemoDetail}>
            <MemoItem />
          </div>
          <MemoItem />
          <MemoItem />
          <MemoItem />
          <MemoItem />
          <MemoItem />
          <MemoItem />
        </div>
      </div>
    </>
  );
}

export default MemoMain;
