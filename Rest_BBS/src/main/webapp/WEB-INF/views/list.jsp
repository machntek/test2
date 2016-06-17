<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="./include/header.jsp" %>
<table>
	<thead>
		<th>Board_no</th>
		<th>Title</th>
		<th>Content</th>
		<th>Name</th>
		<th>regdate</th>
		<th>view_count</th>
	</thead>
	<tbody>
		<c:forEach items= "${list}" var="vo">
			<tr>
				<td><c:out value="${vo.getBoard_no()}"/></td>
				<td><a href="/rest/${vo.getBoard_no()}"/><c:out value="${vo.getTitle()}"/>(${vo.reply_cnt})</td>
				<td><c:out value="${vo.getUser_name()}"/></td>
				<td><c:out value="${vo.getContent()}"/></td>
				<td><c:out value="${vo.getRegdate()}"/></td>
				<td><c:out value="${vo.getView_cnt()}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="./include/footer.jsp" %>