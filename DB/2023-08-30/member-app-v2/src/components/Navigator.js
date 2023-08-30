import React from "react";
import { Link } from "react-router-dom";
import "./Style.css";

function Navigator() {
  return (
    <div id="center">
      <h2>
        <Link to="/Read">
          <button>전체조회</button>
        </Link>
        <Link to="/Create">
          <button>회원가입</button>
        </Link>
      </h2>
    </div>
  );
}

export default Navigator;
