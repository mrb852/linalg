
public class Main {

	public static void main(String[] args) {
	  
  	// Opgave 4.a
  	Matrix a = matrixA();
  	
  	System.out.println("A: ");
  	a.println();
  	
  	System.out.println();
  	
  	System.out.println("B: ");
  	Matrix b = matrixB();
  	b.println();
  	
  	
  	// Opgave 4.b
		a.set(1, 3, -4);
		System.out.println("\nA new: ");
		a.println();
		

	   // Opgave 4.c
		System.out.println("\nA after mul and add: ");
		matrixA().mul(2).add(b).println();
		
	}
	  
	// Creates matrix a
	public static Matrix matrixA() {
    Matrix a = new Matrix(3, 3);
    
    for (int i = 1, c = 1; i <= 3; ++i) {
      for (int j = 1; j <= 3; ++j, ++c) { 
        a.set(j, i, c);
      }
    }
    
    return a;
	}

	
	// Creates matrix b
	public static Matrix matrixB() {
	  Matrix b = new Matrix(3, 3);
    
	  for (int i = 1, d = 9; i <= 3; ++i) {
      for (int j = 1; j <= 3; ++j, d = (d % 2 != 0) ? -d + 1 : -d - 1) {
        b.set(j, i, -d);
      }
    }
    
    return b;
	}
}
