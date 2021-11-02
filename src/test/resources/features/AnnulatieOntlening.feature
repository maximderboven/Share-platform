Feature: ontlening met annulatie door uitlener
  ontlening annuleren

  Scenario: Ontlening annuleren
    Given today is "15-12-2019"
    When "Eveline" aangeeft dat "Diederik" "Res1" wil ophalen
    And "Eveline" aangeeft dat "Eveline" "Res2" wil annuleren
    Then Er wordt een afhalingtransactie aangemaakt
    And Er wordt een transactielijn gemaakt voor de onlening van "Res1" met een prijs van 30 SP
    And Er wordt een transactielijn gemaakt voor de waarborg van "Res1" met een prijs van 40 SP
    And Er wordt een transactielijn gemaakt voor annulatie van "Res2" met een prijs van -4 SP
    And heeft "Diederik" 934 SP
    And heeft "Eveline" 1066 SP