<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>게시글 조회</title>
    <script type="text/javascript">
        var result = JSON.parse('${result}');

        function displayBoard() {
            document.getElementById('id').textContent = result.id;
            document.getElementById('writerId').textContent = result.writerId;
            document.getElementById('title').textContent = result.title;
            document.getElementById('content').textContent = result.content;
            document.getElementById('entryDate').textContent = result.entryDate;
            document.getElementById('modifyDate').textContent = result.modifyDate;
        }
    </script>
</head>
<body>
<h1>게시글 조회</h1>
<table>
    <tr>
        <th>ID</th>
        <td id="id"></td>
    </tr>
    <tr>
        <th>Writer ID</th>
        <td id="writerId"></td>
    </tr>
    <tr>
        <th>Title</th>
        <td id="title"></td>
    </tr>
    <tr>
        <th>Content</th>
        <td id="content"></td>
    </tr>
    <tr>
        <th>Entry Date</th>
        <td id="entryDate"></td>
    </tr>
    <tr>
        <th>Modify Date</th>
        <td id="modifyDate"></td>
    </tr>
</table>
<br>
<a href="/board/showAll">목록</a>
<script>
    displayBoard();
</script>
</body>
</html>