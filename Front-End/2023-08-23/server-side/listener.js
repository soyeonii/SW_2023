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

const members = [];

app.listen(8080, () => {
  console.log("start member service!");
  console.log("listening...");
  members.push({ id: "admin", password: "1234", name: "eddy", manager: true });
  members.push({ id: "user1", password: "1234", name: "kim", manager: false });
  members.push({ id: "user2", password: "1234", name: "lee", manager: false });
});

/** Restful API */

function getData(memberId) {
  for (const i in members) {
    if (members[i].id === memberId) {
      return [i, members[i]];
    }
  }
}

// login
app.post("/login", (req, res) => {
  let memberId = req.body.id;
  let memberPw = req.body.password;
  const data = getData(memberId);
  if (data && memberPw == data[1].password) {
    res.send(JSON.stringify(data[1]));
  }
});

// findAll
app.get("/", (req, res) => {
  res.send(JSON.stringify(members));
});

// findOne
app.get("/:id", (req, res) => {
  const data = getData(req.params.id);
  console.log(data[1]);
  res.send(JSON.stringify(data[1]));
});

// create
app.post("/join", (req, res) => {
  const member = {
    id: req.body.id,
    password: req.body.password,
    name: req.body.name,
    manager: req.body.manager,
  };
  members.push(member);
  res.send(JSON.stringify({ result: true }));
});

// update
app.put("/:id", (req, res) => {
  let data = getData(req.params.id);
  data[1].password = req.body.password;
  data[1].name = req.body.name;
  data[1].manager = req.body.manager;
  members[data[0]] = data[1];
  console.log(members[data[0]]);
  res.send(JSON.stringify({ result: true }));
});

// delete
app.delete("/:id", (req, res) => {
  const data = getData(req.params.id);
  members.splice(data[0], 1);
  res.send(JSON.stringify({ result: true }));
});
