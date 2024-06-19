import { useNavigate } from "react-router-dom";
import CowItem from "../components/CowItem";
import "./CowMain.css";

function CowMain() {
  const nav = useNavigate();

  const CowCreate = function () {
    nav("/cow/create");
  };

  const CowDetail = function () {
    nav("/cow/detail");
  };
  return (
    <>
      <hr />
      <div>cowmain</div>
      <div className="addCowButton">
        <button onClick={CowCreate}>소 추가</button>
      </div>
      <hr />
      <div className="searchContainer">
        <input id="searchCowInput" placeholder="소 검색" type="text" />
        <button id="searchCowButton">소 검색</button>
        <div className="cowItemContainer">
          <div onClick={CowDetail}>
            <CowItem />

            {/* 여기서 cowItem을 반복해야한다. */}
          </div>
          <CowItem />
          <CowItem />
          <CowItem />
          <CowItem />
          <CowItem />
          <CowItem />
        </div>
      </div>
    </>
  );
}

export default CowMain;
