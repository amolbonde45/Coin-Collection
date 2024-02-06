package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CoinDAO;

/**
 * Servlet implementation class DeleteCoinServlet
 */
@WebServlet("/DeleteCoinServlet")
public class DeleteCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			int coinId=Integer.parseInt(request.getParameter("coinId"));
			CoinDAO coinDAO=new CoinDAO();
			if(coinDAO.deleteCoin(coinId)>0) {
				
				System.out.println("+++++++++++"+coinId);
				out.println("<html><head><title> Delete Coin</title></head>");
				out.println("<body>");
				out.println("<h1 style='color:green'>Coin Deleted Successfully</h1>");
				out.println("<a href='Index.html'> Add Another Coin </a><br>");
				//Display
				out.println("<a href='/Coin_Collection/DisplayAllCoins'> See All Coins</a>");
				out.println("</body></html>");

				
				//to Direct jump on home page 
				//response.sendRedirect("/Coin_Collection/DisplayAllCoins");
				
			}else {
				out.println("<html><head><title>Deleting  Coin</title></head>");
				out.println("<body>");
				out.println("<h1 style='color:red'>Error While Deleting a Coin</h1>");
				out.println("<a href='Index.html'> Back To Home</a>");
				out.println("</body></html>");
			}
			
		} catch (NumberFormatException e) {
			
			//error
			out.println("<html><head><title>Deleting a ing Coin</title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Error While Deleting Coin</h1>");
			out.println("<a href='Index.html'> Try Adding Coin</a>");
			out.println("<p>Error:"+e.getMessage()+"</p>");
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
