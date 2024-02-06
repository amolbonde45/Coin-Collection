package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Coin;
import com.utility.Connectionutils;

public class CoinDAO {
	
	//get all coins method
	public List<Coin> getAllCoins(){
		
		//java 8--Type inference  {ArrayList<coin>}
		List<Coin> coins=new ArrayList<>();
		
		try (Connection connection=Connectionutils.getConnection()){
			
			String selectQuery="select * from coin_collection ";
			PreparedStatement statement= connection.prepareStatement(selectQuery);
			ResultSet resultSet=statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				Coin coin=new Coin(
						resultSet.getInt("id"),
						resultSet.getString("country"),
						resultSet.getString("denomination"),
						resultSet.getInt("year_of_minting"),
						resultSet.getBigDecimal("current_value"),
						resultSet.getDate("acquired_date")
						);
				//new coin-- add lis of coin
				coins.add(coin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();//handle properly in real time application
		}
		return coins;
	}
	
	
	//to get coins by id
	public Coin getById(int coinId){
		Coin coin=new Coin();
		try (Connection connection=Connectionutils.getConnection()){
			
			String selectQuery="select * from coin_collection where id = ?";
			PreparedStatement statement= connection.prepareStatement(selectQuery);
			statement.setInt(1, coinId);
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				coin.setId(resultSet.getInt("id"));
				coin.setCountry(resultSet.getString("country"));
				coin.setDenomination(resultSet.getString("denomination"));
				coin.setYearOfMinting(resultSet.getInt("year_of_minting"));
				coin.setCurretntvValue(resultSet.getBigDecimal("current_value"));
				coin.setAcquiredDate(resultSet.getDate("acquired_date"));
					/*Coin coin=new Coin(
						resultSet.getInt("id"),
						resultSet.getString("country"),
						resultSet.getString("denomination"),
						resultSet.getInt("year_of_minting"),
						resultSet.getBigDecimal("current_value"),
						resultSet.getDate("acquired_date")
						);*/
			}
			
		} catch (SQLException e) {
			e.printStackTrace();//handle properly in real time application
			coin=null;
		}
		return coin;
		}
	
	
	//Add coin in the database
	public int addCoin(Coin coin){
		
		try (Connection connection=Connectionutils.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into coin_collection( country, denomination,year_of_minting,current_value,acquired_date) values (?,?,?,?,?)")){
			preparedStatement.setString(1, coin.getCountry());
			preparedStatement.setString(2, coin.getDenomination());
			preparedStatement.setInt(3, coin.getYearOfMinting());
			preparedStatement.setBigDecimal(4, coin.getCurretntvValue());
			preparedStatement.setDate(5, (java.sql.Date) new Date(coin.getAcquiredDate().getTime()));
		
			//to execute the query and will show the affected rows in int and return int
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();//Handle properly in real time application
			
			return 0;
		}
		
	}
	
	public int updateCoin(Coin coin){
			int updatedRows=0;
			String updateQuery="update coin_collection set country=? ,denomination=?, year_of_minting=?,current_value=?,acquired_date=? where id=?";
			try (Connection connection=Connectionutils.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(updateQuery)){
				
				System.out.println("+++"+coin.getId());
				preparedStatement.setString(1, coin.getCountry());
				preparedStatement.setString(2, coin.getDenomination());
				preparedStatement.setInt(3, coin.getYearOfMinting());
				preparedStatement.setBigDecimal(4, coin.getCurretntvValue());
				preparedStatement.setDate(5, (java.sql.Date) new Date(coin.getAcquiredDate().getTime()));
				preparedStatement.setInt(6, coin.getId());
				
				//to execute the query and will show the affected rows in int and return int
				 updatedRows=preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();//Handle properly in real time application
				
				return 0;
			}
			return updatedRows;
		}
	
	//delete
	public int deleteCoin(int coinId) {
	
		int deleteRow=0;
		try (Connection connection=Connectionutils.getConnection()){
			
			String selectQuery="delete from coin_Collection where id=?";
			PreparedStatement statement= connection.prepareStatement(selectQuery);
			statement.setInt(1, coinId);
			deleteRow=statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();//handle properly in real time application
			return 0;
		}
		return deleteRow;

	}

}
