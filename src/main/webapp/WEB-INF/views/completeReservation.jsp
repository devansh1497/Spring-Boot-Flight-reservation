<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
</head>
<body>
<h2>Complete Reservation...</h2>
Airline : ${flight.operatingAirlines}<br/>
Departure City : ${flight.departureCity}<br/>
Arrival City : ${flight.arrivalCity}<br/>

<form action="completeReservation" method="post">
	<pre>
	<h2>Passenger Details:</h2>
	First name: <input type="text" name="passengerFirstName"/>
	Last name: <input type="text" name="passengerLastName"/>
	Email: <input type="text" name="passengerEmail"/>
	Phone: <input type="text" name="passengerPhone"/>
	
	<h2>Card details:</h2>
	Name on the card: <input type="text" name="nameOnTheCard"/>
	Card No: <input type="text" name="cardNo"/>
	Expiry Date: <input type="text" name="expiryDate"/>
	CVV: <input type="password" name="cvv"/>
	<input type="hidden" name="flightId" value="${flight.id}"/>
	<input type="submit" value="Confirm"/>
	</pre>
</form>
</body>
</html>