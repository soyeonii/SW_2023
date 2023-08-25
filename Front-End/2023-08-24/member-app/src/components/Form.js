import React, { useState } from "react";
import PropTypes from "prop-types";

function Form({ id, password, name, manager, btnName, onSubmit }) {
  const [userId, setUserId] = useState(id);
  const [userPw, setUserPw] = useState(password);
  const [userName, setUserName] = useState(name);
  const [userManager, setUserManager] = useState(manager);

  return (
    <>
      <table>
        <tbody>
          <tr>
            <td>ID:</td>
            <td>
              <input
                type="text"
                id="userId"
                value={userId}
                onChange={(e) => setUserId(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>PW:</td>
            <td>
              <input
                type="password"
                id="userPw"
                value={userPw}
                onChange={(e) => setUserPw(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>NAME:</td>
            <td>
              <input
                type="text"
                id="userName"
                value={userName}
                onChange={(e) => setUserName(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <input
                type="checkbox"
                id="userManager"
                checked={userManager}
                onChange={(e) => setUserManager(e.target.checked)}
              />
              관리자입니다.
            </td>
          </tr>
        </tbody>
      </table>
      <button
        onClick={() => onSubmit({ userId, userPw, userName, userManager })}
      >
        {btnName}
      </button>
    </>
  );
}

Form.propTypes = {
  id: PropTypes.string.isRequired,
  password: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  manager: PropTypes.bool.isRequired,
  btnName: PropTypes.string.isRequired,
  onSubmit: PropTypes.func.isRequired,
};

export default Form;
