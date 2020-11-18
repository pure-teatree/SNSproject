<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.feed.Feed"%>
<%@ page import="model.member.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="w3-card w3-round w3-white">
	<div class="w3-container">
		<h4 class="w3-center">My Profile</h4>
		<hr>
		<p>
			<i class="fa fa-user fa-fw w3-margin-right w3-text-theme"></i>
			${user.name}
		</p>
		<p>
			<i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i>
			${user.info}
		</p>
	</div>
</div>
<br>