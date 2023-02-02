package com.hfad.karnaughmap_java.solvers;

public class Map3x2_solver {
    private String output = "";
    private final int[][] A = new int[2][4];
    private final int[][] checked = new int[2][4];

    public Map3x2_solver(int[] val) {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                A[i][j] = val[count++];
                checked[i][j] = 0;
            }
        }
    }

    public String solve() {
        if (checkAllOne()) {
            output = "1";
        } else if (checkAllZero()) {
            output = "0";
        } else {
            check4();
            check2();
            nogrouping();
        }
        return output;
    }

    // check for all 1
    private boolean checkAllOne() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkAllZero() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // check for 4
    private void check4() {

        //top
        if (A[0][0] == 1 && A[0][1] == 1 && A[0][2] == 1 && A[0][3] == 1 &&
                (checked[0][0] == 0 || checked[0][1] == 0 || checked[0][2] == 0 || checked[0][3] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[0][3] = 1;
            output += "C'";
        }

        //bottom
        if (A[1][0] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[1][0] == 0 || checked[1][1] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            output += "C";
        }

        //left
        if (A[0][0] == 1 && A[0][1] == 1 && A[1][0] == 1 && A[1][1] == 1 &&
                (checked[0][0] == 0 || checked[0][1] == 0 || checked[1][0] == 0 || checked[1][1] == 0)) {

            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[1][0] = 1;
            checked[1][1] = 1;
            output += "A'";
        }

        //right
        if (A[0][2] == 1 && A[0][3] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            output += "A";
        }

        //center
        if (A[0][1] == 1 && A[0][2] == 1 && A[1][1] == 1 && A[1][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            output += "B";
        }

        //sides
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][3] == 1 && A[1][3] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            output += "B'";
        }

    }

    private void check2() {

        if (A[0][0] == 1 && A[1][0] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            output += "B'C'";

        }
        if (A[0][1] == 1 && A[1][1] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)) {
            checked[0][1] = 1;
            checked[1][1] = 1;
            output += "B'C";

        }
        if (A[0][2] == 1 && A[1][2] == 1 && (checked[0][2] == 0 || checked[1][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            output += "BC";

        }
        if (A[0][3] == 1 && A[1][3] == 1 && (checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
            output += "B'C'";
        }

        if (A[0][0] == 1 && A[0][1] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            output += "A'B'";

        }
        if (A[0][1] == 1 && A[0][2] == 1 && (checked[0][1] == 0 || checked[0][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            output += "A'C";

        }
        if (A[0][2] == 1 && A[0][3] == 1 && (checked[0][2] == 0 || checked[0][3] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            output += "A'B";

        }
        if (A[0][0] == 1 && A[0][3] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)) {
            checked[0][0] = 1;
            checked[0][3] = 1;
            output += "A'C'";

        }
        if (A[1][0] == 1 && A[1][1] == 1 && (checked[1][0] == 0 || checked[1][1] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            output += "AB'";
        }
        if (A[1][1] == 1 && A[1][2] == 1 && (checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
            output += "AC";
        }
        if (A[1][2] == 1 && A[1][3] == 1 && (checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[1][2] = 1;
            checked[1][3] = 1;
            output += "AB";
        }
        if (A[1][0] == 1 && A[1][3] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            output += "AC'";
        }
    }

    // no grouping
    private void nogrouping() {
        if (A[0][0] == 1 && checked[0][0] == 0) {
            output += "A'B'C'";
        }
        if (A[0][1] == 1 && checked[0][1] == 0) {
            output += "A'B'C";
        }
        if (A[0][2] == 1 && checked[0][2] == 0) {
            output += "A'B C";
        }
        if (A[0][3] == 1 && checked[0][3] == 0) {
            output += "AB'C";
        }
        if (A[1][0] == 1 && checked[1][0] == 0) {
            output += "A B'C'";
        }
        if (A[1][1] == 1 && checked[1][1] == 0) {
            output += "A'B'C";
        }
        if (A[1][2] == 1 && checked[1][2] == 0) {
            output += "ABC";
        }
        if (A[1][3] == 1 && checked[1][3] == 0) {
            output += "ABC'";
        }
    }
}

