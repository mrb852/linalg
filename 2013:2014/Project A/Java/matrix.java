class matrix {
    // ////////////////////////////////////////////////////////////////
    // Class matrix:
    //
    // This is a 2 dimensional real matrix class. Objects of this
    // type are instantiated as e.g.
    //
    // matrix A = matrix(3, 2);
    //
    // in which case, A is a matrix with 3 rows and 2 columns of
    // doubles. The matrix elements are numerated from 1, i.e. the top
    // left element is (1, 1) and the bottom right is (3, 2) in the
    // example. The class implements a number of methods:
    //
    // rows()
    // Return the number of rows in A as an integer
    //
    // cols()
    // Return the number of cols in A as an integer
    //
    // set(i, j, v)
    // Store the double value v at row i and column j
    //
    // get(i, j)
    // Return the value double at row i and column j
    //
    // println()
    // Pretty-print the matrix' values on stdout ending with a
    // new-line.
    //
    // transpose()
    // Return a copy of the matrix transposed
    //
    // add(B)
    // This function has 2 uses depending on the type of B:
    // . When B is a matrix, a new matrix is returned wich is
    // element-wise additions of this and B
    // . When B is a double, a new matrix is returned which is the
    // element-wise addition of this with the same value, B.
    //
    // mul(v)
    // Return a copy of the matrix, where each element has been
    // multiplied by v
    //
    // setIdentity()
    // Modify the matrix to be 1 along the diagonal and 0 elsewhere
    //
    // setConstant(v)
    // Modify the matrix to set every element to the value v
    //
    // concatenateRows(B)
    // Return a new matrix wich is a concatenation of this with
    // matrix B along the colums, i.e., [this | B]
    //
    // subMatrix(from_row, from_col, to_row, to_col)
    // Return a new matrix copied from the rows and colums from
    // this, i.e., this(from_row..to_row, from_col..to_col)
    //
    // swapRows(int a, int b)
    // Return a new matrix as a copy of this but where row a and b
    // are interchanged
    //
    // addMulRows(a, b, c, v)
    // Return a new matrix as a copy of this but where row a has
    // been replaced by row b plus v times row c, i.e.,
    // A(a,:)=A(b,:)+v*A(c,:)
    //
    // deleteCol(int a)
    // Return a new matrix as a copy of this except column a
    //
    // Author: Jon Sporring, 2013-10-5
    // Version: 1.0
    // ////////////////////////////////////////////////////////////////

    double[][] val; // The local variable storing matrix entries

    public matrix(int m, int n) {
        // Constructor

        if ((m < 1) || (n < 1)) {
            System.out
                    .println("Cannot create a matrix of 0 rows and/or columns");
            System.exit(0);
        }

        val = new double[m][n];
    }

    public int rows() {
        // Return the number of rows in the matrix.

        return val.length;
    }

    public int cols() {
        // Return the number of columns in the matrix.

        return val[0].length;
    }

    public void set(int m, int n, double v) {
        // Set value at row m and column n to be v.

        if ((m < 1) || (m > rows()) || (n < 1) || (n > cols())) {
            System.out
                    .println("Elements outside the matrix cannot be assigned values");

            return;
        }

        val[m - 1][n - 1] = v;
    }

    public double get(int m, int n) {
        // Return the matrix value at row m and column n.

        if ((m < 1) || (m > rows()) || (n < 1) || (n > cols())) {
            System.out
                    .println("Elements outside the matrix cannot be accessed");
            return Double.NaN;
        }

        return val[m - 1][n - 1];
    }

    public matrix transpose() {
        // Return a copy of the matrix where row and column values
        // have been interchanged.

        matrix M = new matrix(cols(), rows());

        for (int i = 1; i <= cols(); i++) {
            for (int j = 1; j <= rows(); j++) {
                M.set(i, j, get(j, i));
            }
        }

        return M;
    }

    public void println() {
        // Pretty-print the matrix to stdout.

        double v;

        for (int i = 1; i <= rows(); i++) {
            System.out.format("[");
            for (int j = 1; j <= cols(); j++) {
                if (j > 1)
                    System.out.format(" ");
                v = get(i, j);
                System.out.format("%f", v);
            }
            System.out.format("]\n");
        }
    }

    public matrix add(matrix B) {
        // Return a new matrix which is the element-wise addition of
        // this with other matrix B. The two matrices must be of the
        // same size.

        if ((rows() != B.rows()) || (cols() != B.cols())) {
            System.out
                    .println("Error, cannot add since the 2 matrices do not have the same dimensions.");
            System.exit(0);
        }

        matrix M = new matrix(rows(), cols());
        double v;

        for (int i = 1; i <= rows(); i++) {
            for (int j = 1; j <= cols(); j++) {
                v = get(i, j);
                M.set(i, j, v + B.get(i, j));
            }
        }

        return M;
    }

    public matrix add(double v) {
        // Return a new matrix which is the element-wise addition of
        // this with v.

        matrix M = new matrix(rows(), cols());

        for (int i = 1; i <= rows(); i++) {
            for (int j = 1; j <= cols(); j++) {
                M.set(i, j, v + get(i, j));
            }
        }

        return M;
    }

    public matrix mul(double v) {
        // Return a new matrix which is the element-wise
        // multiplication of this with v.

        matrix M = new matrix(rows(), cols());

        for (int i = 1; i <= rows(); i++) {
            for (int j = 1; j <= cols(); j++) {
                M.set(i, j, v * get(i, j));
            }
        }

        return M;
    }

    public void setIdentity() {
        // Change values to be the identity matrix.

        for (int i = 1; i <= Math.min(rows(), cols()); i++) {
            for (int j = 1; j <= Math.min(rows(), cols()); j++) {
                if (i == j)
                    set(i, j, 1);
                else
                    set(i, j, 0);
            }
        }
    }

    public void setConstant(double v) {
        // Change values to be constant value v.

        for (int i = 1; i <= rows(); i++) {
            for (int j = 1; j <= cols(); j++) {
                set(i, j, v);
            }
        }
    }

    public matrix concatenateRows(matrix B) {
        // Return a new matrix which is the concatenation of this with
        // B, i.e. [this | B].

        if (rows() != B.rows()) {
            System.out
                    .println("Error, the matrices must have the same number of rows to be concatenated.");
            System.exit(0);
        }

        matrix M = new matrix(rows(), cols() + B.cols());

        for (int i = 1; i <= M.rows(); i++) {
            for (int j = 1; j <= cols(); j++)
                M.set(i, j, get(i, j));
            for (int j = 1; j <= B.cols(); j++)
                M.set(i, j + cols(), B.get(i, j));
        }

        return M;
    }

    public matrix subMatrix(int from_row, int from_col, int to_row, int to_col) {
        // Return a new matrix whos elements are copied from this
        // matrix from rows from_row .. to_row and columns from_col
        // .. to_col.

        if ((from_row < 1) || (from_row > rows()) || (from_col < 1)
                || (from_col > cols()) || (to_row < from_row)
                || (to_row > rows()) || (to_col < from_col)
                || (to_col > cols())) {
            System.out
                    .println("Error, cannot take a submatrix of elements outside the original matrix.");
            System.exit(0);
        }

        int ROWS = to_row - from_row + 1;
        int COLS = to_col - from_col + 1;
        matrix M = new matrix(ROWS, COLS);

        for (int i = 1; i <= ROWS; i++)
            for (int j = 1; j <= COLS; j++) {
                M.set(i, j, get(i + from_row - 1, j + from_col - 1));
            }
        return M;
    }

    public matrix swapRows(int a, int b) {
        // Return a new matrix, where rows a and b are interchanged

        if ((a < 1) || (a > rows()) || (b < 1) || (b > rows())) {
            System.out
                    .println("Error, cannot swap rows outside the original matrix.");
            System.exit(0);
        }

        matrix M = add(0);

        if (a != b) {
            for (int i = 1; i <= rows(); i++) {
                if (i == a) {
                    for (int j = 1; j <= cols(); j++) {
                        M.set(b, j, get(i, j));
                    }
                } else if (i == b) {
                    for (int j = 1; j <= cols(); j++) {
                        M.set(a, j, get(i, j));
                    }
                } else {
                    for (int j = 1; j <= cols(); j++) {
                        M.set(i, j, get(i, j));
                    }
                }
            }
        }

        return M;
    }

    public matrix addMulRows(int a, int b, int c, double v) {
        // Return a new matrix, where row a has been replaced by the
        // sum of row b plus v times row c.

        if ((a < 1) || (a > rows()) || (b < 1) || (b > rows()) || (c < 1)
                || (c > rows())) {
            System.out.println("Error, reference to non-existing rows.");
            System.exit(0);
        }

        matrix M = add(0);

        for (int i = 1; i <= rows(); i++) {
            for (int j = 1; j <= cols(); j++) {
                if (i == a) {
                    M.set(a, j, get(b, j) + v * get(c, j));
                } else {
                    M.set(i, j, get(i, j));
                }
            }
        }

        return M;
    }

    public matrix deleteCol(int a) {
        // Return a new matrix as a copy of this not including the
        // i'th col.
        if ((a < 1) || (a > cols())) {
            System.out
                    .println("Error, cannot remove a row outside the original matrix.");
            System.exit(0);
        }

        matrix M;

        if (a == 1) {
            M = subMatrix(1, 2, rows(), cols());
        } else if (a == cols()) {
            M = subMatrix(1, 1, rows(), cols() - 1);
        } else {
            M = subMatrix(1, 1, rows(), a - 1);
            M = M.concatenateRows(subMatrix(1, a + 1, rows(), cols()));
        }

        return M;
    }

    // ////////////////////////////////////////////////////////////////
    // Solution to project A
    // ////////////////////////////////////////////////////////////////

    public matrix mul(matrix B) throws Exception {
        // Return a new matrix which is the matrix product of this
        // with B.
        B = B.transpose();
        if (cols() != B.cols())
            throw new Exception("Cols must be equal to other matrix rows");

        matrix m = new matrix(cols(), B.cols());

        for (int i = 1; i <= rows(); ++i)
            for (int j = 1; j <= cols(); ++j)
                for (int e = 1; e <= cols(); ++e)
                    m.set(i, j, m.get(i, j) + get(i, e) * B.get(j, e));
        return m;
    }
   
}
