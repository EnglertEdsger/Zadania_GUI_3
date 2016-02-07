/**
 *
 *  @author Kaczyński Jakub S11688
 *
 */

package zad1;


public class Main {

  public static void main(String[] args) throws InterruptedException {
    Letters letters = new Letters("ABCD");
    for (Thread t : letters.getThreads()) System.out.println(t.getName());
    
    letters.x();


    Thread.sleep(5000);

    letters.y();

    System.out.println("\nProgram skończył działanie");
  }

}
