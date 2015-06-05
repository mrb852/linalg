public class Opgave4a {

    public static void main(String[] args) {

        /**
         * (a) Skriv et program, som viser, hvordan man erklærer og bruger
         * variable af typen matrix ved at definere matricerne nedenfor og
         * udskrive dem
         */
        matrix A = matrixA();
        matrix B = matrixB();

        System.out.println("Printer Matrix A.\n");
        A.println();
        System.out.println("\nPrinter Matrix B.\n");
        B.println();

        /**
         * Vis hvordan man ændrer elementet a12 så det får værdien 4.
         */
        System.out.println("\nÆndrer a12 til 4");
        A.set(1, 2, 4);
        System.out.println("\nPrinter A_12.\n");
        System.out.printf("A_12: %f\n", A.get(1, 2));

        /**
         * Forklar hvad der sker, hvis man forsøger at ændre et element
         * indiceret uden for A, f.eks. fejlagtigt vil sætte a44 lig med 5.
         */
        System.out.println("\nPrøver at sætte A_44 = 5. Fejl printes\n");
        A.set(4, 4, 5);

        /**
         * Vis hvordan man bruger add metoden til at udregne A + B.
         */
        System.out.println("\nPrinter A + B\n");
        A.add(B).println();
    }

    /**
     * Laver matrix A fra opgave 4. Den er public så den kan ses fra andre
     * klasser
     * 
     * @return matrix A fra opgave 4
     */
    public static matrix matrixA() {
        matrix a = new matrix(3, 3);
        for (int i = 1, c = 1; i <= 3; ++i)
            for (int j = 1; j <= 3; ++j, ++c)
                a.set(i, j, c);
        return a;
    }

    /**
     * Laver matrix B fra opgave 4. Den er public så den kan ses fra andre
     * klasser
     * 
     * @return matrix B fra opgave 4
     */
    public static matrix matrixB() {
        matrix b = new matrix(3, 3);
        for (int i = 1, d = 9; i <= 3; ++i)
            for (int j = 1; j <= 3; ++j, d = (d % 2 != 0) ? -d + 1 : -d - 1)
                b.set(i, j, -d);
        return b;
    }

}
