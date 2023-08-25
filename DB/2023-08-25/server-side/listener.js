const express = require("express");
const app = express();

// security 처리 필요
const cors = require("cors");
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(
  cors({
    origin: "*",
  })
);

const users = [];

app.listen(8080, () => {
  console.log("start user service!");
  console.log("listening...");
  users.push({ id: "admin", password: "1234", name: "eddy", manager: true });
  users.push({ id: "user1", password: "1234", name: "kim", manager: false });
  users.push({ id: "user2", password: "1234", name: "lee", manager: false });
});

/** Restful API */

function getData(userId) {
  for (const i in users) {
    if (users[i].id === userId) {
      return [i, users[i]];
    }
  }
}

// login
app.post("/login", (req, res) => {
  let userId = req.body.id;
  let userPw = req.body.password;
  const data = getData(userId);
  if (data && userPw == data[1].password) {
    res.send(JSON.stringify(data[1]));
  }
});

// findAll
app.get("/", (req, res) => {
  res.send(JSON.stringify(users));
});

// findOne
app.get("/:id", (req, res) => {
  const data = getData(req.params.id);
  console.log(data[1]);
  res.send(JSON.stringify(data[1]));
});

// create
app.post("/join", (req, res) => {
  const user = {
    id: req.body.id,
    password: req.body.password,
    name: req.body.name,
    manager: req.body.manager,
  };
  users.push(user);
  res.send(JSON.stringify({ result: true }));
});

// update
app.put("/:id", (req, res) => {
  let data = getData(req.params.id);
  data[1].password = req.body.password;
  data[1].name = req.body.name;
  data[1].manager = req.body.manager;
  users[data[0]] = data[1];
  console.log(users[data[0]]);
  res.send(JSON.stringify({ result: true }));
});

// delete
app.delete("/:id", (req, res) => {
  const data = getData(req.params.id);
  users.splice(data[0], 1);
  res.send(JSON.stringify({ result: true }));
});
