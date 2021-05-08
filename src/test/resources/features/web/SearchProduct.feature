@Web @Bukalapak @SearchProduct
Feature: User be able to search product

  Background:
    Given user open bukalapak homepage

  @Exisiting-product
  Scenario Outline: User be able to search existing product
    When user input existing product "<NAME>"
    Then user see search result product "<NAME>"

    Examples:
      | NAME                                        |
      | Helm KYT DJ Maru 16 - Matt All Grey - Black |
      | Nike Jordan Low Basket Premium              |
      | Monitor LED LG 24MP59G - 24 Inch            |