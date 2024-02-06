package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CoinDAO;
import com.model.Coin;

/**
 * Servlet implementation class FetchToUpdate
 */
@WebServlet("/FetchToUpdate")
public class FetchToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchToUpdate() {
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
			Coin coinToUpdate=coinDAO.getById(coinId);
			
			out.println("<html><head><title> Fetching to Update Coin</title></head>");
			out.println("<body>");
			out.println("<h2 style='color:blue'>Update Coin Details</h1>");
			if(coinToUpdate!=null) {
				out.println("<form action='UpdateCoinServlet' method='post'>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<td><label> Coin ID : </label></td>");
				out.println("<td><input type='hidden' name='coinId' value="+coinToUpdate.getId()+"></td>");
				out.println("</tr>");
				out.println("<td><label> Country : </label></td>");
				out.println("<td><input type='text' name='country' value="+coinToUpdate.getCountry()+" required ></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label> Denomination : </label></td>");
				out.println("<td><input type='text' name='denomination' value="+coinToUpdate.getDenomination()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label> Year Of Minting : </label></td>");
				out.println("<td><input type='number' name='yearOfMinting' value="+coinToUpdate.getYearOfMinting()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label> Current Value : </label></td>");
				out.println("<td><input type='number' name='currentValue' value="+coinToUpdate.getCurretntvValue()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label> Acquired Date : </label></td>");
				out.println("<td><input type='date' name='acquiredDate' value="+coinToUpdate.getAcquiredDate()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><input type='submit' value='Update Coin'></td>");
				out.println("<td><a href='Index.html'>Back To Home </a></td>	");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");
				
				
				}else {
				out.println("<h1 style='color:red'>Error While Fetching to Update Coin</h1>");

				}
			
		} catch (NumberFormatException e) {
			
			//error
			out.println("<h1 style='color:red'>Error While Fetching to Update Coin</h1>");
			out.println("<p>Error:"+e.getMessage()+"</p>");
		}
		
		out.println("<a href='Index.html'> Back To Home </a><br>");
		//Display
		out.println("<a href='/Coin_Collection/DisplayAllCoins'> See All Coins</a>");
		out.println("</body></html>");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

}
