Feature: Toon af te halen gereedschap
  Reservatie lijsten updaten

  Background:
    Given Tools
      | name               | sp  | type       |
      | Kettingzaag        | 10  | Elektrisch |
      | Kettingzaag2       | 10  | Elektrisch |
      | Klopboormachine    | 10  | Elektrisch |
      | Keukenrobot        | 15  | Keuken     |
      | PA Seismic         | 200 | Geluid     |
      | Black Strobo Magic | 50  | Licht      |

  Scenario: Toon af te halen gereedschap
    Given today is "15/12/2021"
    When "Eveline" aangeeft dat "Diederik" zijn reservaties wil ophalen
    Then wordt een lijst met 2 reservaties getoond
    And bevat de lijst "Res1"
    And bevat de lijst "Res2"