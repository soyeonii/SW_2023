import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function MemberPage() {
  const [member, setMember] = useState({});

  useEffect(() => {
    fetch("http://localhost:8080/user1")
      .then((response) => response.json())
      .then((member) => {
        setMember(member);
      })
      .catch((e) => console.log(e));
  }, []);

  return (
    <>
      <h1>{member.id}님 반갑습니다.</h1>
      <Link to="/login">
        <button>logout</button>
      </Link>
      &nbsp;
      <Link to="/update" state={member}>
        <button>update</button>
      </Link>
    </>
  );
}

export default MemberPage;
