/**
 *
 *  @author Kaczyński Jakub S11688
 *
 */

package zad3;


import java.io.*;

import java.util.*;
	public class Main extends Object {
		  private Object slot;
		  double x;
		    double y;
		  public Main() {
		    slot = null; 
		  }
		  
		  
		  public synchronized void putIn(Object obj) 
		            throws InterruptedException {

		    while ( slot != null ) {
		      wait(); 
		    }

		    slot = obj;  
		    notifyAll(); 
		  }
//		  Scanner inFile = new Scanner(new FileReader(""));{
//
//		    x = inFile.nextDouble();
//		    y = inFile.nextDouble();
//
//		            System.out.println("");
//		    }
		  public synchronized Object takeOut() 
		            throws InterruptedException {

		    while ( slot == null ) {
		      wait(); 
		    }

		    Object obj = slot;
		    slot = null; 
		    notifyAll(); 
		    return obj;
		  }
		  public static void main(String[] args) {
		    final Main ch = new Main();

		    Runnable runA = new Runnable() {
		        public void run() {
		          try {
		            String str;
		            Thread.sleep(500);

		            str = "utworzono 200 obiektów ";
		            ch.putIn(str);
		            str = "policzono wage 100 towarów";
		            ch.putIn(str);

		            ch.putIn(str);
		          } catch ( InterruptedException x ) {
		            x.printStackTrace();
		          }
		        }
		      };

		    Runnable runB = new Runnable() {
		        public void run() {
		          try {
		            Object obj;

		            obj = ch.takeOut();
		            System.out.println("" + 
		                obj + "");

		            Thread.sleep(500);

		            obj = ch.takeOut();
		            System.out.println("" + 
		                obj + "");

		            obj = ch.takeOut();
		            System.out.println("" + 
		                obj + "");
		          } catch ( InterruptedException x ) {
		            x.printStackTrace();
		          }
		        }
		      };

		    Thread threadA = new Thread(runA, "threadA");
		    threadA.start();

		    Thread threadB = new Thread(runB, "threadB");
		    threadB.start();
		  }
		  
		  
		

}