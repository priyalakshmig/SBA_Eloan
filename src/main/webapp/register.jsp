<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="form" action="userhome1.jsp" method="post">
	
User name :<input type="text" name="userid" /><br>
password :<input type="password" name="password" /><br>
Retype password :<input type="password" name="confirmpassword" /><br>
<input type="submit" name="submit" value="signup" />
		<%-- <table>
		<tr>
		<td><h2>eLoan Registration</h2>	</td>
		</tr>		
			<tr><td><strong>User Name</strong></td> 
			<td><em><input type="text" name="username" required /></em></td>
			</tr>
			<tr><td><strong>password</strong></td> 
			<td><em><input type="password" name="password" required /></em></td>
			</tr>
			<tr><td><strong>Retype password</strong></td> 
			<td><em><input type="password" name="confirmpassword" required /></em></td>
			</tr>
			<tr>

				
			<tr>

				<td><input type="submit" name="submit" value="signup"></input></td>
				<td></td>
			</tr>
		</table> --%>
	</form>

<jsp:include page="footer.jsp"/>
</body>
</html>