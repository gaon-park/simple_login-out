package com.hansung.CMS;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
	      String user = request.getParameter("user");
	      String pass = request.getParameter("pass");
	      //3. 처리 (DB연동처리--> DAO클래스 이용)
	      //4. 결과처리(회원이거나 아니거나)
	      
	      if(user.equals("admin1111")) {
	    	  if(pass.equals("admin1111")) {
	    		  request.setAttribute("user", user);
	    		  RequestDispatcher rd = request.getRequestDispatcher("/jsp.ver/result.jsp");
	    		  rd.forward(request, response);
	    		  return;
	    	  }
	      }
	      String msg = "아이디 또는 패스워드가 틀립니다.";
	      request.setAttribute("msg", msg);
	      request.getRequestDispatcher("jsp.ver/login.jsp").forward(request, response);
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);

	}

}
