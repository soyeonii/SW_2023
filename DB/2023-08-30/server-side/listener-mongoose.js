const express = require("express");
const app = express();

const url = "mongodb://127.0.0.1:27017";

const mongoose = require("mongoose");
const Member = require("./members-model");

// security 처리 필요
const cors = require("cors");
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(
  cors({
    origin: "*",
  })
);
mongoose.set("strictQuery", false); // query를 엄격하게 처리하지 않음

app.listen(8080, async () => {
  console.log("start member mongoose service!");
  console.log("listening...");
  mongoose
    .connect(url, { useNewUrlParser: true })
    .then(console.log("Connected to mongooseDB"));
});

/* Restful API */

// findAll
app.get("/", async (req, res) => {
  const members = await Member.find({});
  console.log(members);
  res.send(members);
});

// findOne
app.get("/:id", async (req, res) => {
  const userId = req.params.id;
  const member = await Member.findOne({ id: userId });
  console.log(member);
  res.send(member);
});

// create
app.post("/join", async (req, res) => {
  const result = new Member(req.body);
  await result.save();
  console.log(result);
  res.send(result);
});

// update
app.put("/:id", async (req, res) => {
  const userId = req.params.id;
  const member = await Member.findOneAndUpdate(
    { id: userId },
    { $set: req.body },
    { new: true }
  );
  res.send(member);
});

// delete
app.delete("/:id", async (req, res) => {
  const userId = req.params.id;
  const deleteResult = await Member.deleteOne({ id: userId });
  console.log(deleteResult);
  const result = { flag: deleteResult.acknowledged };
  res.send(result);
});
