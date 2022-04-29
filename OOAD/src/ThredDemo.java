
public class ThredDemo {
	public static void main (String[] args)
	{
		Worker1 t1=new Worker1();
		t1.run();
		
	}

}

class Worker1 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<=10;i++)
		{
			try{Thread.sleep(100);}
			catch(InterruptedException e) {
				e.printStackTrace();
				
			}
			System.out.println(Thread.currentThread().toString()+i);
			
			
			
		}
		
		
	}
	
	
	
	
}