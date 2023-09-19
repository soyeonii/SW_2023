<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>글 목록</title>
    <style>
      .cls2 {
        text-align: center;
        font-size: 30px;
        display: block;
      }

      .cls1 {
        text-decoration: none;
      }
    </style>
  </head>
  <body>
    <table align="center" border="1" width="80%">
      <thead>
        <tr height="10" align="center" bgcolor="lightgreen">
          <th>글 번호</th>
          <th>작성자</th>
          <th>제목</th>
          <th>작성일</th>
        </tr>
      </thead>
      <c:choose>
        <c:when test="${empty dataList}">
          <tbody>
            <tr height="10">
              <td colspan="4">
                <p align="center">
                  <b>
                    <span style="font-size: 9pt"> 등록된 글이 없습니다. </span>
                  </b>
                </p>
              </td>
            </tr>
          </tbody>
        </c:when>
        <c:otherwise>
          <tbody>
            <c:forEach var="article" items="${dataList}" varStatus="articleNum">
              <tr align="center">
                <td width="5%">${articleNum.count}</td>
                <td width="10%">${article.write_id}</td>
                <td align="left" width="35%">
                  <span style="padding-right: 30px"></span>
                  <a
                    class="cls1"
                    href="${contextPath}/sku/view?no=${article.article_no}"
                  >
                    ${article.title}
                  </a>
                </td>
                <td width="10%">${article.write_date}</td>
              </tr>
            </c:forEach>
          </tbody>
        </c:otherwise>
      </c:choose>
    </table>
    <a href="${contextPath}/sku/add" class="cls1">
      <span class="cls2">글쓰기</span>
    </a>
  </body>
</html>
