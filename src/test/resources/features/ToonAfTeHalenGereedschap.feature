Feature: Toon af te halen gereedschap
  Reservatie lijsten updaten

  Background:
    Given Tools
      | naam               | sp  | type       |
      | Kettingzaag        | 10  | Elektrisch |
      | Kettingzaag2       | 10  | Elektrisch |
      | Klopboormachine    | 10  | Elektrisch |
      | Keukenrobot        | 15  | Keuken     |
      | PA Seismic         | 200 | Geluid     |
      | Black Strobo Magic | 50  | Licht      |

    Given Users
      | naam     | sp   |
      | Evelien  | 1000 |
      | Diederik | 1000 |

    Given Reservations
      | naam  | aanbieder | ontlener | gereedschap  | van        | dagen |
      | Res10 | Diederik  | Evelien  | PA Seismic   | 2021-12-30 | 2     |
      | Res1  | Evelien   | Diederik | Kettingzaag  | 2021-12-15 | 3     |
      | Res2  | Evelien   | Diederik | Kettingzaag2 | 2021-12-15 | 4     |
      | Res3  | Evelien   | Diederik | Keukenrobot  | 2021-12-17 | 2     |


  Scenario: Toon af te halen gereedschap
    Given today is "15/12/2021"
    When "Eveline" aangeeft dat "Diederik" zijn reservaties wil ophalen
    Then wordt een lijst met 2 reservaties getoond
    And bevat de lijst "Res1"
    And bevat de lijst "Res2"