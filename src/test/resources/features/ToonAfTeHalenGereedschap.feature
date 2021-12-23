Feature: Toon af te halen gereedschap
  Reservatie lijsten ophalen

  Background:

    Given today is "2019-12-15"

    Given Users
      | naam     | sp   |
      | Evelien  | 1000 |
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
      | Zaagkit | Kettingzaag:Zaagbroek:Veiligheidshelm | Tuingereedschap | Eveline   |

    Given Reservations
      | naam  | aanbieder | ontlener | gereedschap  | van        | dagen |
      | Res10 | Albert    | Evelien  | PA Seismic   | 2019-12-30 | 2     |
      | Res1  | Eveline   | Diederik | Zaagkit      | 2019-12-15 | 3     |
      | Res2  | Eveline   | Diederik | Kettingzaag2 | 2019-12-15 | 4     |
      | Res3  | Eveline   | Diederik | Keukenrobot  | 2019-12-17 | 2     |
      | Res4  | Albert    | Diederik | PA Seismic   | 2019-12-15 | 2     |

  Scenario: Toon af te halen gereedschap
    When "Eveline" aangeeft dat "Diederik" zijn reservaties wil ophalen
    Then wordt een lijst met 2 reservaties getoond
    And bevat de lijst "Res1"
    And bevat de lijst "Res2"