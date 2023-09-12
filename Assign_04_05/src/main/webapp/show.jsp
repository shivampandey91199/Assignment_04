<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Student Data</h2>
 <sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver" 
   url="jdbc:mysql://localhost:3306/advance" user="root" password=""/>
    <sql:query var="result" dataSource="${dataSource}">
     select * from user;
    </sql:query>
    <table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.id}" /></td>
				<td><c:out value="${row.name}"></c:out></td>
				<td><c:out value="${row.email}"></c:out></td>
				<td><c:out value="${row.contact}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
    
    
</body>
</html>