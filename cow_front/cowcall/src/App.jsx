import { Routes, Route } from "react-router-dom";
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
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<CowMain />} />
        <Route path="/memo" element={<MemoMain />} />
        <Route path="/cow/create" element={<CowCreate />} />
        <Route path="/memo/create" element={<MemoCreate />} />
        <Route path="/cow/detail" element={<CowDetail />} />
        <Route path="/memo/detail" element={<MemoDetail />} />
        <Route path="/cow/update" element={<CowUpdate />} />
        <Route path="/memo/update" element={<MemoUpdate />} />
      </Routes>
    </div>
  );
}

export default App;
