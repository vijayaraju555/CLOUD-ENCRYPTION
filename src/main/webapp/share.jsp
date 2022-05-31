
<%@page import="java.sql.*"%>

<%

String id2=request.getParameter("fid");
System.out.println(id2);

/* String pkey=request.getParameter("pkey");
System.out.println(id);
 */
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://database-1.czeaqwkwy2sw.ap-south-1.rds.amazonaws.com:3306/untrustcloud","admin","vijay123");
	PreparedStatement pst =con.prepareStatement("update upload set share='1'  where fid='"+id2+"'");	
	int k=pst.executeUpdate();
	if(k!=0)
	{
	response.sendRedirect("viewfile.jsp?msg=File Shared Successfully");
	}
	else
	{
	response.sendRedirect("viewreq.jsp?msg=failed");
	}
	
	
	
	%>