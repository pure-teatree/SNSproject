<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.feed.Feed" %>
<%@ page import="model.member.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<head>
    <script language=javascript>
    document.getElementById('deleteclicker').addEventListener('click', sendDelete);
    
        function sendLike() {
            document.requestForm.command.value="updateLike";
            document.requestForm.submit();
        }

        function sendDelete() {
            document.requestForm.command.value="delete";
            console.log("sendDelete() 함수 실행 ");
            document.requestForm.submit();
            console.log("delete submit 호출");
            
        }
    </script>
</head>

<c:set var="userId" value="${sessionScope.user.id}"/>

<c:forEach items="${requestScope.list}" var="e">
  <div class="w3-container w3-card w3-white w3-round w3-margin"><br>
        <span class="w3-right w3-opacity">${e.writeday}</span>
        <h6>${e.memberId.name}</h6>
        
        <hr class="w3-clear">
        <p>${e.content}</p>
        <div class="w3-row-padding" style="margin:0 -16px">
            <div class="w3-half">
            </div>
            <div class="w3-half">
        </div>
        </div>
        <form type="requestForm" method="post" action="feed" onSubmit='return true;'>
            <input type="hidden" name="command" value="">
            <input type="hidden" name="feedNo" value="${e.fno}">
            <button onclick="sendLike()" type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i>  Like${e.thumbUp}</button> 
            <c:set var="id" value="${e.memberId.id}"/>
            <c:if test="${id eq userId}">
                <button id="deleteclicker" type="button" class="w3-button w3-theme-d2 w3-margin-bottom" style="float: right;">  Delete</button> 
            </c:if>
        </form>

    </div>
</c:forEach>
