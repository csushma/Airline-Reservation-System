package airlinereservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import airlinereservation.bean.FlightList;
import airlinereservation.bean.FlightList1;
import airlinereservation.bean.FlightList2;

public class FlightSearchDAO {
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

	public List<FlightList> flightSearch(String dep_airport_code, String arr_airport_code) throws Exception {
		// TODO Auto-generated method stub
		List<FlightList> flightList = new ArrayList<FlightList>();
		try{
			Connection conn=getSQLConnection();
			String query ="select * from FLIGHT where Departure_airport_code = ? and Arrival_airport_code = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, dep_airport_code);
			stmt.setString(2, arr_airport_code);
			
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				Time sqlScheduledDeparture = result.getTime("Scheduled_departure_time");
				Time sqlScheduledArrival = result.getTime("Scheduled_arrival_time");
				String sqlFlightNumber = result.getString("Flight_number");
				String sqlAirline = result.getString("Airline");
				String sqlWeekdays = "";
				System.out.println("Flight Number="+sqlFlightNumber);
				
				byte[] weekdayBytes=result.getBytes("Weekdays");
				
				if(weekdayBytes.length >0){
				byte weekDayByte=weekdayBytes[0];	
				
				sqlWeekdays=getWeekdayList(weekDayByte);
				System.out.println("Weekday ="+sqlWeekdays);
				}
				
				FlightList flightDetails = new FlightList(sqlFlightNumber, sqlAirline,sqlWeekdays,dep_airport_code, sqlScheduledDeparture,arr_airport_code,sqlScheduledArrival);
				flightList.add(flightDetails);
				System.out.println();
        	}

        if(flightList.isEmpty())
        {
        	throw new Exception("Sorry!!! no records found");
        }
        result.close();
        conn.close();
        System.out.println("Success!!");
	}catch(Exception e){
		throw e;
	}
	return flightList;
}
	
	public List<FlightList1>flightSearch1(String depAirport,String arrAirport,int noStops) throws Exception
	{
		List<FlightList1> flightListWeek1= new ArrayList<FlightList1>();
		try {
		Connection connection = getSQLConnection();
		String query="select A.Flight_number,A.Airline,A.Departure_airport_code,A.Scheduled_departure_time,A.Arrival_airport_code,"
				+" A.Scheduled_arrival_time,B.Flight_number,B.Scheduled_departure_time,B.Arrival_airport_code,B.Scheduled_arrival_time,"
				+ " A.Weekdays, B.Weekdays from FLIGHT A inner join Flight B on A.Arrival_airport_code=B.Departure_airport_code "
				+ " where  (B.Scheduled_departure_time-A.Scheduled_arrival_time)>1 AND (A.Weekdays&B.Weekdays)!=0 and A.Airline=B.Airline "
				+ " and A.Departure_airport_code=? and B.Arrival_airport_code=?";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1,depAirport);
		statement.setString(2,arrAirport);
	    ResultSet result = statement.executeQuery();
	    while(result.next())
	    {
	    	String sqlflightno=result.getString("A.Flight_number");
	    	String sqlairline=result.getString("A.Airline");
	    	String sqldepcode=result.getString("A.Departure_airport_code");
	    	Time sqldeptime=result.getTime("A.Scheduled_departure_time");
	    	String sqlarrcode1=result.getString("A.Arrival_airport_code");
	    	Time sqlarrtime1=result.getTime("A.Scheduled_arrival_time");
	    	String sqlflightno1=result.getString("B.Flight_number");
	    	Time sqldeptime1=result.getTime("B.Scheduled_departure_time");
	    	String sqlarrcode=result.getString("B.Arrival_airport_code");
	    	Time sqlarrtime=result.getTime("B.Scheduled_arrival_time");
	    	
	    	byte[] weekdayBytes=result.getBytes("A.Weekdays");
	    	byte[] weekdayBytes1=result.getBytes("B.Weekdays");
	    	byte test = (byte) (weekdayBytes[0] & weekdayBytes1[0]);
	    	String sqlwdays="";
	    	if(weekdayBytes.length >0){	
	    		sqlwdays=getWeekdayList(test);
	    		}

	    	FlightList1 flight=new FlightList1(sqlflightno,sqlairline,sqldepcode,sqldeptime,sqlarrcode1,sqlarrtime1,sqlflightno1,sqldeptime1,sqlarrcode,sqlarrtime,sqlwdays);
	    	flightListWeek1.add(flight);
	        System.out.println();
	    }
	    if(flightListWeek1.isEmpty())
	    {
	    	throw new Exception("No Data Found");
	    	
	    }
	    result.close();
		connection.close();
	    System.out.println("Success!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightListWeek1;
		
	}
	
	public List<FlightList2> flightSearch2(String depAirport, String arrAirport, int noStops) throws Exception {
		// TODO Auto-generated method stub
		List<FlightList2> flightList2= new ArrayList<FlightList2>();
		try {
		Connection connection = getSQLConnection();
		String query="select A.Flight_number,A.Airline,A.Departure_airport_code,A.Scheduled_departure_time,A.Arrival_airport_code,"
				+" A.Scheduled_arrival_time,B.Flight_number,B.Scheduled_departure_time,B.Arrival_airport_code,B.Scheduled_arrival_time,"
				+ " C.Flight_number,C.Scheduled_departure_time,C.Arrival_airport_code,C.Scheduled_arrival_time, A.Weekdays, B.Weekdays, C.Weekdays"
				+ " from FLIGHT A inner join Flight B on A.Arrival_airport_code=B.Departure_airport_code"
				+ " inner join FLIGHT C ON B.Arrival_airport_code=C.Departure_airport_code"
				+ " where  (B.Scheduled_departure_time - A.Scheduled_arrival_time)>1 and (C.Scheduled_departure_time - B.Scheduled_arrival_time)>1"
				+ " and (A.Weekdays&B.Weekdays&C.Weekdays)!=0 and "
				+ " A.Airline=B.Airline and B.Airline=C.Airline and A.Departure_airport_code=? and C.Arrival_airport_code=?";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1,depAirport);
		statement.setString(2,arrAirport);
	    ResultSet result = statement.executeQuery();
	    while(result.next())
	    {
	    	String sqlflightno=result.getString("A.Flight_number");
	    	String sqlairline=result.getString("A.Airline");
	    	
	    	String sqldepcode=result.getString("A.Departure_airport_code");
	    	Time sqldeptime=result.getTime("A.Scheduled_departure_time");
	    	
	    	String sqlarrcode1=result.getString("A.Arrival_airport_code");
	    	Time sqlarrtime1=result.getTime("A.Scheduled_arrival_time");
	    	String sqlflightno1=result.getString("B.Flight_number");
	    	Time sqldeptime1=result.getTime("B.Scheduled_departure_time");
	    	String sqlarrcode2=result.getString("B.Arrival_airport_code");
	    	Time sqlarrtime2=result.getTime("B.Scheduled_arrival_time");
	    	String sqlflightno2=result.getString("C.Flight_number");
	    	Time sqldeptime2=result.getTime("C.Scheduled_departure_time");
	    	
	    	String sqlarrcode=result.getString("C.Arrival_airport_code");
	    	Time sqlarrtime=result.getTime("C.Scheduled_arrival_time");
	    	
	    	byte[] weekdayBytes=result.getBytes("A.Weekdays");
	    	byte[] weekdayBytes1=result.getBytes("B.Weekdays");
	    	byte[] weekdayBytes2=result.getBytes("C.Weekdays");
	    	String sqlwdays="";
	    	byte test = (byte) (weekdayBytes[0] & weekdayBytes1[0] & weekdayBytes2[0]);
	    	if(weekdayBytes.length >0){	
	    		sqlwdays=getWeekdayList(test);
	    		}
	    	FlightList2 flight=new FlightList2(sqlflightno,sqlairline,sqldepcode,sqldeptime,sqlarrcode1,
	    			sqlarrtime1,sqlflightno1,sqldeptime1,sqlarrcode2,sqlarrtime2, sqlflightno2, sqldeptime2, sqlarrcode,sqlarrtime,sqlwdays);
	    	flightList2.add(flight);
	        System.out.println();
	    }
	    if(flightList2.isEmpty())
	    {
	    	throw new Exception("No Data Found");
	    	
	    }
	    result.close();
		connection.close();
	    System.out.println("Success!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightList2;
	}

	public String getWeekdayList(byte weekDays){

		String weekDayStr="";
		byte SAT=Byte.parseByte("00000001", 2);
		byte FRI=Byte.parseByte("00000010", 2);
		byte THU=Byte.parseByte("00000100", 2);
		byte WED=Byte.parseByte("00001000", 2);
		byte TUE=Byte.parseByte("00010000", 2);
		byte MON=Byte.parseByte("00100000", 2);
		byte SUN=Byte.parseByte("01000000", 2);
		
		if((weekDays&SUN)!=0){
			weekDayStr+=" Su";
		}
		
		if((weekDays&MON)!=0){
			weekDayStr+=" Mo";
		}
		if((weekDays&TUE)!=0){
			weekDayStr+=" Tu";
		}
		if((weekDays&WED)!=0){
			weekDayStr+=" We";
		}
		if((weekDays&THU)!=0){
			weekDayStr+=" Th";
		}
		if((weekDays&FRI)!=0){
			weekDayStr+=" Fr";
		}
		if((weekDays&SAT)!=0){
			weekDayStr+=" Sa";
		}
		
		return weekDayStr;
	}

}
