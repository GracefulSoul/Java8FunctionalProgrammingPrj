
public class LambdaHello {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous class");
			}
		}).start();
		new Thread(() -> System.out.println("Lambda expressions")).start();
	}
}
