# Air Traffic Control System

Creating a simplified air traffic control (ATC) sistem which allow user to add airplains and control them.

## Use Case Diagram
![Exercise 1 image](docs/UseCaseDiagram1.jpg)

## Aircraft State Machine Diagram
![Exercise 2 image](docs/StatechartDiagram1.jpg)

## ATC Class Diagram
![Exercise 1 image](docs/ClassDiagram1.jpg)

## Requirements

- When added aircraft is in On Stand state. In this state airplain is waiting for a comand from ATC;
- When aircraft receives takeoff command will go into Taxing state and will stay there for 10 seconds; 
- From Taxing aircraft will go into Taking off state and will stay there for 5 seconds;
- Take off command contains cruising altitude for the aircraft;
- Aircraft will stay in Ascending state till aircraft reach cruising altitude. Altitude is given by ATC in 1.000 meters increments and needs 10 seconds for each increment. Example: altitude 3 = means aircraft cruising altitude is 3.000 meters and will need 30 seconds to reach that altitude;
- Aircraft can receive land command only when is at cruising altitude;
- Descending will be done in 1.000 meters increments;
- When aircraft has reached altitude 0 is considered landed;
- Aircraft will keep track of number of seconds spent in "Cruising" state and will display it after it landed;

## Implementation details

- User interaction is done through a console based user interface. 
- Aircraft objects are implemented as threads;
- After aircraft land the thread will be finished;
- Wait()\notify() mechanism are used in order to implement mechanism for aircraft to wait for ATC command; 
