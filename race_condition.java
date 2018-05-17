import java.util.Scanner;

public class race_condition {

	public static void main(String[] args) {
	
		Scanner kb = new Scanner(System.in);
		
		System.out.println("\r\n" + 
				"please select\r\n" + 
				"non_sysnchonize Enter 1\r\n" + 
				"sysnchonize Enter 2");
		
		int c= kb.nextInt();
		if(c==1) {
			  System.out.println("Please define loob number: ");
				 int x = kb.nextInt(); // round number
		         
				Counter counter = new Counter(x);
		        Thread t1 = new Thread(counter, "Thread1");
		        Thread t2 = new Thread(counter, "Thread2");
		               t1.start();
		               t2.start();
		 }else {
	  
	  System.out.println("Please define loob number: ");
		 int x = kb.nextInt(); // round number
         
		Counter_sysnchonize counter = new Counter_sysnchonize(x);
        Thread t1 = new Thread(counter, "Thread1");
        Thread t2 = new Thread(counter, "Thread2");
               t1.start();
        t2.start();
		}
		
      
		// TODO Auto-generated method stub
	}
}
class Counter implements Runnable{
    private int c = 0;
    public int x;
    public Counter(int b) {
    	this.x=b;
    }
    public void increment() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c++;
    }

    public void decrement() {    
        c--;
    }

    public int getValue() {
        return c;
    }
    
    @Override
    public  void run() {
        
    	 /// 
    	
    	for(int i=0;i<x;i++) {
    		 this.increment(); //incrementing
        System.out.println("increment " 
        + Thread.currentThread().getName() + "---> " + this.getValue());
       
    	
    		this.decrement(); //decrementing
        System.out.println("decrement " 
        + Thread.currentThread().getName() + "---> " + this.getValue());    
    	
    	}
    	}      
}


class Counter_sysnchonize  implements Runnable{
    private int c = 0;
    public int x;
    public Counter_sysnchonize(int b) {
    	this.x=b;
    }
    public void increment() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c++;
    }

    public void decrement() {    
        c--;
    }

    public int getValue() {
        return c;
    }
    
    @Override
    public  void run() {
        
    	synchronized(this){  /// 
    	
    	for(int i=0;i<x;i++) {
    		 this.increment(); //incrementing
        System.out.println("increment " 
        + Thread.currentThread().getName() + "---> " + this.getValue());
       
    	
    		this.decrement(); //decrementing
        System.out.println("decrement " 
        + Thread.currentThread().getName() + "---> " + this.getValue());    
    	
    	}
    	}       
       }
}
