# TicTacToe-AI-Advanced
This project is an implementation of an `TicTacToe` game using `Java` and `Java swing` where the user has the option to play with a friend or the computer. The project can also be customized to function for more than 3 grib by grid as the user wish (it is not available on my gitHub but you can email me: a description will be down below for how it is approached). 

## TicTacToeIn.java:
In this java file is where most of all the functions and sub classes run. 

 ```c
 void InterfaceSetup(){ ........ }
 ```

This function setup the interface using Java swing just as setting up frame, Layout, and Font. In addition, it takes the yser decision in either playing with a friend or computer.

 ```c
  public void launchgame() { ......... }
 ```
 
 This function launches the game where it generates a number randomly where decides which player starts first
 
 ```c
 public void WinnerX(int x, int y, int z) { ........... }
 public void WinnerO(int x, int y, int z) { ........... }
 ```
 
 These functions is called when a winner is called out using the `matchscore()` function where also the the buttons are disbaled and `gameover()` function is called.
 
 ```c
  matchscore() { .......... }
 ```
  
This function is called whenever any move is done by any of the players and checks if there is 9 entries or any three accepted patterns, and returns the coordinates of the pattern if its a win.

```c
public void gameover() { ......... }
```

This function shut down the frame and ask the user if he is willing to restart or exit.

```c
 public int ComputerChoice() { ......... }
```

This function utilizes the computer moves if chosen to play and retuns an integer which is an location with respect to the board for the `computerc()` function to input in the board, it works using 2 for loops where each column, row, and diagonal is first checked for the computer O's and then checks the opponent X's moves to prevent him from winning. At the start of the game, it also gives an random placement of the O as there is no sufficent information to expect the next move of the opponent using one or zero turns.

`An Example Scenario:`
```c
X ┃  ┃ X 
⎯⎯⎯⎯⎯⎯⎯⎯⎯
X ┃  ┃
⎯⎯⎯⎯⎯⎯⎯⎯⎯
O ┃  ┃ O
```
Here the function will place the O in the last row and not the first row as its first goal to win then defend.

```c
 public void computerc() { ......... }
```

This function what input the computer decision to the board where it gets the index to be placed from the `ComputerChoice()` function.
