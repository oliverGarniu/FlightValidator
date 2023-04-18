### Flight Distance Limitation Calculator

> Instructions

* The aim of the exercise is to demonstrate your skills in understanding and solving the stated problem, demonstrating coding quality, structure, style of the deliverables and use of best practices

* Input parameters can be command line, text file, JSON, …

> Requirements/ Specification
> 
Create an application that validates if a flight is feasible or not, having the flight plan as input;
* Flight Number 
* Time of take off 
* Number of passengers 
* Departure and arrival location (latitude, longitude)

> There are currently 2 rules the flight must comply with, but keep in mind that this may change in the future. If one rule fails then the flight is not feasible. Feedback should be given to the user with the results of evaluating the rules.

* **RULE 1**:
The maximum flight range of the airplane is 12.000 km, however, the number of passengers reduces this flight range. If the flight has more than 250 passengers then it can travel a maximum of 8.000 km.

* **RULE 2**:
Flights taking off after 2:00 pm can only travel 9.000 km. And there shall be no take-offs after 8:00 pm.
