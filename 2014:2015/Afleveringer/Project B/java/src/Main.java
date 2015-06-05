
public class Main {

	public static void main(String[] args) {
		Matrix a = new Matrix(2, 3);
		a.set(1, 1, 1);
		a.set(1, 2, 2);
		a.set(1, 3, 3);
		a.set(2, 1, 4);
		a.set(2, 2, 5);
		a.set(2, 3, 6);
		
		Matrix b = new Matrix(3, 2);
		b.set(1, 1, -7);
		b.set(1, 2, 8);
		b.set(2, 1, 9);
		b.set(2, 2, -10);
		b.set(3, 1, -11);
    b.set(3, 2, 12);
   
    
    try {
      a.mul(b).println();
      
      // Throws error. Don't know why.
      b.mul(a).println();
    } catch (Exception e) {
      e.printStackTrace();
    }
	}

}
