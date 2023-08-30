import React from "react";
import { Link } from "react-router-dom";

function Navigation() {
  return (
    <>
      <table>
        <tbody>
          <tr>
            <td>
              <Link to="/users">전체조회</Link>
            </td>
            <td>
              <Link to="/join">회원가입</Link>
            </td>
          </tr>
        </tbody>
      </table>
    </>
  );
}

export default Navigation;
