package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CoinDAO;
import com.constant.GenericConstant;
import com.model.Coin;

/**
 * Servlet implementation class UpdateCoinServlet
 */
@WebServlet("/UpdateCoinServlet")
public class UpdateCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCoinServlet() {
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
	
		System.out.println("update123"+request.getParameter("id"));
		//First change the content of response into HTML Type
		response.setContentType("text/html");
		//create input output stream to print on wedSite like sysout
		PrintWriter out=response.getWriter();
				
		try {
		int id=Integer.parseInt(request.getParameter("coinId"));
		String country=request.getParameter("country");
		String  denomination=request.getParameter("denomination");
		int yearOfMinting=Integer.parseInt(request.getParameter("yearOfMinting"));
		BigDecimal currentValue=new BigDecimal(request.getParameter("currentValue")); 
		Date acquiredDate=new Date();
		acquiredDate=new SimpleDateFormat(GenericConstant.requiredDateFormat).parse(request.getParameter("acquiredDate"));
		
		Coin coin=new Coin(id,country, denomination, yearOfMinting, currentValue, acquiredDate);
	
		CoinDAO coinDAO=new CoinDAO();
		if(coinDAO.updateCoin(coin)>0){
			//success
			out.println("<html><head><title>Updating Coin</title></head>");
			out.println("<body>");
			out.println("<h1 style='color:green'>Coin Updated Successfully</h1>");
			out.println("<p>Country :"+coin.getCountry()+"</p>");
			out.println("<p>Denomination :"+coin.getDenomination()+"</p>");
			out.println("<p>Year Of Minting :"+coin.getYearOfMinting()+"</p>");
			out.println("<p>Current value :"+coin.getCurretntvValue()+"</p>");
			out.println("<p>Aquired date :"+coin.getAcquiredDate()+"</p>");
			out.println("<a href='Index.html'> Back To Home </a><br>");
			
			//Display
			out.println("<a href='/Coin_Collection/DisplayAllCoins'> See All Coins</a>");
			out.println("</body></html>");

		}else {
			
			out.println("<html><head><title>Updating Coin</title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Coin Not updated Successfully</h1>");
			out.println("<a href='Index.html'> Back To Home</a>");
			out.println("</body></html>");

		}
		
		
		
		
		} catch (ParseException|NumberFormatException e) {
			e.printStackTrace();
			
			//error
			out.println("<html><head><title>Updating Coin</title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Error While Updating Coin</h1>");
			out.println("<a href='Index.html'> Back To Home</a>");
			out.println("<p>Error:"+e.getMessage()+"</p>");
			out.println("</body></html>");

		}

	}

}
