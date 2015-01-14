# DrawPoker, a group drawing game.
Please not that this application is dependent on KevinLibrary.  The referenced jar file is included within this repository, but the Kevin Library project page can be found [here](https://github.com/flipturnapps/FlipTurnApps-KevinLibrary/ "KevinLibrary repo").
##A quick introduction
This (soon to be quite large) java application will (when completed) run entirely locally on each individual machine involved within the game. The game uses some simple networking to allow multiple players (about 3-7) to play simultaneously. Eventually even Android devices could be used to play, however a separate application would have to be developed entirely. By reading further I hope you see a vision for this game and potentially will help me fully develop it.
##Proposed Gameplay
DrawPoker will consist of appoximately 3-7 players, a few game phases, and a scores for each player.
###Game Phases
####Drawing Phase
The game starts with a drawing phase. In this phase each player gets his or her own individual topic to draw. All players simultaneously draw during the time limit. All drawings are saved as image files on the server.
####Guessing Phase
The guessing phase has as many turns as there are players. In the first turn, one of the player's drawings (selected randomly) is displayed to the group. Each player individually votes (1) what he/she thinks the drawer was attempting to draw, and (2) which player he/she thinks drew the particular drawing. The player who drew the drawing in question will still guess, but the guess doesn't count for scroing. The game cycles through showing the other players' drawings in a random order, and all the players guess the subject and the drawer. Finally, the drawers and subjects of each drawing is revealed, and scores are tallied.
###Scoring
After the subjects and the drawers of the drawings are revealed, each player's score is affected according to the fallowing:
* Guessing the correct subject of a drawing earns both the guesser and the drawer +1 point.
* Guessing the correct drawer of a drawing lets the guesser steal 1 point from the drawer.
* If all players correctly guess the drawer, they each steal an extra 1 point from the drawer.

###Winning
After a preset number of complete rounds, the player with the most points wins.
##The code itself
###Networking Structure
In DrawPoker, the serverside will have no GUI, and take no user input. Yet depending on the playing setting of the players involved, the game can be set up one of two ways.
####Game Modes
#####Inidivual Screens
In this mode, each player views his or her own screen to see the drawings during the guessing phase and to see the score tallies after each round. Each player's individual screen is also used for drawing and guessing.
#####TV Mode
Here, a central screen (most likely a TV) will be visible to all players in the game. This is where the drawings during guessing phase and score modifications will appear for everyone to see. The players only use their individual screens for drawing and guessing.
####Client Types
Clients fall into certain categories, and the server treats them differently.
#####TV Client
This is only applicable in TV Mode, but because the server has no GUI and takes no input, a client can be initialized as a TV client, which cannot be an Admin client (see below). TV client is the type which is not a player in the game, its name cannot be set, cannot be admin, and has no score.
#####Admin
Admin is just like a normal client, is a player, has a configurable name/score, but also has special permissions. Admin configures game settings before the game starts, may approve other client's screen names, and has the permissions to kick clients.
#####Normal Client
A normal client is a regular player, has a configurable screen name and score, but has no special permissions. Most clients should fall under this category.
