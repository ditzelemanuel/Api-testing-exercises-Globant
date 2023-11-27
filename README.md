# Star Wars API Testing - Globant Course

This repository showcases comprehensive API testing exercises completed as part of a course offered by Globant.

## Features

- Java-based API testing using RestAssured
- TestNG test suite covering various scenarios
- Comprehensive validation of Star Wars API endpoints

## Test Scenarios
  
- Test People Endpoint
Validate the success response for the endpoint people/2/.
Check the skin color to be gold and the appearance in 6 films.

- Test Second Movie for People
Request the endpoint of the second movie in which people/2/ was present.
Validate the release date format and response elements.

- Test First Planet in Last Film
Get the first planet in the last film from the previous response.
Check gravity and terrains matching exact values using fixtures.

- Test Planet URL Match
Grab the URL element from the planet response.
Request the URL and validate the response is exactly the same.

- Test Film Not Found
Request the non-existent endpoint /films/7/.
Check that the response has a 404 status code.

## How to Use

1. Clone the repository locally. (https://github.com/ditzelemanuel/Api-testing-exercises-Globant)
2. Import the project into your preferred Java IDE.
3. Run the test suite to observe the API testing scenarios:
Open a terminal in your project's root directory and run the following Maven command: mvn clean test
