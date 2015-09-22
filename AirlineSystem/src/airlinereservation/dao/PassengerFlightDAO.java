package airlinereservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import airlinereservation.bean.Passenger_Flight;

public class PassengerFlightDAO {
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


	public List<Passenger_Flight> flightSearch(String customer_name) throws Exception {
		// TODO Auto-generated method stub
		List<Passenger_Flight> flightList = new ArrayList<Passenger_Flight>();
		try{
			Connection conn=getSQLConnection();
			String query ="select * from SEAT_RESERVATION where Customer_name = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			if(!customer_name.isEmpty()){
				stmt.setString(1, customer_name);
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String sqlflight_number = rs.getString("Flight_number");
				String sqldate = rs.getString("Date");
				String sqlseat_number = rs.getString("Seat_number");
				String sqlcustomer_name = rs.getString("Customer_name");
				String sqlcustomer_phone = rs.getString("Customer_phone");
				Passenger_Flight flight = new Passenger_Flight(sqlflight_number, sqldate, 
						sqlseat_number, sqlcustomer_name,sqlcustomer_phone);
				flightList.add(flight);
                System.out.println();
            } 
            if(flightList.isEmpty())
            {
            	throw new Exception("Sorry!!! no records found");
            }
            rs.close();
            conn.close();
            System.out.println("Success!!");
		}catch(Exception e){
			throw e;
		}
		return flightList;
	}
}
