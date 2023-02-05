package com.hfad.karnaughmap_java.solvers;

public class Map4x4_solver {
    private String output = "";
    private final int[][] A = new int[4][4];
    private final int[][] checked = new int[4][4];

    public Map4x4_solver(int[] val) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
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
            check8();
            check4();
            check2();
            nogrouping();
        }
        return output;
    }

    private boolean checkAllOne() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkAllZero() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void check8() {
        //top
        if (A[0][0] == 1 && A[0][1] == 1 && A[0][2] == 1 && A[0][3] == 1 &&
                A[1][0] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            output += "A'";
        }

        //bot
        if (A[2][0] == 1 && A[2][1] == 1 && A[2][2] == 1 && A[2][3] == 1 &&
                A[3][0] == 1 && A[3][1] == 1 && A[3][2] == 1 && A[3][3] == 1) {
            checked[2][0] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[2][3] = 1;
            checked[3][0] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            output += "A";
        }

        //center
        if (A[1][0] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                A[2][0] == 1 && A[2][1] == 1 && A[2][2] == 1 && A[2][3] == 1) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            checked[2][0] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[2][3] = 1;
            output += "B";
        }

        //left
        if (A[0][0] == 1 && A[1][0] == 1 && A[2][0] == 1 && A[3][0] == 1 &&
                A[0][1] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[0][1] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            output += "C'";
        }

        //right
        if (A[0][2] == 1 && A[1][2] == 1 && A[2][2] == 1 && A[3][2] == 1 &&
                A[0][3] == 1 && A[1][3] == 1 && A[2][3] == 1 && A[3][3] == 1) {
            checked[2][0] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[2][3] = 1;
            checked[3][0] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            output += "C";
        }

        //center
        if (A[0][1] == 1 && A[1][1] == 1 && A[2][1] == 1 && A[3][1] == 1 &&
                A[0][2] == 1 && A[1][2] == 1 && A[2][2] == 1 && A[3][2] == 1) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            checked[2][0] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[2][3] = 1;
            output += "D";
        }
    }

    private void check4() {

        //top
        if (A[0][0] == 1 && A[0][1] == 1 && A[0][2] == 1 && A[0][3] == 1 &&
                (checked[0][0] == 0 || checked[0][1] == 0 || checked[0][2] == 0 || checked[0][3] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[0][3] = 1;
            output += "A'B'";
        }

        //center_top
        if (A[1][0] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[1][0] == 0 || checked[1][1] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            output += "A'B";
        }

        //center_bottom
        if (A[2][0] == 1 && A[2][1] == 1 && A[2][2] == 1 && A[2][3] == 1 &&
                (checked[2][0] == 0 || checked[2][1] == 0 || checked[2][2] == 0 || checked[2][3] == 0)) {

            checked[2][0] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[2][3] = 1;
            output += "AB";
        }

        //bottom
        if (A[3][0] == 1 && A[3][1] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[3][0] == 0 || checked[3][1] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {

            checked[3][0] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            output += "AB'";
        }

        //left
        if (A[0][0] == 1 && A[1][0] == 1 && A[2][0] == 1 && A[3][0] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[3][0] = 1;
            output += "C'D'";
        }

        //left_center
        if (A[0][1] == 1 && A[1][1] == 1 && A[2][1] == 1 && A[3][1] == 1 &&
                (checked[0][1] == 0 || checked[1][1] == 0 || checked[2][1] == 0 || checked[3][1] == 0)) {

            checked[0][1] = 1;
            checked[1][1] = 1;
            checked[2][1] = 1;
            checked[3][1] = 1;
            output += "C'D";
        }

        //right_center
        if (A[0][2] == 1 && A[1][2] == 1 && A[2][2] == 1 && A[3][2] == 1 &&
                (checked[0][2] == 0 || checked[1][2] == 0 || checked[2][2] == 0 || checked[3][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            checked[2][2] = 1;
            checked[3][2] = 1;
            output += "CD";
        }

        //right
        if (A[0][3] == 1 && A[1][3] == 1 && A[2][3] == 1 && A[3][3] == 1 &&
                (checked[0][3] == 0 || checked[1][3] == 0 || checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            checked[3][3] = 1;
            output += "CD'";
        }

        //top_left
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][1] == 1 && A[1][1] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][1] == 0 || checked[1][1] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[0][1] = 1;
            checked[1][1] = 1;
            output += "A'C'";
        }

        //top_right
        if (A[0][2] == 1 && A[0][3] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            output += "A'C";
        }

        //bottom_left
        if (A[2][0] == 1 && A[3][0] == 1 && A[2][1] == 1 && A[3][1] == 1 &&
                (checked[2][0] == 0 || checked[3][0] == 0 || checked[2][1] == 0 || checked[3][1] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[2][1] = 1;
            checked[3][1] = 1;
            output += "AC'";
        }

        //bottom_right
        if (A[2][2] == 1 && A[2][3] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[2][2] == 0 || checked[2][3] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[2][2] = 1;
            checked[2][3] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            output += "AC";
        }

        //center
        if (A[1][1] == 1 && A[1][2] == 1 && A[2][1] == 1 && A[2][2] == 1 &&
                (checked[1][1] == 0 || checked[1][2] == 0 || checked[2][1] == 0 || checked[2][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            output += "BD";
        }

        //center-top
        if (A[0][1] == 1 && A[0][2] == 1 && A[1][1] == 1 && A[1][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            output += "A'D";
        }

        //center-bottom
        if (A[2][1] == 1 && A[2][2] == 1 && A[3][1] == 1 && A[3][2] == 1 &&
                (checked[2][1] == 0 || checked[2][2] == 0 || checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            output += "AD";
        }

        //center-left
        if (A[1][0] == 1 && A[2][0] == 1 && A[1][1] == 1 && A[2][1] == 1 &&
                (checked[1][0] == 0 || checked[2][0] == 0 || checked[1][1] == 0 || checked[2][1] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[1][1] = 1;
            checked[2][1] = 1;
            output += "BC'";
        }

        //center-right
        if (A[1][2] == 1 && A[2][2] == 1 && A[1][3] == 1 && A[2][3] == 1 &&
                (checked[1][2] == 0 || checked[2][2] == 0 || checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][2] = 1;
            checked[2][2] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            output += "BC";
        }


        //corners
        if (A[0][0] == 1 && A[0][3] == 1 && A[3][0] == 1 && A[3][3] == 1 &&
                (checked[0][0] == 0 || checked[0][3] == 0 || checked[2][1] == 0 || checked[2][2] == 0)) {
            checked[0][0] = 1;
            checked[0][3] = 1;
            checked[3][0] = 1;
            checked[3][3] = 1;
            output += "B'D'";
        }


        //left-right-top
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][3] == 1 && A[1][3] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[0][3] = 1;
            checked[1][3] = 1;
            output += "A'D'";
        }

        //left-right-bottom
        if (A[2][0] == 1 && A[3][0] == 1 && A[2][3] == 1 && A[3][3] == 1 &&
                (checked[2][0] == 0 || checked[3][0] == 0 || checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[2][3] = 1;
            checked[3][3] = 1;
            output += "AD'";
        }

        //left-right-center
        if (A[1][0] == 1 && A[2][0] == 1 && A[1][3] == 1 && A[2][3] == 1 &&
                (checked[1][0] == 0 || checked[2][0] == 0 || checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            output += "BD'";
        }

        //top-bottom-left
        if (A[0][0] == 1 && A[0][1] == 1 && A[3][0] == 1 && A[3][1] == 1 &&
                (checked[0][0] == 0 || checked[0][1] == 0 || checked[3][0] == 0 || checked[3][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[3][0] = 1;
            checked[3][1] = 1;
            output += "B'C'";
        }

        //top-bottom-right
        if (A[0][2] == 1 && A[0][3] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[3][0] = 1;
            checked[3][1] = 1;
            output += "B'C";
        }

        //top-bottom-center
        if (A[0][1] == 1 && A[0][2] == 1 && A[3][1] == 1 && A[3][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            output += "B'D";
        }


    }

    private void check2() {

        // top (left-right)
        if (A[0][0] == 1 && A[0][1] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
        }

        if (A[0][1] == 1 && A[0][2] == 1 && (checked[0][1] == 0 || checked[0][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
        }
        if (A[0][2] == 1 && A[0][3] == 1 && (checked[0][2] == 0 || checked[0][3] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
        }
        if (A[0][3] == 1 && A[0][0] == 1 && (checked[0][3] == 0 || checked[0][0] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
        }

        //top_center (left-right)
        if (A[1][0] == 1 && A[1][1] == 1 && (checked[1][0] == 0 || checked[1][1] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
        }

        if (A[1][1] == 1 && A[1][2] == 1 && (checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
        }
        if (A[1][2] == 1 && A[1][3] == 1 && (checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
        }
        if (A[1][3] == 1 && A[1][0] == 1 && (checked[1][3] == 0 || checked[1][0] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
        }

        //bot_center (left-right)
        if (A[2][0] == 1 && A[2][1] == 1 && (checked[2][0] == 0 || checked[2][1] == 0)) {
            checked[2][0] = 1;
            checked[2][1] = 1;
        }

        if (A[2][1] == 1 && A[2][2] == 1 && (checked[2][1] == 0 || checked[2][2] == 0)) {
            checked[2][1] = 1;
            checked[2][2] = 1;
        }
        if (A[2][2] == 1 && A[2][3] == 1 && (checked[2][2] == 0 || checked[2][3] == 0)) {
            checked[2][0] = 1;
            checked[2][1] = 1;
        }
        if (A[2][3] == 1 && A[2][0] == 1 && (checked[2][3] == 0 || checked[2][0] == 0)) {
            checked[2][0] = 1;
            checked[2][1] = 1;
        }

        //bot (left-right)
        if (A[3][0] == 1 && A[3][1] == 1 && (checked[3][0] == 0 || checked[3][1] == 0)) {
            checked[3][0] = 1;
            checked[3][1] = 1;
        }

        if (A[3][1] == 1 && A[3][2] == 1 && (checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[3][1] = 1;
            checked[3][2] = 1;
        }
        if (A[3][2] == 1 && A[3][3] == 1 && (checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[3][0] = 1;
            checked[3][1] = 1;
        }
        if (A[3][3] == 1 && A[3][0] == 1 && (checked[3][3] == 0 || checked[3][0] == 0)) {
            checked[3][0] = 1;
            checked[3][1] = 1;
        }

        //left (top-bot)
        if (A[0][0] == 1 && A[1][0] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
        }

        if (A[1][0] == 1 && A[2][0] == 1 && (checked[1][0] == 0 || checked[2][0] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
        }
        if (A[2][0] == 1 && A[3][0] == 1 && (checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
        }
        if (A[3][0] == 1 && A[0][0] == 1 && (checked[3][0] == 0 || checked[0][0] == 0)) {
            checked[3][0] = 1;
            checked[0][0] = 1;
        }

        //left (top-bot)
        if (A[0][0] == 1 && A[1][0] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
        }

        if (A[1][0] == 1 && A[2][0] == 1 && (checked[1][0] == 0 || checked[2][0] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
        }
        if (A[2][0] == 1 && A[3][0] == 1 && (checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
        }
        if (A[3][0] == 1 && A[0][0] == 1 && (checked[3][0] == 0 || checked[0][0] == 0)) {
            checked[3][0] = 1;
            checked[0][0] = 1;
        }

        //left_center (top-bot)
        if (A[0][1] == 1 && A[1][1] == 1 && (checked[0][1] == 0 || checked[1][1] == 0)) {
            checked[0][1] = 1;
            checked[1][1] = 1;
        }
        if (A[1][1] == 1 && A[2][1] == 1 && (checked[1][1] == 0 || checked[2][1] == 0)) {
            checked[1][1] = 1;
            checked[2][1] = 1;
        }
        if (A[2][1] == 1 && A[3][1] == 1 && (checked[2][1] == 0 || checked[3][1] == 0)) {
            checked[2][1] = 1;
            checked[3][1] = 1;
        }
        if (A[3][1] == 1 && A[0][1] == 1 && (checked[3][1] == 0 || checked[0][1] == 0)) {
            checked[3][0] = 1;
            checked[0][0] = 1;
        }

        //right_center(top-bot)
        if (A[0][2] == 1 && A[1][2] == 1 && (checked[0][2] == 0 || checked[1][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
        }
        if (A[1][0] == 1 && A[2][0] == 1 && (checked[1][0] == 0 || checked[2][0] == 0)) {
            checked[1][2] = 1;
            checked[2][2] = 1;
        }
        if (A[2][0] == 1 && A[3][0] == 1 && (checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[2][2] = 1;
            checked[3][2] = 1;
        }
        if (A[3][0] == 1 && A[0][0] == 1 && (checked[3][0] == 0 || checked[0][0] == 0)) {
            checked[3][2] = 1;
            checked[0][2] = 1;
        }

        //right (top-bot)
        if (A[0][3] == 1 && A[1][3] == 1 && (checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
        }

        if (A[1][3] == 1 && A[2][3] == 1 && (checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][3] = 1;
            checked[2][3] = 1;
        }
        if (A[2][3] == 1 && A[3][3] == 1 && (checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[2][3] = 1;
            checked[3][3] = 1;
        }
        if (A[3][3] == 1 && A[0][3] == 1 && (checked[3][3] == 0 || checked[0][3] == 0)) {
            checked[3][3] = 1;
            checked[0][3] = 1;
        }

    }

    private void nogrouping() {
        if(A[0][0] == 1){

        }
        if(A[0][1] == 1){

        }
        if(A[0][2] == 1){

        }
        if(A[0][3] == 1){

        }
        if(A[1][0] == 1){

        }
        if(A[1][1] == 1){

        }
        if(A[1][2] == 1){

        }
        if(A[1][3] == 1){

        }
        if(A[2][0] == 1){

        }
        if(A[2][1] == 1){

        }
        if(A[2][2] == 1){

        }
        if(A[2][3] == 1){

        }
        if(A[3][0] == 1){

        }
        if(A[3][1] == 1){

        }
        if(A[3][2] == 1){

        }
        if(A[3][3] == 1){

        }
    }

}
