package airlinereservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import airlinereservation.bean.AvailableSeats;


public class AvailableSeatsDAO {
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

	public int seatSearch(String flight_number, Date date) throws Exception {
		// TODO Auto-generated method stub
		int available_seats = 0;
	    SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Connection conn=getSQLConnection();
			String query ="Select A.Flight_number,A.Date,(B.Total_number_of_seats-(count(C.Seat_number))) 'Available_seats',A.Airplane_id,A.Departure_time,A.Arrival_time from "
					+ " Flight_Instance A inner join Airplane B on A.Airplane_id=B.Airplane_id"
					+ " inner join Seat_reservation C on A.Flight_number=C.Flight_number and A.Date=C.Date  where A.Flight_number=? and A.Date=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			if(!flight_number.isEmpty() && date != null){
				stmt.setString(1, flight_number);
				stmt.setString(2, dmyFormat.format(date));
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int sqlseat_numbers = rs.getInt("Available_seats");
				AvailableSeats availableseats = new AvailableSeats(sqlseat_numbers);
				available_seats = availableseats.getAvailable_seats();
                System.out.println(available_seats);
            } 
            if(available_seats == 0)
            {
            	throw new Exception("Sorry!!! no records found");
            }
            rs.close();
            conn.close();
            System.out.println("Success!!");
		}catch(Exception e){
			throw e;
		}
		return available_seats;
	}
	/*
	public boolean isValidDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String errorMessage;
		Date testDate = null;
		try{
			testDate = sdf.parse(date);
			
		}catch(ParseException e){
			errorMessage = "date is invalid";
			return false;
		}
		
		 if (!sdf.format(testDate).equals(date))
		 {	 
			       errorMessage = "The date that you provided is invalid."; 
			       return false; 
		  }

		return true;	
	}
*/
}
