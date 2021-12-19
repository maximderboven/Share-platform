Feature: ontlening met annulatie door uitlener
  ontlening annuleren


  Background:

    Given today is "2019-12-15"

    Given Users
      | naam     | sp   |
      | Eveline  | 1000 |
      | Albert   | 870  |
      | Diederik | 1000 |

    Given Waarborgen
      | name               | value |
      | Keukengereedschap  | 60    |
      | Tuingereedschap    | 50    |
      | Bouwgereedschap    | 40    |
      | Geluidsinstallatie | 400   |
      | Lichtinstallatie   | 150   |
      | Werkkleding        | 5     |

    Given Tools
      | name               | sp  | type               | aanbieder |
      | Kettingzaag        | 10  | Tuingereedschap    | Eveline   |
      | Kettingzaag2       | 10  | Tuingereedschap    | Eveline   |
      | Klopboormachine    | 10  | Bouwgereedschap    | Eveline   |
      | Keukenrobot        | 15  | Keukengereedschap  | Eveline   |
      | PA Seismic         | 200 | Geluidsinstallatie | Albert    |
      | Black Strobo Magic | 50  | Lichtinstallatie   | Albert    |
      | Zaagbroek          | 2   | Werkkleding        | Eveline   |
      | Veiligheidshelm    | 1   | Werkkleding        | Eveline   |

    Given JoinedTools
      | name    | tools                                 | type            | aanbieder |
      | ZaagKit | Kettingzaag:Zaagbroek:Veiligheidshelm | Tuingereedschap | Eveline   |

    Given Reservations
      | naam  | aanbieder | ontlener | gereedschap  | van        | dagen |
      | Res10 | Albert    | Evelien  | PA Seismic   | 2019-12-30 | 2     |
      | Res1  | Eveline   | Diederik | Zaagkit      | 2019-12-15 | 3     |
      | Res2  | Eveline   | Diederik | Kettingzaag2 | 2019-12-15 | 4     |
      | Res3  | Eveline   | Diederik | Keukenrobot  | 2019-12-17 | 2     |
      | Res4  | Albert    | Diederik | PA Seismic   | 2019-12-15 | 2     |

  Scenario: Ontlening annuleren
    When "Eveline" aangeeft dat "Diederik" "Res1" wil ophalen
    And "Eveline" aangeeft dat "Eveline" "Res2" wil annuleren
    And "Eveline" bevestigd de afhaling
    Then Er wordt een afhalingtransactie aangemaakt
    And Er wordt een transactielijn gemaakt voor de ontlening van "Res1" met een prijs van 39 SP
    And Er wordt een transactielijn gemaakt voor de waarborg van "Res1" met een prijs van 50 SP
    And Er wordt een transactielijn gemaakt voor annulatie van "Res2" met een prijs van -4 SP
    And heeft "Diederik" 915 SP
    And heeft "Eveline" 1085 SP
