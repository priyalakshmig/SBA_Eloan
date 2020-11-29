package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;
import com.iiht.evaluation.eloan.dao.UserDAO;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.mysql.cj.util.Util;
import com.mysql.cj.xdevapi.Statement;




@WebServlet({"/user","/login","/newapplication"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ConnectionDao connDao;
	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName=registernewuser(request,response);
				break;
			case "validate":
				viewName=validate(request,response);
				break;
			case "/placeloan":
				viewName=placeloan(request,response);
				break;
			case "application1":
				viewName=application1(request,response);
				break;
			case "editLoanProcess"  :
				viewName=editLoanProcess(request,response);
				break;
			case "registeruser":
				viewName=registerUser(request,response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;	
			case  "displaystatus" :
				viewName=displaystatus(request,response);
				break;
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	}
	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to validate the user */
		
		return null;
	}
	private String placeloan(HttpServletRequest request, HttpServletResponse response) throws IOException {
try (PrintWriter out = response.getWriter()) {

        	
            //Session Handling
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache");   //HTTP 1.0
            response.setHeader("Expires", "0"); //Proxies

            //Get the form data
            float amount = Float.parseFloat(request.getParameter("amtRequested"));
            int loan_id = Integer.parseInt(request.getParameter("applno"));

            Date utilDate = new Date(loan_id);
            java.sql.Date applyDate = new java.sql.Date(utilDate.getTime());

            //String guarantor_name = request.getParameter("guarantor");
            String mobile_no = request.getParameter("mobile");
            String address = request.getParameter("address");
            String email_id = request.getParameter("email");
            HttpSession session = request.getSession();
            //String email_id = session.getAttribute("username").toString();

            System.out.println(amount + " " + loan_id);

            Connection con;
            ResultSet rs;
            PreparedStatement ps;
            Statement st;

            //Store the loan application data to database
            try {
            	con = UserDAO.connect();
            	
                ps = con.prepareStatement("insert into Loanapp(email, LOAN_APPL_Num, LOAN_APPL_DATE, LOAN_AMOUNT_req, mobile, address) values (?, ?, ?, ?, ?, ?)");
                ps.setString(1, email_id);
                ps.setInt(2, loan_id);
                ps.setDate(3, applyDate);
                ps.setFloat(4, amount);
                ps.setString(5, mobile_no);
                ps.setString(6, address);

                ps.execute();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
}
        
		return "application.jsp";
	}
	private String application1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write the code to display the loan application page */
		
		return null;
	}
	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoanInfo editloano = new LoanInfo();
		editloano.setPurpose(request.getParameter("purpose"));
		editloano.setAmtrequest(Integer.parseInt(request.getParameter("amtrequest")));
		editloano.setBstructure(request.getParameter("bstructure"));
		editloano.setBindicator(request.getParameter("bindicator"));
		editloano.setAddress(request.getParameter("address"));

		Connection con;
        ResultSet rs;
        PreparedStatement ps = null;
        Statement st;

        //Store the loan application data to database
        try {
        	con = UserDAO.connect();
		
		ps.setInt(1, editloano.getAmtrequest());
		ps.setString(2, editloano.getAddress());
		ps.setString(3, editloano.getPurpose());
		ps.setString(4, editloano.getBstructure());
		ps.setString(5, editloano.getBindicator());

		ps.executeUpdate();
		} catch (SQLException e) {
		throw new Exception("SQL Exception: Unable to update loan details");
		}
	

		return "editloan.jsp";
		
		/* write the code to edit the loan info */
		
		
	}
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		

	
		/* write the code to redirect page to read the user details */
		return "index.jsp";
	}
	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to create the new user account read from user 
		   and return to index page */
		
		return null;
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */
		
		return null;
	}
	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code the display the loan status based on the given application
		   number 
		*/
		
		return null;
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to editloan page */
		return null;
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		
		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		return null;
	}
}