package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CoinDAO;
import com.constant.GenericConstant;
import com.model.Coin;

/**
 * Servlet implementation class AddCoinServlet
 */
@WebServlet("/AddCoinServlet")
public class AddCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//First change the content of response into HTML Type
		response.setContentType("text/html");
		//create input output stream to print on wedSite like sysout
				PrintWriter out=response.getWriter();
				
		try {
		String country=request.getParameter("country");
		String  denomination=request.getParameter("denomination");
		int yearOfMinting=Integer.parseInt(request.getParameter("yearOfMinting"));
		BigDecimal currentValue=new BigDecimal(request.getParameter("currentValue")); 
		Date acquiredDate=new Date();
		acquiredDate=new SimpleDateFormat(GenericConstant.requiredDateFormat).parse(request.getParameter("acquiredDate"));
		
		Coin coin=new Coin(country, denomination, yearOfMinting, currentValue, acquiredDate);
	
		CoinDAO coinDAO=new CoinDAO();
		if(coinDAO.addCoin(coin)>0){
			//success
			out.println("<html><head><title>Adding Coin</title></head>");
			out.println("<body>");
			out.println("<h1 style='color:green'>Coin Added Successfully</h1>");
			out.println("<p>Country :"+coin.getCountry()+"</p>");
			out.println("<p>Denomination :"+coin.getDenomination()+"</p>");
			out.println("<p>Year Of Minting :"+coin.getYearOfMinting()+"</p>");
			out.println("<p>Current value :"+coin.getCurretntvValue()+"</p>");
			out.println("<p>Aquired date :"+coin.getAcquiredDate()+"</p>");
			out.println("<a href='Index.html'> Add Another Coin </a><br>");
			
			//Display
			out.println("<a href='/Coin_Collection/DisplayAllCoins'> See All Coins</a>");
			out.println("</body></html>");

		}else {
			
			out.println("<html><head><title>Adding Coin</title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Coin Not Added Successfully</h1>");
			out.println("<a href='Index.html'> Try Adding Coin</a>");
			out.println("</body></html>");

		}
		
		
		
		
		} catch (ParseException|NumberFormatException e) {
			e.printStackTrace();
			
			//error
			out.println("<html><head><title>Adding Coin</title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Error While Adding Coin</h1>");
			out.println("<a href='Index.html'> Try Adding Coin</a>");
			out.println("<p>Error:"+e.getMessage()+"</p>");
			out.println("</body></html>");

		}

	}

}






