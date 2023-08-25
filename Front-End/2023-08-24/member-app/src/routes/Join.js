import React from "react";
import { useNavigate } from "react-router-dom";
import Form from "../components/Form";

function Join() {
  const navigate = useNavigate();

  const handleFormSubmit = ({ userId, userPw, userName, userManager }) => {
    fetch("http://localhost:8080/join", {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        id: userId,
        password: userPw,
        name: userName,
        manager: userManager,
      }),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        navigate("/login");
      })
      .catch((e) => console.log(e));
  };

  return (
    <Form
      key={""}
      id={""}
      password={""}
      name={""}
      manager={false}
      btnName="회원가입"
      onSubmit={handleFormSubmit}
    />
  );
}

export default Join;
