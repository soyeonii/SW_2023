let mysql = require("mysql2");
let connect = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "1234",
  port: "3306",
  database: "skuni",
});

// Create, Read, Update, Delete
// let sql = "insert into members values ('user1', '1234', 'lee', false)";
let sql = "select * from members";
// let sql = "update members set name='song' where id='user1'";
// let sql = "delete from members where id='user1'";
connect.query(sql, (err, rows, fields) => {
  if (err) {
    console.log(err);
  } else {
    console.log("rows", rows);
    console.log("fields", fields);
  }
});

connect.end();
