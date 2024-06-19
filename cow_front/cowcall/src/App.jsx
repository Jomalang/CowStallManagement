import { Routes, Route } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";
import CowMain from "./pages/CowMain";
import MemoMain from "./pages/MemoMain";
import CowCreate from "./pages/CowCreate";
import MemoCreate from "./pages/MemoCreate";
import MemoUpdate from "./pages/MemoUpdate";
import CowUpdate from "./pages/CowUpdate";
import CowDetail from "./pages/CowDetail";
import MemoDetail from "./pages/MemoDetail";
import Header from "./components/Header";

import "./App.css";

function App() {
  // mount로 cows 데이터 가져오기
  const [cows, setCows] = useState([]);

  useEffect(() => {
    axios
      .get("localhost:8080/test")
      .then((res) => {
        setCows(res.data);
      })
      .catch((err) => {
        console.log("err !!", err);
      });
  }, []);

  console.log(cows);

  // mount로 memos 데이터 가져오기
  const [memos, setMemos] = useState([]);

  useEffect(() => {
    axios
      .get("")
      .then((res) => {
        setMemos(res.data);
      })
      .catch((err) => {
        console.log("err !!", err);
      });
  }, []);

  console.log(memos);

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<CowMain />} />
        <Route path="/cow/create" element={<CowCreate />} />
        <Route path="/cow/detail" element={<CowDetail />} />
        <Route path="/cow/update" element={<CowUpdate />} />
        <Route path="/memo" element={<MemoMain />} />
        <Route path="/memo/create" element={<MemoCreate />} />
        <Route path="/memo/detail" element={<MemoDetail />} />
        <Route path="/memo/update" element={<MemoUpdate />} />
      </Routes>
    </div>
  );
}

export default App;
