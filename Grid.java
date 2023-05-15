package Cellsht;

public class Grid {
    Cell[][] world;
    private int generation;
    private int population;
    

    public Grid(int r, int c) {
      // initialize 2D array of Cell objects
      world = new Cell[r][c];
  
      // default values
      this.generation = 1;
      this.population = 0;
  
      // TO DO: SETUP THE FIRST GENERATION 
      // visit each location in the 2D array to do the following:
      // randomly generate a living cell in each row/col 
      // with a 25% chance of being alive to start
  
      for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                int result = (int)(Math.random() * (100 - 1) + 1);
                if (result <= 9) {
                  Cell cellAlive = new Cell(true);
                  world[i][j] = cellAlive;
                } else {
                  Cell cellDead = new Cell(false);
                  world[i][j] = cellDead;
                }
      }

    }
      
    }
  

    // TO DO: WRITE COUNT NEIGHBORS METHOD TO DETERMINE 
    // HOW MANY LIVING NEIGHBORS A SPECIFIC CELL HAS
  
  
    public int countNeighbors(int r, int c) {
      int total = 0;
      
      if (world[r][c].getStatus()) {
        total--;
      }
      for (int i = r-1; i < r + 2; i++) {
        for (int j = c-1; j < c + 2; j++) {
         
            try {
              if (world[i][j].getStatus()) {
                total++;
              }
            } catch (Exception e) {
              // Ignore the error and keep the loop going
            }
         
        }
      }
      return total;
    }
  
    // TO DO: WRITE METHOD TO UPDATE THE BOARD TO THE NEXT GENERATION
    public void updateBoard() {
      population = 0;
  for (int i = 0; i < world.length; i++) {
    for (int j = 0; j < world[0].length; j++) {

      if (world[i][j].getStatus()) {
        population++;
      
      // TO DO: IMPLEMENT THE GAME OF LIFE RULES
      //Any live cell with fewer than two live neighbours 
      // dies, as if by underpopulation.
        if (countNeighbors(i, j) < 2) {
          world[i][j].setStatus(false);
          
        }
      
      // Any live cell with two or three live neighbours 
      // lives on to the next generation.
        if (countNeighbors(i, j) == 2 || countNeighbors(i, j) == 3) {
       
        }
      
      // Any live cell with more than three live neighbours 
      // dies, as if by overpopulation.
        if (countNeighbors(i, j) > 3) {
          world[i][j].setStatus(false);
          
        }
  
      } else {
      // Any dead cell with exactly three live neighbours
      // becomes a live cell, as if by reproduction.
      if (countNeighbors(i, j) == 3) {
        world[i][j].setStatus(true);
      }

      }
      
  
    }
  }
generation++;

    }
  
    // TO DO: CREATE A STRING VERSION OF THE INSTANCE VARIABLE world
    public String toString() {
      String s = "";
      for (int i = 0; i < world.length; i++) {
        for (int j = 0; j < world[0].length; j++) {
          s += world[i][j].toString();
        }
        s += "\n";
      }
      
      return s + "\n" + "Generation: " + generation + "\n" + "Population: " + population;
    }
    
  }
