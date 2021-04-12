<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Goods" %>
<% Goods goods = new Goods(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href ="/gotoFukuoka/GoodAdd?user_id=<%=rs.getString("user_id")%>&article_id=<%= 
rs.getString("article_id")%>>いいね</a><br>
<p>いいね数：<%= goods.getGoodCnt() %></p>
</body>
</html>