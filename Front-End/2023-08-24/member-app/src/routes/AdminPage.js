import React, { useState, useEffect } from "react";
import Member from "../components/Member";
import { Link } from "react-router-dom";

function AdminLogin() {
  const [members, setMembers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/")
      .then((response) => response.json())
      .then((members) => {
        setMembers(members);
      })
      .catch((e) => console.log(e));
  }, []);

  return (
    <>
      <Link to="/login">
        <button>logout</button>
      </Link>
      <table>
        <tbody>
          {members.map((member) => {
            return (
              <Member
                key={member.id}
                id={member.id}
                password={member.password}
                name={member.name}
                manager={member.manager}
              />
            );
          })}
        </tbody>
      </table>
    </>
  );
}

export default AdminLogin;
