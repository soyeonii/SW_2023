import React, { useState, useEffect } from "react";
import Movie from "../components/Movie";
import "./Home.css";
import { useParams } from "react-router-dom";
import Pagebar from "../components/Pagebar";

function Home() {
  const [isLoading, setIsLocation] = useState(true);
  const [movies, setMovies] = useState([]);
  const [totalCount, setTotalCount] = useState(0);
  let params = useParams();
  //훅 Hook
  //componentDidMount,componentDitUpdate,componentWillUmmount
  useEffect(() => {
    console.log("didMount");

    fetch(
      `https://yts-proxy.now.sh/list_movies.json?sort_by=rating&page=${params.page}`
    )
      .then((response) => response.json())
      .then((data) => {
        //console.log(data);
        setTotalCount(data.data.movie_count);
        let movies = data.data.movies;
        setIsLocation(false);
        setMovies(movies);
      })
      .catch((e) => console.log(e));
    //console.log(movies);
    //this.setState({movies,isLoading:false});

    return () => {
      console.log("willUmmount");
    };
  }, [params.page]);
  return (
    <div>
      <Pagebar totalCount={totalCount} page={params.page} perPage={10} />
      <section className="container">
        {isLoading ? (
          <div className="loader">
            <span className="loader__text">Loading...</span>
          </div>
        ) : (
          <div className="movies">
            {movies.map((movie) => {
              console.log(movie);
              return (
                <Movie
                  key={movie.id}
                  id={movie.id}
                  year={movie.year}
                  title={movie.title}
                  summary={movie.summary}
                  poster={movie.medium_cover_image}
                  genres={movie.genres}
                />
              );
            })}
          </div>
        )}
      </section>
    </div>
  );
}

export default Home;
