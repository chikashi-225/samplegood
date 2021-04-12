package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodLogic;
import model.Goods;
/**
 * Servlet implementation class GoodAdd
 */
@WebServlet("/GoodAdd")
public class GoodAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータから検索条件の取得、（JSPからuser_id, article_idを取得）
        request.setCharacterEncoding("UTF-8");
        String user_id = request.getParameter("user_id");
        String article_id = request.getParameter("article_id");

        //データをGoods()のコンストラクタに入れる

        Goods goods = new Goods(user_id, article_id);
        GoodLogic goodLogic = new GoodLogic();
        goodLogic.goodPlus(goods);

        request.setAttribute("goods", goods);
	}

}
