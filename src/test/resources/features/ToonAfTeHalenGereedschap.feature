Feature: Toon af te halen gereedschap
  Reservatie lijsten updaten

  Scenario: Toon af te halen gereedschap
    Given today is "15/12/2021"
    When "Eveline" aangeeft dat "Diederik" zijn reservaties wil ophalen
    Then wordt een lijst met 2 reservaties getoond
    And bevat de lijst "Res1"
    And bevat de lijst "Res2"