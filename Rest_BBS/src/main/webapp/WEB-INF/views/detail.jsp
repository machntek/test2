<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ include file="./include/header.jsp" %>

<table>

	<tr>
		<th>Board_no</th>
		<td><c:out value="${vo.getBoard_no()}"/></td>
	</tr>
	<tr>
		<th>Title</th>
		<td><c:out value="${vo.getTitle()}"/></td>
	</tr>
	<tr>
		<th>Content</th>
		<td><c:out value="${vo.getContent()}"/></td>
	</tr>
	<tr>
		<th>Name</th>
		<td><c:out value="${vo.getUser_name()}"/></td>
	</tr>
	<tr>
		<th>regdate</th>
		<td><c:out value="${vo.getRegdate()}"/></td>
	</tr>
	<tr>
		<th>view_count</th>
		<td><c:out value="${vo.getView_cnt()}"/></td>
	</tr>

</table>

<form action="/rest/${vo.board_no}" method="post">
	<input type="hidden" id="_method" name="_method" value="DELETE"/>
	<input type="submit" value="삭제"/>
</form>

<h3>덧글</h3>

<div id="reply_list"></div>
<div id="reply_page"></div>

<form id="reply">
	<input type="text" id="content" name="content" size="50"/>
	,작성자 : <input type="text" id="user_name" name="user_name" size="10"/>
	<input type="button" onclick="insertReply()" value="등록"/>
</form>

<script>
	var bno = '${vo.getBoard_no()}';
	
	function deleteReply(rno) {
		$.ajax({
			type : 'delete',
			url : '/reply/' + rno,
			headers : {
				"Content-Type" : "application/json",
			},
			data : '',
				//'{"content":"'+reply_content+'", "user_name":"'+reply_user+'"}',
				
			dataType : 'text',	//받아오는 값의 타입
			success : function(result){
				if(result == "SUCCESS"){
					getReplyList();
				}
				
			}
		});
	}
	
	
	function insertReply() {
		//var reply_form = document.getElementById("reply");
		var reply_content = $("#content").val();
		var reply_user = $("#user_name").val();
		
		$.ajax({
			type : 'post',
			url : '/reply/' + bno,
			headers : {
				"Content-Type" : "application/json",
				//"X-HTTP-Method-Override" : "GET",		//_method에 해당
			},
			data : 
				JSON.stringify({content:reply_content, user_name:reply_user}),
				//'{"content":"'+reply_content+'", "user_name":"'+reply_user+'"}',
				
			dataType : 'text',	//받아오는 값의 타입
			success : function(result){
				if(result == "SUCCESS"){
					getReplyList();
				}
				
			}
		});
	}
	function setReplyList(list) {
		
		var result="<ul>";
		$(list).each(function() {
			result+="<li>" + this.reply_no + " : " +this.user_name + " (" + this.content + ")" 
			+ "<input type='button' id = 'btn_del' value= '삭제' onclick = 'deleteReply(" 
			+ this.reply_no + ")' class='btn btn-dagner'/>" +"</li>";
			
		})
		//for(var i in list) {
		//	result += "<li>" + list[i].user_name+ "&nbsp;&nbsp;" + list[i].content +"</li>";
		//}
		
		result += "</ul>";
		document.getElementById("reply_list").innerHTML = result;
	}
	
	function getReplyList(page) {
		
		
		$.ajax({
			type : 'get',
			url : '/reply/' + bno+'/' + page,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET",		//_method에 해당
			},
			dataType : 'json',
			data : '',	//url만 호출하면 되니까
			success : function(result){
				setReplyList(result.l);
				setPagePrint(result.p);
			}
		});
	}
	function setPagePrint(pm) {
		var str = "<ul class='pagination'>";
		if(pm.prev) {
			str += "<li>&lt;</li>"
		}
		
		for(var i = pm.startPage; i< pm.endPage; i++) {
			if(i == pm.criteria.page) {
				str += "<li><a href='active'>" + i + "</a></li>"
			}else {
				str += "<li><a href = '#' onclick = 'getReplyList(" + i + ")'>" +i+"</a></li>";
			}
		}
		if(pm.next){
			str += "<li>  &gt; </li>"
		}
		str+= "</ul>";
		document.getElementById("reply_page").innerHTML = str;
	}
	getReplyList(1);
</script>

<%@ include file="./include/footer.jsp" %>
