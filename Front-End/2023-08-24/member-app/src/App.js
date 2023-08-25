import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navigation from "./components/Navigation";
import Home from "./routes/Home";
import Login from "./routes/Login";
import Join from "./routes/Join";
import AdminPage from "./routes/AdminPage";
import Detail from "./routes/Detail";
import MemberPage from "./routes/MemberPage";
import Update from "./routes/Update";

function App() {
  return (
    <BrowserRouter>
      <Navigation />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/join" element={<Join />} />
        <Route path="/admin" element={<AdminPage />} />
        <Route path="/detail" element={<Detail />} />
        <Route path="/member" element={<MemberPage />} />
        <Route path="/update" element={<Update />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
