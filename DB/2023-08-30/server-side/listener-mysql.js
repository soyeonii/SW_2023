const express = require("express");
const app = express();
const mysql = require("mysql2");
const config = require("./database-config");

// security 처리 필요
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

// findAll
app.get("/", (req, res) => {
  const connect = mysql.createConnection(config);
  let sql = "select * from members";
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      console.log("rows", rows);
      res.send(JSON.stringify(rows));
    }
  });
  connect.end();
});

// findOne
app.get("/:id", (req, res) => {
  const userId = req.params.id;
  const connect = mysql.createConnection(config);
  let sql = `select * from members where id=${userId}`;
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      console.log("rows", rows);
      res.send(JSON.stringify(rows));
    }
  });
  connect.end();
});

// login
app.post("/login", (req, res) => {
  const userId = req.body.id;
  const userPwd = req.body.password;
  const connect = mysql.createConnection(config);
  let sql = `select * from members where id='${userId}' and password='${userPwd}'`;
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      if (rows) {
        console.log("rows", rows);
        res.send(JSON.stringify(rows[0]));
      }
    }
  });
  connect.end();
});

// create
app.post("/join", (req, res) => {
  const userId = req.body.id;
  const userPwd = req.body.password;
  const userName = req.body.name;
  const userManager = req.body.manager;
  const connect = mysql.createConnection(config);
  let sql = `insert into members values ('${userId}', '${userPwd}', '${userName}', ${userManager})`;
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      if (rows) {
        console.log("rows", rows);
        res.send(JSON.stringify(rows));
      }
    }
  });
  connect.end();
});

// update
app.put("/:id", async (req, res) => {
  const userId = req.params.id;
  const userPwd = req.body.password;
  const userName = req.body.name;
  const userManager = req.body.manager;
  const connect = mysql.createConnection(config);
  let sql = `update members set password='${userPwd}', name='${userName}', manager=${userManager} where id='${userId}'`;
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      if (rows) {
        console.log("rows", rows);
        res.send(JSON.stringify(rows));
      }
    }
  });
  connect.end();
});

// delete
app.delete("/:id", (req, res) => {
  const userId = req.params.id;
  const connect = mysql.createConnection(config);
  let sql = `delete from members where id='${userId}'`;
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      if (rows) {
        console.log("rows", rows);
        res.send(JSON.stringify(rows));
      }
    }
  });
  connect.end();
});
