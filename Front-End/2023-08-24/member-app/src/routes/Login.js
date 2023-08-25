import React from "react";
import { Link } from "react-router-dom";

function Login() {
  return (
    <>
      <table>
        <tbody>
          <tr>
            <td>ID:</td>
            <td>
              <input type="text" />
            </td>
          </tr>
          <tr>
            <td>PW:</td>
            <td>
              <input type="password" />
            </td>
          </tr>
        </tbody>
      </table>
      <button>로그인</button>
      &nbsp;
      <Link to="/join">
        <button>회원가입</button>
      </Link>
    </>
  );
}

export default Login;
