import React, { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import Form from "../components/Form";

function Detail() {
  const location = useLocation();
  const navigate = useNavigate();

  const handleFormSubmit = ({ userId, userPw, userName, userManager }) => {
    navigate("/admin");
  };

  useEffect(() => {
    if (location.state === null) {
      navigate("/admin");
    }
  }, []);

  if (location.state) {
    return (
      <Form
        key={location.state.id}
        id={location.state.id}
        password={location.state.password}
        name={location.state.name}
        manager={location.state.manager}
        btnName="돌아가기"
        onSubmit={handleFormSubmit}
      />
    );
  } else {
    return null;
  }
}

export default Detail;
