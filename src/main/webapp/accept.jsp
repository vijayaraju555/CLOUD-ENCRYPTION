
<%@page import="java.sql.*"%>

<%
String id=request.getParameter("reqid");
System.out.println(id);

/* String pkey=request.getParameter("pkey");
System.out.println(id); */

	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://database-1.czeaqwkwy2sw.ap-south-1.rds.amazonaws.com:3306/untrustcloud","admin","vijay123");
	PreparedStatement pst =con.prepareStatement("update req set status='accepted' where reid='"+id+"'");	
	int k=pst.executeUpdate();
	if(k!=0)
	{
	response.sendRedirect("viewreq.jsp?msg=Accepted Successfully");
	}
	else
	{
	response.sendRedirect("viewreq.jsp?msg=failed");
	}
	
		
	%>