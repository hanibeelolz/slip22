<html>
<body>
<form method=POST action="userGreet.jsp">
<hr><h2>GREETING<hr>
<h3>Enter the Name : 
<input type=text name=name >
<br>
<input type = submit value = "SUBMIT" >
<input type = reset value = "RESET" >
</body>
</html>
<%@ page language="java" import="java.util.*" %>
<html>
<body>
<% 
if(request.getParameter("name")=="")
 {
response.sendRedirect("greet.html");
 }
 else 
 {
Date d = new Date();
int n = d.getHours();
String s = request.getParameter("name");
if(n>0 && n<12)
out.print("<h3>Hi..."+s+"<br>Good Morning...");
else if(n>=12 && n<16)
out.print("<h3>Hi..."+s+"<br>Good AfterNoon...");
else if(n>=16 && n<20)
out.print("<h3>Hi..."+s+"<br>Good Evening...");
else if(n>=20 && n<24)
out.print("<h3>Hi..."+s+"<br>Good Night...");
}
%>
</body>
</html>
