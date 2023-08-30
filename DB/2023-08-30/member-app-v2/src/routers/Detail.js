import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function Detail() {
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

  const back = () => {
    navigate("/Read");
  };

  return (
    <div>
      <table>
        <tbody>
          <tr>
            <td>ID:</td>
            <td>
              <input type="text" id="userId" defaultValue={id} />
            </td>
          </tr>
          <tr>
            <td>PW:</td>
            <td>
              <input type="password" id="password" defaultValue={password} />
            </td>
          </tr>
          <tr>
            <td>NAME:</td>
            <td>
              <input type="text" id="name" defaultValue={name} />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <input
                type="checkbox"
                id="manager"
                checked={manager ? "checked" : ""}
                readOnly
              />
              관리자입니다.
            </td>
          </tr>
          <tr>
            <td>
              <input
                type="submit"
                id="update"
                defaultValue="돌아가기"
                onClick={back}
              />
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default Detail;
