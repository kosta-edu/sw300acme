Feature: Make a Course Schedule

  Scenario: 1.new class schedule
    Given login as "OperationTeamMember"
    And initate "clazzRepo" 
    
    When select a "SW300 Intensive" Course
    And new class scheduling with:
    | filed         | entered_value |
    | StartTime     | 20190701      |
    | EndTime       | 20190705      |
    | Instructor    | 박준성        |
    | Venu          | 판교 강의실1   |
    Then status of ID 1 class is "scheduled"

  Scenario: 2.modify class instructor
    When select a ID 1 class
    And modify class scheduling with:
    | filed         | entered_value |
    | Instructor    | 황상철        |
    Then status of ID 1 class is "schedule changed"
    And instructor is "황상철"

  Scenario: 3.modify class venu
    When select a ID 1 class
    And modify class scheduling with:
    | filed         | entered_value |
    | Venu          | 판교 강의실5   |
    Then status of ID 1 class is "schedule changed"
    And venu is "판교 강의실5"

    Scenario: 4.fail to new class schedule
    When select a "SW300 Intensive" Course
    And new class scheduling with:
    | filed         | entered_value |
    | StartTime     | 20190701      |
    | EndTime       | 20190705      |
    | Instructor    | 김민숙        |
    | Venu          | 판교 강의실1   |
    Then fail to modify class schedule
    And instructor is "황상철"
    And venu is "판교 강의실5"