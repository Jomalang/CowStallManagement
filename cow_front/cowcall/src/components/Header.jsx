import { useNavigate } from "react-router-dom";
import "./Header.css";

function Header() {
  const nav = useNavigate();

  const HomeButton = function () {
    nav("/");
  };

  const MemoButton = function () {
    nav("/memo");
  };

  return (
    <>
      <div className="HeaderContainer">
        <button onClick={HomeButton}>HOME</button>
        <button onClick={MemoButton}>MEMO</button>
      </div>
    </>
  );
}

export default Header;
