import React from "react";
import { Link } from "react-router-dom";

function Navigation() {
  return (
    <>
      <table>
        <tbody>
          <tr>
            <td>
              <Link to="/admin">Admin</Link>
            </td>
            <td>
              <Link to="/member">Member</Link>
            </td>
          </tr>
        </tbody>
      </table>
    </>
  );
}

export default Navigation;
