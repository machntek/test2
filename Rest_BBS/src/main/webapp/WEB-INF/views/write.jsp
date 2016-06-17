<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="./include/header.jsp" %>
<h1>
	board_Write
</h1>
<form action="/rest/" method="post">
	<table>
		<tr>
			<th>타이틀</th>
			<td><input type="text" name="title"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="user_name"></td>
		</tr>
	</table>
	<input type="submit" value="등록">
</form>
<%@ include file="./include/footer.jsp" %>