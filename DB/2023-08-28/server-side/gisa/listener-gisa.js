const express = require("express");
const app = express();
const mysql = require("mysql2");
const config = require("./database-config");

const cors = require("cors");
app.use(
  cors({
    origin: "*",
  })
);
const bodyParser = require("body-parser");
app.use(bodyParser.json());
// app.use(bodyParser.urlencoded({ extended: true }));

app.listen(8080, () => {
  console.log("start member mysql service!");
  console.log("listening...");
});

/* Restful API */

// getResult
app.get("/:query", (req, res) => {
  const connect = mysql.createConnection(config);
  let sql = req.params.query;
  sql = sql.replaceAll("+", " ");
  console.log(sql);
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      console.log("rows", rows);
      res.send(JSON.stringify(rows[0]));
    }
  });
  connect.end();
});
