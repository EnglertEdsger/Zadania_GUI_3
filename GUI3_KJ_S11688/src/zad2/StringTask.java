package zad2;
public class StringTask  implements Runnable{
	 String ABORTED ;
	String CREATE  ;
String RUNNING ;
	String sentence;
    int num;
    String result="";
    volatile String state="";
    boolean done = false;
    boolean end=false;
    boolean start = true;
     static String READY;

    public StringTask(){
       
 
    }
    public StringTask(String sentence,int num){
        this. sentence = sentence;
        this.num= num;
        this.state = CREATE;
    }
   
   
    public void run(){
    this.state=RUNNING;
     
    synchronized(this.result){
    try{
        for(int i = 0; i <num; i++){
            result +=sentence;
           
        }
        this.state = READY;
        this.done = true;
    }
        catch(Exception e) {
            this.state = ABORTED;
            this.done = false;
        }
    }
    }    
   
    public void abort() throws Throwable{
        this.end = true;
        this.done= true;
        this.state = ABORTED;
        this.finalize();
       
    }
    public String getResult(){
        return this.result;
    }
    public String getState(){
        return this.state;
    }
    public boolean isDone(){
        return this.done;
    }
    public void start() {
    }

   
   
}