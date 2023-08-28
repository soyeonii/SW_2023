import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navigation from "./components/Navigation";
import Home from "./routes/Home";
import Join from "./routes/Join";
import Read from "./routes/Read";
import Detail from "./routes/Detail";
import Update from "./routes/Update";

function App() {
  return (
    <BrowserRouter>
      <Navigation />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/users" element={<Read />} />
        <Route path="/join" element={<Join />} />
        <Route path="/detail" element={<Detail />} />
        <Route path="/update" element={<Update />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
