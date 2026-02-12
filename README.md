Overview:
The Dispatch Load Balancer is a Java Spring Boot backend application that optimizes the allocation of delivery orders to a fleet of vehicles.

The optimization is based on:

-> Vehicle capacity constraints.

-> Order priority levels (HIGH, MEDIUM, LOW).

-> Travel distance minimization using the Haversine formula.

The system generates an optimized dispatch plan that ensures efficient vehicle utilization.

------------------------------------------------------x-----------------------------------------------

Features:

-> Priority-based order assignment

-> Capacity-aware load distribution

-> Distance-optimized dispatching

-> Unassigned order tracking

-> In-memory storage (no DB dependency)

-> RESTful API design

-> Input validation & structured error handling

-> Unit test coverage

------------------------------------------------------x-----------------------------------------------


Tech Stack:

-> Language: Java 17

-> Framework: Spring Boot

-> Build Tool: Maven

-> Testing: Junit

-> Api Testing: Postman

------------------------------------------------------x-----------------------------------------------

Project Setup:

1. Prerequisites:

Ensure the following are installed:

-> Java 17

-> Maven 3.8+

-> Postman (for Api testing)


2. Clone Repository:

git clone https://github.com/ashu9552975/Dispatch-load-balancer.git dispatch-load-balancer


3. Build & Run:

mvn clean install

mvn spring-boot:run

Default base Url:

http://localhost:8080

------------------------------------------------------x-----------------------------------------------

Dispatch Optimization Logic:

Orders are assigned based on the following rules:

1. Total vehicle load must not exceed capacity.

2. Orders are processed by priority:
     HIGH → MEDIUM → LOW

3. Vehicle selection is based on minimum Haversine distance from:

-> Current vehicle location OR

-> Last delivery stop

4. Orders that cannot be allocated appear in unassignedOrders.

------------------------------------------------------x-----------------------------------------------

Api Endpoints:

1. Submit Orders:

POST /api/dispatch/orders

Validations:

-> Orders list must not be empty

-> orderId required

-> packageWeight > 0

-> Valid priority enum

2. Submit Vehicles:

POST /api/dispatch/vehicles:

Validations:

-> Vehicles list must not be empty

-> capacity > 0

-> vehicleId required

3. Get Dispatch Plan:

GET /api/dispatch/plan

Response Fields

-->DispatchPlan:

Contains per-vehicle allocation:

->Vehicle details

->Total load

->Total route distance

->Assigned orders list

-->UnassignedOrders

Orders not allocated due to:

->Capacity overflow

->No available vehicle

------------------------------------------------------x-----------------------------------------------

API Testing via Postman:

Collection Setup:

-> Create a collection

Add requests:

1. Submit Orders:

-> Method: POST

-> URL: http://localhost:8080/api/dispatch/orders

-> copy and pasete the sample cURL form the attached text file "Api wise sample cURL_1.txt"

2. Submit Vehicles

-> Method: POST

-> URL: http://localhost:8080/api/dispatch/vehicles

-> copy and pasete the sample cURL form the attached text file "Api wise sample cURL_1.txt"

3. Get Dispatch Plan

-> Method: GET

-> URL: http://localhost:8080/api/dispatch/plan

-> copy and pasete the sample cURL form the attached text file "Api wise sample cURL_1.txt"

------------------------------------------------------x-----------------------------------------------

Storage Design: 

-> In-memory storage using ConcurrentHashMap

-> No external database

-> Data resets on application restart

------------------------------------------------------x-----------------------------------------------

Assumptions:

-> Assignment-scale data volume

-> Approximate distance calculation

-> Single depot-less dispatch model

-> No real-time traffic data

------------------------------------------------------x-----------------------------------------------
