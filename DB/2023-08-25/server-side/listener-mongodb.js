const express = require("express");
const app = express();

const { MongoClient } = require("mongodb");
const url = "mongodb://127.0.0.1:27017";
const client = new MongoClient(url);

// security 처리 필요
const cors = require("cors");
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(
  cors({
    origin: "*",
  })
);

let collection = null;

app.listen(8080, async () => {
  console.log("start user service!");
  console.log("listening...");
  await client.connect();
  collection = client.db("test").collection("users");
});

/** Restful API */

function getData(userId) {
  for (const i in users) {
    if (users[i].id === userId) {
      return [i, users[i]];
    }
  }
}

// findAll
app.get("/", async (req, res) => {
  const documents = await collection.find().toArray();
  console.log(documents);
  res.send(JSON.stringify(documents));
});

// findOne
app.get("/:id", async (req, res) => {
  const userId = req.params.id;
  const document = await collection.find({ id: userId }).toArray();
  console.log(document);
  res.send(JSON.stringify(document[0]));
});

// login
app.post("/login", async (req, res) => {
  const userId = req.body.id;
  const userPwd = req.body.password;
  // const data = getData(userId);
  const document = await collection
    .find({ id: userId, password: userPwd })
    .toArray();
  if (document) {
    console.log(document);
    res.send(JSON.stringify(document[0]));
  }
});

// create
app.post("/join", async (req, res) => {
  const user = {
    id: req.body.id,
    password: req.body.password,
    name: req.body.name,
    manager: req.body.manager,
  };
  const result = await collection.insertOne(user);
  console.log(result);
  res.send(JSON.stringify(result));
});

// update
app.put("/:id", async (req, res) => {
  const userId = req.params.id;
  const result = await collection.updateOne(
    { id: userId },
    {
      $set: {
        password: req.body.password,
        name: req.body.name,
        manager: req.body.manager,
      },
    }
  );
  res.send(JSON.stringify(result));
});

// delete
app.delete("/:id", async (req, res) => {
  const userId = req.params.id;
  const result = await collection.deleteOne({ id: userId });
  console.log(result);
  res.send(JSON.stringify(result));
});
