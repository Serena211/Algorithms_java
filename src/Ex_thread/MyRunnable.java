package Ex_thread;
class NewRunnable implements Runnable {
	private int i = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
}
public class MyRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
