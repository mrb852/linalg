public class Opgave4c {

    public static void main(String[] args) {

        /**
         * Benyt mul til at udregne AB og BA, hvor A og B er matricerne ovenfor
         * (og udskriv resultaterne).
         */
        matrix A = Opgave4a.matrixA();
        matrix B = Opgave4a.matrixB();

        try {
            System.out.println("Udskriver AB\n");
            A.mul(B).println();
            System.out.println("\nUdskriver BA\n");
            B.mul(A).println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
