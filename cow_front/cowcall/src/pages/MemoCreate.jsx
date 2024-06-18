import "./MemoCreate.css";

function MemoCreate() {
  return (
    <>
      <div className="memoCreate">
        <div>create memo</div>
        <div className="craeteButton">
          <button>메모 생성</button>
        </div>
        <form action="">
          <input type="text" />
          <input type="text" />
          <input type="text" />
          <input type="text" />
        </form>
      </div>
    </>
  );
}

export default MemoCreate;
