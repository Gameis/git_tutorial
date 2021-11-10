package member.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import memberDAO.MemberDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");		
		String pwd = request.getParameter("pwd");	
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		MemberDAO memberDAO = MemberDAO.getInstance();
		String name = memberDAO.check(memberDTO);
		
		if(name != null)
		{
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println(name + "님 로그인<br>");
			out.println("<input type='button' onclick='goLogin()' value='로그인'");
			out.println("</body>");
			out.println("</html>");
		}else
		{
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("아이디 또는 비밀번호가 틀립니다.<br>");
			out.println("<input type='button' onclick='goLogin()' value='로그인'");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
