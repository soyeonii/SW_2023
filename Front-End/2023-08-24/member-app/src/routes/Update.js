import React, { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import Form from "../components/Form";

function Update() {
  const location = useLocation();
  const navigate = useNavigate();

  const handleFormSubmit = ({ userId, userPw, userName, userManager }) => {
    fetch(`http://localhost:8080/${location.state.id}`, {
      method: "put",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        password: userPw,
        name: userName,
        manager: userManager,
      }),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        navigate("/users");
      })
      .catch((e) => console.log(e));
  };

  useEffect(() => {
    if (location.state === null) {
      navigate("/users");
    }
  }, []);

  if (location.state) {
    return (
      <Form
        id={location.state.id}
        password={location.state.password}
        name={location.state.name}
        manager={location.state.manager}
        btnName="수정하기"
        onSubmit={handleFormSubmit}
      />
    );
  } else {
    return null;
  }
}

export default Update;
