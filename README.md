# UBS Test Service [![Build Status](https://travis-ci.org/sergiogoncalves/UBS_Project.svg?branch=master)](https://travis-ci.org/sergiogoncalves/UBS_Project)
You can to start application by executing com.ubs.UBSApplication, which starts a webserver on port 8080 (http://localhost:8080) and serves SwaggerUI where can inspect and try existing endpoints.

### The assignment

Requirements:

*	Design and implement supermarket checkout component with readable API that calculates the total price of a number of items.
*	Checkout mechanism can scan items and return actual price (is stateful)
*	Our goods are priced individually. In addition, some items are multi-priced: "buy n of them, and they’ll cost you y cents"


  |Item  | Unit Price |  Special Price |
  |:----:|-----------:|---------------:|
  |  A   |  40        | 3 for 70       |
  |  B   |  10        | 2 for 15       | 
  |  C   |  30        |                |
  |  D   |  25        |                |

We value:
*	simple, elegant code that reads like a narrative – don't overcomplicate
*	excellent testing that acts as documentation
*	challenging boundaries where necessary
 
Additional notes:
*	use maven or gradle build system
*	make task available on the public GitHub
*	if in doubt please document your design choice in README file


### The architecture 
 The architecture of the web service is built with the following components:
* DataTransferObjects: Objects which are used for outside communication via the API
* Controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.
* Service: Implements the business logic and handles the access to the DataAccessObjects.
* DataAccessObjects: Interface for the database. Inserts, updates, deletes and reads objects from the database.
* DomainObjects: Functional Objects which might be persisted in the database.
	
The project uses the following technologies:

* Java 8
* Spring MVC with Spring Boot
* Database H2 (In-Memory)
* Maven
* Spring Tool Suite as IDE is preferred but not mandatory. 
* TDD