Feature: ontlening met annulatie door uitlener
  ontlening annuleren


  Background:
    Given Tools
      | name               | sp  | type       | waarborg |
      | Kettingzaag        | 10  | Elektrisch | 40       |
      | Kettingzaag2       | 10  | Elektrisch | 40       |
      | Klopboormachine    | 10  | Elektrisch | 40       |
      | Keukenrobot        | 15  | Keuken     | 60       |
      | PA Seismic         | 200 | Geluid     | 400      |
      | Black Strobo Magic | 50  | Licht      | 150      |

    Given Users
      | name     | sp   |
      | Evelien  | 1000 |
      | Diederik | 1000 |

    Given Reservations
      | name  | owner    | borrower | lendable     | begindate  | dayduration |
      | Res10 | Diederik | Evelien  | PA Seismic   | 30-12-2012 | 2           |
      | Res1  | Evelien  | Diederik | Kettingzaag  | 15-12-2021 | 3           |
      | Res2  | Evelien  | Diederik | Kettingzaag2 | 15-12-2021 | 4           |
      | Res3  | Evelien  | Diederik | Keukenrobot  | 17-12-2021 | 2           |

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