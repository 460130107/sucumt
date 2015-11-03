package gyzactivity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updateactstate
 */
@WebServlet("/Updateactstate")
public class Updateactstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateactstate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String xiugai=request.getParameter("xiugai");
		System.out.print(xiugai);
		Integer activity_id=Integer.parseInt(request.getParameter("activity_id"));
		PrintWriter out=response.getWriter();
		
		if(xiugai!=null&&xiugai.equals("state")){
		try {
			Connection conn = eb.javaweb.DBUtil.getConnection();
			PreparedStatement ptmt = conn.prepareStatement("update activity set state=? where activity_id=?");
			ptmt.setInt(1, 1);
			ptmt.setInt(2, activity_id);
			ptmt.execute();
			
			response.sendRedirect("activityaskshow.html");
		}
		catch (SQLException e) {
			out.print(e);
		}
		}else{
			try {
				Connection conn = eb.javaweb.DBUtil.getConnection();
				PreparedStatement ptmt = conn.prepareStatement("update activity set laststate=? where activity_id=?");
				ptmt.setInt(1, 1);
				ptmt.setInt(2, activity_id);
				ptmt.execute();
				response.sendRedirect("tuanweishenhe.html");
			}
			catch (SQLException e) {
				out.print(e);
			}	
	}
			
			
		}
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
