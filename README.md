# Minigame2
This is a smaller version of what will ultimately be my final deliverable game. The submachine package contains 5 other packages:

1) globals
  - a seperate package that contains the enumerated class "Direction" to put name tags on certain integer values
2) SubmachineRooms
  - contains text files of descriptions of the various rooms in submachine (this package is not used)
3) SubmachineObjects
  - contains the classes of all the different objects in submachine with the superclass "Thing" being the parent class of all others
4) SubmachineGame
  - contains the "game" class that provides the variables of a submachine game as well as the different methods used
5) SubmachineMain
  - contains the test class called "main" that calls the "game" class and runs a game of Submachine

In Submachine, the player has an inventory system with different methods to either store or drop items and retrieve item information.
The player also has a navigation system in which the player can move in any of 6 directions. By exploring the map using the room and item descriptions and the list of commands available to the player, the user can beat Submachine if they are able to find the key and return to the starting room. There are several ways a player's game can end: meeting the spiders before taking a weapon, by choosing not to free the prisoner, or by entering 'q' at any moment.

Ultimately, the game will expand in rooms, weapons, new combat system, and a puzzle system. For now, enjoy this beta version of Submachine!
