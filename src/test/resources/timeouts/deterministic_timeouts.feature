Feature:
  As a half decent software engineer
  I want my application to fail fast / timeout in deterministic ways in the face of network issues

  Background:
    Given I can control the network between the application and its dependency

  Scenario: Dropping all traffic
    Given the network between my application and its dependency is dropping all traffic
    When I make a request to my application
    Then my application times out

#  Scenario: Slowing down individual commits
#    Given the network between my application and its dependency is slow
#    When I make a request to my application
#    Then my application times out

