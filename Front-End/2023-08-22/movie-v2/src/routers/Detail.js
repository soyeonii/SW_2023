import React, { useEffect } from "react";
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
function Detail() {
  const location = useLocation();
  const navigate = useNavigate();

  console.log("location", location);
  useEffect(() => {
    if (location.state === null) {
      navigate("/");
    }
  });
  
  if (location.state) {
    return (
      <div className="about__container">
        <div className="movie">
          <img
            src={location.state.poster}
            alt={location.state.title}
            title={location.state.title}
          />
          <h3 className="movie__title">{location.state.title}</h3>
          <h5 className="movie__year">{location.state.year}</h5>
          <p className="movie__summary">
            {location.state.summary.slice(0, 180)}...
          </p>
        </div>
      </div>
    );
  } else {
    return null;
  }
}

export default Detail;
