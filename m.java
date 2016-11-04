public class m{
	public static void main(String[] args){
	 Complex a = new Complex(1,5);
	 Complex b = new Complex(3,2.5);
	 
	 System.out.print("a            = " ); a.print();
	 System.out.print("b            = " ); b.print();
	 System.out.println("Re(a)        = " + a.real_part());
	 System.out.println("Im(a)        = " + a.imaginary_part());
	 System.out.print("b + a        = " ); a.plus(b).print();
	 System.out.print("a - b        = " ); a.minus(b).print();
	 System.out.print("a * b        = " ); a.multiply(b).print();
	 System.out.print("b * a        = " ); b.multiply(a).print();
	 System.out.print("a / b        = " ); a.divides(b).print();
	 System.out.print("(a / b) * b  = " ); a.divides(b).multiply(b).print();
	}
}

class Complex{
	private double re,im; //complex = a+bi
	//constructor
		public Complex(double a){this.re=a; this.im=0;}
		public Complex(double a, double b){
			this.re=a;
			this.im=b;
		}
	//plus +
	public Complex plus(Complex b) {
        Complex a = this;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }
	//minus -
	public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }
	//multiply x
	public Complex multiply(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }
	// reciprocal
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }
	//divide /
    public Complex divides(Complex b) {
        Complex a = this;
        return a.multiply(b.reciprocal());
    }
	//get real part
	public double real_part(){
		return re;
	}
	//get imaginary part
	public double imaginary_part(){
		return im;
	}
	//if it is a real number?
	public boolean isRealNumber(){
		return im==0;
	}
	//equals
	public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Complex that = (Complex) x;
        return (this.re == that.re) && (this.im == that.im);
    }
	//print
	public void print(){
		System.out.println(this.re+" + "+this.im+"i");
	}
}
