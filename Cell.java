package BacteriaSim;

public class Cell {
    // TO DO: DECIDE WHAT TYPE OF VARIABLE TO STORE LIVING/DEAD
    private boolean status;
    public static final String ANSI_BLACK_BG = "\u001B[40m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // TO DO: COMPLETE CONSTRUCTOR METHOD
     public Cell(boolean s) {
      status = s;
     }
  
     public boolean getStatus() {
       return this.status;
    }
  
     public void setStatus(boolean s) {
       this.status = s;
     }
  
    // TO DO: DECIDE HOW YOU WANT TO VIZUALIZE A LIVING/DEAD CELL
    // SO WHEN IT'S PRINTED, WE KNOW ITS STATUS
    public String toString() {
  String visualS = "";
    if (status == true) {
      visualS =  ANSI_WHITE_BACKGROUND + "🦠" + ANSI_RESET;
    } else {
      visualS = ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET;
    }
      return visualS;
    }
  }
  
