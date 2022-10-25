Feature: DataCollectionTest
  Scenario: Go to Amazon website and find a macbook to collect data to save on a txt file

    Given Reach the Amazon and verify it
    And Choose the category
    And Write the wanted product
    And Do searching
    And Click on the very first product
    When Collect the data from product and save the data
    Then Verify the success message

