
public class Complex {
	public double re;
	public double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	// Returns fraction of maxInterations needed to determine divergance
	public double converge(int maxIterations) {
		Complex startNum = new Complex(re, im);
		Complex num = new Complex(re, im);
		int i;
		for (i = 0; i < maxIterations; i++) {
			if (num.getAbsSq() > 4) {
				break;
			}
			num.square();
			num.add(startNum);
		}
		return (double) i / maxIterations;
	}

	public double getAbs() {
		return Math.sqrt(re * re + im * im);
	}

	public double getAbsSq() {
		return re * re + im * im;
	}

	public void square() {
		double oldRe = re;
		re = re * re - im * im;
		im = 2 * oldRe * im;
	}

	public void add(Complex c) {
		re += c.re;
		im += c.im;
	}

	public String toString() {
		String str = "%f + %fi";
		if (im < 0) {
			str = "%f %fi";
		}
		return String.format(str, re, im);
	}

}
