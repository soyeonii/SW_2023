import React from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import About from "./routers/About";
import Home from "./routers/Home";
import Navigation from "./components/Navigation";
import Detail from "./routers/Detail";
function App() {
  return (
    <BrowserRouter>
      <Navigation />
      <Routes>
        <Route path="/about" element={<About />}></Route>
        <Route path="/:page" element={<Home />} />
        <Route path="/detail-movie" element={<Detail />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
