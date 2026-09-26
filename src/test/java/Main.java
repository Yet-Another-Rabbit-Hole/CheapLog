import net.YaRh.CheapLog.logging.ProgressBar;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		testProgressBars();
	}

	public static void testProgressBars() throws InterruptedException {
		ProgressBar pb;
		for (ProgressBar.BarType barType : ProgressBar.BarType.values()) {
			System.out.println("");
			System.out.println(barType);
			
			pb = new ProgressBar("Fih", 20, 10, barType);
			
			for (int i = 0; i < 10; i++) {
				Thread.sleep(500);
				pb.step();
			}
		}
	}
}