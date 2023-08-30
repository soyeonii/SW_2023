import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
function Create() {
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [manager, setManager] = useState(false);
  const navigate = useNavigate();

  const postData = () => {
    const member = {
      id: id,
      name: name,
      password: password,
      manager: manager,
    };

    fetch("http://localhost:8080/join", {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(member),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("create: ", data);
        navigate("/Read");
      });
  };

  return (
    <div>
      <table>
        <tbody>
          <tr>
            <td>ID:</td>
            <td>
              <input
                type="text"
                id="userId"
                onChange={(e) => setId(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>PW:</td>
            <td>
              <input
                type="password"
                id="pwd"
                onChange={(e) => setPassword(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>NAME:</td>
            <td>
              <input
                type="text"
                id="name"
                onChange={(e) => setName(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <input
                type="checkbox"
                id="isAdmin"
                onChange={(e) => setManager(e.target.checked)}
              />
              관리자입니다.
            </td>
          </tr>
          <tr>
            <td>
              <input
                type="submit"
                id="join"
                value="가입하기"
                onClick={postData}
              />
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default Create;
