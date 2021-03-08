import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class Graphics {
	private SimpleWindow window;
	private int width;
	private int height;
	private int blockSize;
	public static final int KEY_EVENT = SimpleWindow.KEY_EVENT;
	public static final int MOUSE_EVENT = SimpleWindow.MOUSE_EVENT;

	public Graphics(int w, int h, int bs) {
		this.width = w;
		this.height = h;
		this.blockSize = bs;
		this.window = new SimpleWindow(w * bs, height * bs, "Graphics!");
	}

	public SimpleWindow getWindow() {
		return window;
	}

	public void square(int xFrom, int yFrom, int xTo, int yTo) {
		window.setLineColor(Color.WHITE);
		window.moveTo(xFrom, yFrom);
		window.lineTo(xTo, yFrom);
		window.lineTo(xTo, yTo);
		window.lineTo(xFrom, yTo);
		window.lineTo(xFrom, yFrom);
	}

	public void dot(int x, int y, Color color) {
		x *= blockSize;
		y *= blockSize;
		window.setLineColor(color);
		window.moveTo(x, y);
		window.lineTo(x, y);
	}

	public void setBlockSize(int bs) {
		this.blockSize = bs;
	}

	public char waitForKey() {
		return window.waitForKey();
	}

	public int waitForEvent() {
		window.waitForEvent();
		return window.getEventType();
	}

	public int[] waitForMouseClick() {
		window.waitForMouseClick();
		return getMouseClick();
	}

	public int[] getMouseClick() {
		return new int[] { window.getClickedX() / blockSize, window.getClickedY() / blockSize };
	}

	public char getKey() {
		return window.getKey();
	}

}