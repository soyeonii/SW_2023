<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
</head>
<body>
<h1>게시판</h1>
<table id="table-board">
    <thead>
    <tr>
        <td>글 번호</td>
        <td>글 제목</td>
        <td>작성자</td>
        <td>작성 시간</td>
        <td>수정 시간</td>
    </tr>
    </thead>
    <tbody id="tbody-board">
    </tbody>
</table>
<br/>
<a href="/board/write">글쓰기</a>
<script>
    let array = ${result};
    array.forEach(e => {
        console.log(JSON.parse(e))

        var obj = JSON.parse(e);
        let tr = document.createElement("tr");

        var td1 = document.createElement("td");
        td1.innerText = obj.id;
        var td2 = document.createElement("td");
        td2.innerHTML = "<a href='/board/showOne/" + obj.id + "'>" + obj.title + "</a>";
        var td3 = document.createElement("td");
        td3.innerText = obj.writerId;
        var td4 = document.createElement("td");
        td4.innerText = obj.entryDate;
        var td5 = document.createElement("td");
        td5.innerText = obj.modifyDate;

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);

        // <head>에서 tbody-board는 아직 만들어지지 않은 상태!
        document.getElementById("tbody-board").appendChild(tr);
    })
</script>
</body>
</html>