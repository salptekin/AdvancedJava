package javadevelopment;

public class J14Synchronization04 {

	/*
	 When we use synchronization on a single object everything works fine but sometimes we need to use
	 multiple objects in synchronization. If we use multiple objects it creates different outputs in every run 
	 like the following code. To fix that issue we need "static synchronization"
	*/
	
	//Synchronization wit multiple objects create different outputs in every run
//	public static void main(String[] args) {
//		Brakets03 braket1 = new Brakets03();
//		Brakets03 braket2 = new Brakets03();
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for(int i=1; i<=10;i++) {
//					braket1.generate();
//				}
//				System.out.println("Thread 1");
//			}
//			
//		}).start();
//		
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for(int i=1; i<=10;i++) {
//					braket2.generate();
//				}
//				System.out.println("Thread 2");
//			}
//			
//		}).start();
//	}
//
//}
//
//class Brakets04{
//	synchronized public void generate() {
//		for(int i=1; i<=10;i++) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				System.out.println("There is problem in sleep");
//			}
//			if(i<=5) {
//				System.out.print("[");
//			}else {
//				System.out.print("]");
//			}
//		}
//		System.out.println();
//
//	}
//}
	
	/*
	 We will make the method "synchronized static" and add a parameter to the method 
	 then when we call the method we can use different parameters everytime.
	*/
	public static void main(String[] args) {
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=1; i<=10;i++) {
					Brakets04.generate("Thread 1");
				}
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=1; i<=10;i++) {
					Brakets04.generate("Thread 2");
				}
			}
			
		}).start();
	}

}
/*
 I made the generate() method static and add a parameter
 By passing many parameters you can use synchronization with different objects.
 */
class Brakets04{
	synchronized static public void generate(String threadNo) {
		for(int i=1; i<=10;i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("There is a problem in sleep");
			}
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println("Generated by " + threadNo);

	}
}
	



