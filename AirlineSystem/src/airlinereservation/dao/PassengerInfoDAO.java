package airlinereservation.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import airlinereservation.bean.PassList;

public class PassengerInfoDAO {
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


	public List<PassList> passSearch(String flight_number, Date date) throws Exception {
		// TODO Auto-generated method stub
		List<PassList> passList = new ArrayList<PassList>();
	    SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Connection conn=getSQLConnection();
			String query ="select Seat_number, Customer_name, Customer_phone from SEAT_RESERVATION where Flight_number = ? AND Date = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			if(!flight_number.isEmpty() && !(date.toString().isEmpty())){
				stmt.setString(1, flight_number);
				stmt.setString(2, dmyFormat.format(date));
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String sqlseat_number = rs.getString("Seat_number");
				String sqlcustomer_name = rs.getString("Customer_name");
				String sqlcustomer_phone = rs.getString("Customer_phone");
				PassList passengers = new PassList(sqlseat_number, sqlcustomer_name,sqlcustomer_phone);
            	passList.add(passengers);
                System.out.println();
            } 
            if(passList.isEmpty())
            {
            	throw new Exception("Sorry!!! no records found");
            }
            rs.close();
            conn.close();
            System.out.println("Success!!");
		}catch(Exception e){
			throw e;
		}
		return passList;
	}
}
