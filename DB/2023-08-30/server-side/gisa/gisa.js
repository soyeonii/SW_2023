const mysql = require("mysql2");
const config = require("./database-config");
const lineReader = require("line-reader");
console.log(lineReader);

lineReader.eachLine("./gisa/Abc1115.csv", (line, lasg) => {
  console.log(line);
  const [
    stdNo,
    email,
    kor,
    eng,
    math,
    sci,
    hist,
    total,
    mgr_code,
    acc_code,
    loc_code,
  ] = line.split(",");

  const connect = mysql.createConnection(config);
  let sql = `insert into students values ('${stdNo}', '${email}', ${kor}, ${eng}, ${math}, ${sci}, ${hist}, ${total}, '${mgr_code}', '${acc_code}', '${loc_code}')`;
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      console.log("insert", line);
    }
  });
  connect.end();
});
