
/**
 * Servlet implementation class TestServlet
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
response.setContentType("text/html");
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("UTF-8");
PrintWriter out = response.getWriter();
String first = request.getParameter("first"); //从前端获取数据first
String second = request.getParameter("second");//从前端获取数据second
String result=first+second;
System.out.println(result); //用于测试 ，判断是否成功获取到数据；
 out.println(result);//将数据传到前端    
}
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
doPost(request, response);
response.setCharacterEncoding("GBK");
}

}
