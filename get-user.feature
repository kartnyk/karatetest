Feature: Get user from JSONPlaceholder

  Scenario: Get user by ID
    Given url 'https://jsonplaceholder.typicode.com/users/1'
    When method get
    Then status 200
    And match response.id == 1
