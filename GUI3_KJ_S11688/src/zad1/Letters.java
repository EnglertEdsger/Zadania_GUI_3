
package zad1;
import java.util.*;
class Letters {
	private	String CREATE  ;
	private	String RUNNING ;

    private boolean isContinue;
    private final List<Thread> threads;
 
    public Letters(String chars) {
        threads = new LinkedList<>();
 
        for (char characters : chars.toCharArray()) {
            threads.add(
                    new Thread(() -> {
                        try {
                            while (isContinue) {
                                System.out.print(characters);
                                Thread.sleep(1000);
                            }
                        } catch (InterruptedException ex) {
                        }
                    }, "Thread " + Character.toString(characters))
            );
        }
    }
    public void x() {
        isContinue = true;
        threads.forEach(Thread::start);
    }
 
    public void abort() throws Throwable{
    }
    public List<Thread> getThreads() {
        return Collections.unmodifiableList(threads);
    }
 
  
    public void y() throws InterruptedException {
        isContinue = false;
        while (threads.stream().filter(t -> t.isAlive()).count() > 0) {
            Thread.sleep(100);
        }
    }
}