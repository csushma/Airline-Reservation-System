package airlinereservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import airlinereservation.bean.FareList;

public class FareSearchDAO {
	private Connection getSQLConnection()
	{
		Connection connection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public List<FareList> fareSearch(String flight_number) throws Exception {
		// TODO Auto-generated method stub
		List<FareList> fareList = new ArrayList<FareList>();
		try{
			Connection conn=getSQLConnection();
			String query ="select Fare_code, Amount, Restrictions from FARE where Flight_number = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			if(!flight_number.isEmpty()){
				stmt.setString(1, flight_number);
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String sqlfare_code = rs.getString("Fare_code");
				float sqlamount = rs.getFloat("Amount");
				String sqlres = rs.getString("Restrictions");
				FareList fare = new FareList(sqlfare_code, sqlamount,sqlres);
            	fareList.add(fare);
                System.out.println();
            } 
            if(fareList.isEmpty())
            {
            	throw new Exception("Sorry!!! no records found");
            }
            rs.close();
            conn.close();
            System.out.println("Success!!");
		}catch(Exception e){
			throw e;
		}
		return fareList;
	}

}
