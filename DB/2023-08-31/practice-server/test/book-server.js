const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const mysql = require("mysql2");
const config = require("./database-config");
const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(
  cors({
    origins: "*",
  })
);

app.listen(5000, () => {
  console.log("start book-server");
  console.log("listening...");
});

app.get("/:id", (req, resp) => {
  const con = mysql.createConnection(config);
  console.log(req.params.id);
  let sql = `select i.book_isbn,i.book_title,i.book_author,s.* from book_copy c  inner join (book_info i) on c.book_isbn = i.book_isbn inner join book_use_status s on s.book_seq = c.book_seq where s.borrow_start between '2023-8-1' and '2023-8-31' and s.user_id = '${req.params.id}'`;
  const data = {
    data: {
      bookInfo: {
        expectingReturn: [],
        list: [],
        returned: [],
        notReturned: [],
      },
      userInfo: {
        user: [
          {
            userId: "",
            userState: "",
            stopDate: "",
            totalUsingBook: [],
            returnedBook: [],
            notReturnedBook: [],
            expectingReturnBook: [],
            availableBook: [],
          },
        ],
      },
    },
  };

  con.query(sql, (err, rows, _) => {
    //console.log(rows);
    const temp1 = []; //notReturned
    const temp2 = []; //returned
    const temp3 = []; //expecting
    let books = rows;
    const now = new Date();
    for (const book of books) {
      if (book.return_date != null) {
        const date1 = new Date(book.return_date);
        const date2 = new Date(book.borrow_end);
        if (date1 > date2) {
          //연체
        } else {
          //정상
        }
        temp2.push(book);
      } else {
        if (new Date(book.borrow_end) < now) {
          temp1.push(book);
        } else if (new Date(book.borrow_end) > now) {
          temp3.push(book);
        }
      }
    }
    data.data.bookInfo.list = rows;
    (data.data.bookInfo.expectingReturn = temp3),
      (data.data.bookInfo.returned = temp2),
      (data.data.bookInfo.notReturned = temp1);
    const user = data.data.userInfo.user[0];
    user.userId = "user1";
    user.userState = "normal";
    user.stopDate = "2023-9-1";
    user.totalUsingBook = rows.length;
    user.returnedBook = temp2.length;
    user.notReturnedBook = temp1.length;
    user.expectingReturnBook = temp3.length;
    user.availableBook = 3 - temp2.length;

    //console.log(data);
    resp.send(data);
    if (err) {
      console.log(err);
    }
  });
  con.end();
});

app.get("/b/:bookId", (req, resp) => {
  let bookId = req.params.bookId;
  const con = mysql.createConnection(config);

  con.end();
});

app.get("/r/:bookId", (req, resp) => {
  let data = { result: true };
  resp.send(data);
});
