package com.hansung.CMS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao = new MemberDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("action") == null) {
			return;
		}
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("MEMBERSAVE")) {
			memberSave(request, response);
			return;
		} else if (action.equalsIgnoreCase("LOGIN")) {
			login(request, response);
			return;
		} else if (action.equalsIgnoreCase("LOGOUT")) {
			logout(request, response);
			return;
		} else if(action.equalsIgnoreCase("MEMBERLIST")) {
			memberList(request, response);
			return;
		} else if(action.equalsIgnoreCase("MEMBERDETAIL")) {
			memberDetail(request, response);
			return;
		} else if(action.equalsIgnoreCase("DELETE")) {
			memberDelete(request, response);
			return;
		} else if(action.equalsIgnoreCase("MODIFY")) {
			memberModify(request, response);
			return;
		} else if(action.equalsIgnoreCase("MODIFYSAVE")) {
			modifySave(request, response);
			return;
		}		
		else {
			response.sendRedirect("jsp.ver/member.jsp");
		}
	}
	
	public void modifySave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("modify save");
		
		String id = request.getParameter("ID");
		System.out.println("id = " + id);
		String pw = request.getParameter("PW");
		String name = request.getParameter("NAME");
		String nick = request.getParameter("NICKNAME");
		String sex = request.getParameter("SEX");
		String email = request.getParameter("MAIL_ID");
		String url = request.getParameter("HOMEPAGE");
		String address = request.getParameter("ADDRESS");
		String[] hobby = request.getParameterValues("HOBBY");

		Member m = new Member(id, pw, name, nick, sex, email, url, address, hobby);
		try {
			dao.update(m);
			memberList(request, response);
		} catch (SQLException e) {
			System.out.println("안된당");
			response.sendRedirect("jsp.ver/member.jsp");
			return;
		}
		
	}
	
	public void memberModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("modify");
		String id = request.getParameter("id");
		try {
			Member m = dao.search(id);
			request.setAttribute("member", m);
			request.getRequestDispatcher("jsp.ver/modify.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void memberDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("delete");
		String id = request.getParameter("id");
		try {
			dao.delete(id);
			memberList(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void memberDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			Member m = dao.search(id);
			request.setAttribute("member", m);
			request.getRequestDispatcher("jsp.ver/memberview.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void memberList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Member> list = dao.search();
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp.ver/memberList.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			String msg = "검색에 실패했습니다.";			
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("WEB-INF/error/errorPage.jsp").forward(request, response);
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그아웃 한당");
		request.getSession().invalidate();
		response.sendRedirect("jsp.ver/login.jsp");
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("user");
		String pw = request.getParameter("pass");

		try {

			if (dao.loginCheck(id, pw)) {
				request.getSession().setAttribute("user", id);
				response.sendRedirect("jsp.ver/result.jsp");
			}

			else {
				String msg = "아이디 또는 패스워드가 틀립니다.";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("jsp.ver/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void memberSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("call MemberSave");

		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String name = request.getParameter("NAME");
		String nick = request.getParameter("NICKNAME");
		String sex = request.getParameter("SEX");
		String email = request.getParameter("MAIL_ID");
		String url = request.getParameter("HOMEPAGE");
		String address = request.getParameter("ADDRESS");
		String[] hobby = request.getParameterValues("HOBBY");

		Member m = new Member(id, pw, name, nick, sex, email, url, address, hobby);
		try {
			dao.add(m);
		} catch (SQLException e) {
			System.out.println("안된당");
			response.sendRedirect("jsp.ver/member.jsp");
			return;
		}
		request.setAttribute("member", m);
		System.out.println("만들었따");
		request.getRequestDispatcher("jsp.ver/memberview.jsp").forward(request, response);
		System.out.println("보낸당");
	}
}
