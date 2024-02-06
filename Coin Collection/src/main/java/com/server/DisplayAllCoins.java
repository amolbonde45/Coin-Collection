package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CoinDAO;
import com.model.Coin;

/**
 * Servlet implementation class DisplayAllCoins
 */
@WebServlet("/DisplayAllCoins")
public class DisplayAllCoins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllCoins() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//HTML Response
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		//retrieve
		CoinDAO coinDAO=new CoinDAO();
		List<Coin> allCoins=coinDAO.getAllCoins();
		
		out.println("<html><head><title>Adding Coin</title></head>");
		out.println("<body>");
		out.println("<h1 style='color:green'>All Coin Collection Data</h1>");
		out.println("<table border='1'>");
		out.println("<thead><tr><th>Coin ID</th><th>Country</th><th>Denomatation</th><th>Year Of Minting</th><th>Current Value</th><th>Acquired Date</th><th>UPDATE</th><th>REMOVE</th></tr></thead>");
		
		for(Coin coin : allCoins) {
		out.println("<tr>");
		out.println("<td>"+coin.getId()+"</td>");
		out.println("<td>"+coin.getCountry()+"</td>");
		out.println("<td>"+coin.getDenomination()+"</td>");
		out.println("<td>"+coin.getYearOfMinting()+"</td>");
		out.println("<td>"+coin.getCurretntvValue()+"</td>");
		out.println("<td>"+coin.getAcquiredDate()+"</td>");
		out.println("<td><a href='FetchToUpdate?coinId="+coin.getId()+"'>EDIT</td>");
		out.println("<td><a href='DeleteCoinServlet?coinId="+coin.getId()+"'>DELETE</td>");
		out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<br><br>");
		out.println("<a href='Index.html'>Back To Home</a>");
		out.println("</body></html>");
		
		
		
	} catch (Exception e) {
		//error
		out.println("<html><head><title>Display Coin</title></head>");
		out.println("<body>");
		out.println("<h1 style='color:red'>Error While Reteriveing Coin</h1>");
		out.println("<a href='Index.html'> Back To Home</a>");
		out.println("<p>Error :"+e.getMessage()+"</p>");
		out.println("</body></html>");

	}	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
