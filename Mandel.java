
import java.awt.Color;
import java.util.ArrayList;

public class Mandel {
	public static final int maxIterations = 1000;
	public static void main(String[] args) {
		Graphics gc = new Graphics(900, 900, 1);
		ArrayList<MandelGrid> savedViews = new ArrayList<MandelGrid>();
		
		MandelGrid myMandelGrid = new MandelGrid(new Complex(-2, 1.5), new Complex(1, -1.5), 800, maxIterations);
		savedViews.add(myMandelGrid);
		savedViews.get(0).drawGrid(gc);
		
		while(true) {
			int event = gc.waitForEvent();
			if(event == Graphics.KEY_EVENT) {
				char key = gc.getKey();
				int currentIndex = savedViews.indexOf(myMandelGrid);
				System.out.println(currentIndex);
				if(key == 'w' && currentIndex + 1 < savedViews.size()) {
					myMandelGrid = savedViews.get(currentIndex + 1);
					myMandelGrid.drawGrid(gc);
				}
				else if(key == 's' && currentIndex > 0) {
					myMandelGrid = savedViews.get(currentIndex - 1);
					myMandelGrid.drawGrid(gc);
				}
			}
			else if(event == Graphics.MOUSE_EVENT) {
				int[] click1 =  gc.getMouseClick();
				Complex bound1 = myMandelGrid.getElm(click1[0], click1[1]);
				gc.getWindow().setLineColor(Color.WHITE);
				gc.getWindow().moveTo(click1[0], click1[1]);
				gc.getWindow().writeText(bound1.toString());
				
				int[] click2 =  gc.waitForMouseClick();
				Complex bound2 = myMandelGrid.getElm(click2[0], click2[1]);
				gc.getWindow().moveTo(click2[0], click2[1]);
				gc.getWindow().writeText(bound1.toString());
				
				gc.square(click1[0], click1[1], click2[0], click2[1]);
				
				myMandelGrid = new MandelGrid(bound1, bound2, 800, maxIterations);
				savedViews.add(myMandelGrid);
				myMandelGrid.drawGrid(gc);
			}
					
		
		}
	}

	
}
