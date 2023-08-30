import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
function Delete() {
  const [flag, setFlag] = useState(false);
  const params = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    fetch(`http://localhost:8080/${params.id}`, { method: "delete" })
      .then((response) => response.json())
      .then((data) => {
        setFlag(data.flag);
        navigate("/Read");
      });
  }, [navigate, params.id]);

  if (!flag) {
    return (
      <div>
        <h1>{`Delete .... ${params.id}`}</h1>
      </div>
    );
  } else {
    return null;
  }
}

export default Delete;
