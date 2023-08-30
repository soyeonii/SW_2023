const express = require("express");
const app = express();
const cors = require("cors");
const bodyParser = require("body-parser");
const mysql = require("mysql2");
const config = require("./database-config");

app.use(
  cors({
    origin: "*",
  })
);
app.use(bodyParser.json());

app.listen(8080, () => {
  console.log("start gisa server...");
  console.log("listening...");
});

const correctAnswers = [990490, 192, 99549, 397];

app.post("/quiz", (req, res) => {
  let index = req.body.quiz_number - 1;
  let sql = req.body.query;
  let result = { isCorrect: false, tryAnswer: 0, correctAnswer: 0 };
  console.log(index, sql);
  const connect = mysql.createConnection(config);
  connect.query(sql, (err, rows, _) => {
    if (err) {
      console.log(err);
    } else {
      result.tryAnswer = rows[0].answer;
      result.correctAnswer = correctAnswers[index];
      result.isCorrect = result.tryAnswer == result.correctAnswer;
      res.send(JSON.stringify(result));
    }
  });
  connect.end();
});
