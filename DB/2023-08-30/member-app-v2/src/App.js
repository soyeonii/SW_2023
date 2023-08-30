import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Read from "./routers/Read";
import Detail from "./routers/Detail";
import Update from "./routers/Update";
import Delete from "./routers/Delete";
import Create from "./routers/Create";
import Navigator from "./components/Navigator";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Navigator />
        <Routes>
          <Route path="/Read" element={<Read />} />
          <Route path="/Detail/:id" element={<Detail />} />
          <Route path="/Update/:id" element={<Update />} />
          <Route path="/Delete/:id" element={<Delete />} />
          <Route path="/Create" element={<Create />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
