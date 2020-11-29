<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Application Form</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="userhome.jsp">Logout</a></div>

</head>
<body>

<form action="newapplication" method="POST"  >
	<table border="0" cellspacing="0" cellpadding="0" width="40%" >
			<tr><td><strong>User Name</strong></td> 
			<td><em>${username}</em></td>
			</tr>
			<tr><td><strong>Loan Purpose</strong></td> 
			<td><em><input type="text" name="purpose" required /></em></td>
			</tr>
			<tr><td><strong>Loan Name</strong></td> 
			<td><em><input type="text" name="loanName" required /></em></td>
			</tr>
			<tr><td><strong>Loan Amount</strong></td> 
			<td><em><input type="number" name="amtRequested" required /></em></td>
			</tr>
			<tr><td><strong>Business Structure</strong></td> 
			<td><select name="busstructure">
					<option></option>
					<option>Individual</option>
					<option>Organization</option>
					</select></td>
			</tr>
			<tr><td><strong>Billing Indicator</strong></td> 
			<td><select name="blngstructure">
					<option></option>
					<option>Salaried</option>
					<option>NonSalaried</option>
					</select></td>
			</tr>
			<tr><td><strong>Tax Indicator</strong></td> 
			<td><select name="taxstructure">
					<option></option>
					<option>Tax-Payer</option>
					<option>Non Tax-Payer</option>
					</select></td>
			</tr>
			<tr><td><strong>Address</strong></td> 
			<td><em><input type="text" name="address" required /></em></td>
			</tr>
			<tr><td><strong>Mobile</strong></td> 
			<td><em><input type="text" name="mobile" required /></em></td>
			</tr>
			<tr><td><strong>Email</strong></td> 
			<td><em><input type="text" name="email" required /></em></td>
			</tr>
			<tr><td>
				<button>Submit</button>
			<td><em></em></td>
			</tr>
	</table>
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>