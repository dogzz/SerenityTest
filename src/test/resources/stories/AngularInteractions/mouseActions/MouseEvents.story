Meta:
@issue ST-04
Narrative:
As a tester
I want to perform different mouse action
So that I can test different RichUI capabilities

!--Scenario: double click
!--Meta:
!--@issue DFCT-1923
!--Given a mouse event is open
!--When I double click on DoubleClickShape element
!--Then result is DOUBLE-CLICKED
!--
!--Scenario: mouse move
!--Given a mouse event is open
!--When I move mouse over MouseMoveShape element with <x>, <y> coordinates
!--Then <x>, <y> coordinates are displayed in MOUSE MOVE RESULT
!--Examples:
!--|x|y|
!--|1|1|
!--|23|56|
!--|99|99|