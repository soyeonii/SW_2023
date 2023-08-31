const mysql = require("mysql2");
const config = require("./database-config");
const lineReader = require("line-reader");

lineReader.eachLine("book1_UTF-8.csv", (line, _) => {
  console.log(line);

  const [book_isbn, book_title, book_author, book_published_date] =
    line.split(",");

  const connect = mysql.createConnection(config);
  let sql = `insert into book_info values ('${book_isbn}', '${book_title}', '${book_author}', '${book_published_date}')`;
  connect.query(sql, (err, rows, fields) => {
    if (err) {
      console.log(err);
    } else {
      console.log("insert", line);
    }
  });
  connect.end();
});
