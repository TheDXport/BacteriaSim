package BacteriaSim;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
      System.out.println("Conway's Game of Life!");                                           
     
      Grid world = new Grid(20, 20);

      // ONE WAY OF DOING IT: CREATING A THREAD AND USING A RUN METHOD WITH A CUSTOMIZABLE INTERVAL

      Runnable run = new Runnable() {
        public void run() {
            world.updateBoard();
            System.out.println(world.toString());
            
        }
    };
    
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    executor.scheduleAtFixedRate(run, 0, 200, TimeUnit.MILLISECONDS);

// SECOND WAY OF DOING IT: USING A SIMPLE WHILE LOOP

//       boolean b = true;
//       while (b) {
//       System.out.println(world.toString());
//       world.updateBoard();
// }
      
    }
    
  }
