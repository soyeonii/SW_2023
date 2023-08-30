import React from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

function Member({ id, password, name, manager }) {
  const remove = () => {
    fetch(`http://localhost:8080/${id}`, {
      method: "delete",
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        window.location.replace("/users");
      });
  };

  return (
    <tr>
      <td>{id}</td>
      <td>{name}</td>
      <td>{manager ? "true" : "false"}</td>
      <td>
        <Link to="/detail" state={{ id, password, name, manager }}>
          <button>조회</button>
        </Link>
      </td>
      <td>
        <Link to="/update" state={{ id, password, name, manager }}>
          <button>수정</button>
        </Link>
      </td>
      <td>
        <button onClick={remove}>삭제</button>
      </td>
    </tr>
  );
}

Member.propTypes = {
  id: PropTypes.string.isRequired,
  password: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  manager: PropTypes.bool.isRequired,
};

export default Member;
