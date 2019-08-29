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
 * Servlet implementation class Join
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String pwcheck = request.getParameter("PW_check");
		String name = request.getParameter("name");
		String nick = request.getParameter("NICKNAME");
		String sex = request.getParameter("SEX");
		String email = request.getParameter("MAIL_ID");
		int host = Integer.parseInt(request.getParameter("MAIL_HOST"));
		String url = request.getParameter("HOMEPAGE");
		String address = request.getParameter("ADDRESS");
		String[] hobby = request.getParameterValues("HOBBY");
		
		String mailhost = "";
		switch(host) {
		case 1:
			mailhost = "naver.com"; break;
		case 2:
			mailhost = "gmail.com"; break;
		case 3:
			mailhost = "daum.net"; break;
		}
		
		Member m = new Member(id, pw, name, nick, sex, email+"@"+mailhost, url, address, hobby);
		request.setAttribute("member", m);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp.ver/memberview.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
