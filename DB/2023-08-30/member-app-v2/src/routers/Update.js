import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
function Update() {
  const params = useParams();
  const navigate = useNavigate();
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [manager, setManager] = useState(false);

  useEffect(() => {
    fetch(`http://localhost:8080/${params.id}`)
      .then((response) => response.json())
      .then((data) => {
        setId(data.id);
        setPassword(data.password);
        setName(data.name);
        setManager(data.manager);
      });
  }, [params.id, navigate]);

  const updateData = () => {
    const member = {
      id: id,
      name: name,
      password: password,
      manager: manager,
    };

    fetch(`http://localhost:8080/${params.id}`, {
      method: "put",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(member),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("update: ", data);
        navigate("/Read");
      });
  };

  return (
    <div>
      <h1 id="center">Update</h1>
      <table>
        <tbody>
          <tr>
            <td>ID:</td>
            <td>
              <input
                type="text"
                id="userId"
                value={id}
                onChange={(e) => setId(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>PW:</td>
            <td>
              <input
                type="password"
                id="password"
                value={password}
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
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <input
                type="checkbox"
                id="manager"
                checked={manager ? "checked" : ""}
                onChange={(e) => setManager(e.target.checked)}
              />
              관리자입니다.
            </td>
          </tr>
          <tr>
            <td>
              <input
                type="submit"
                id="update"
                value="수정확인"
                onClick={updateData}
              />
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default Update;
