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
            if(output == ""){
                output += "A'";
            }else output += "+A'";

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
            if(output == ""){
                output += "A";
            }else output += "+A";
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
            if(output == ""){
                output += "B";
            }else output += "+B";
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
            if(output == ""){
                output += "C'";
            }else output += "+C'";
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
            if(output == ""){
                output += "C";
            }else output += "+C";
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
            if(output == ""){
                output += "D";
            }else output += "+D";
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
            if(output == ""){
                output += "A'B";
            }else output += "+A'B'";
        }

        //center_top
        if (A[1][0] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[1][0] == 0 || checked[1][1] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            if(output == ""){
                output += "A'B";
            }else output += "+A'B";
        }

        //center_bottom
        if (A[2][0] == 1 && A[2][1] == 1 && A[2][2] == 1 && A[2][3] == 1 &&
                (checked[2][0] == 0 || checked[2][1] == 0 || checked[2][2] == 0 || checked[2][3] == 0)) {

            checked[2][0] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[2][3] = 1;
            if(output == ""){
                output += "AB";
            }else output += "+AB";
        }

        //bottom
        if (A[3][0] == 1 && A[3][1] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[3][0] == 0 || checked[3][1] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {

            checked[3][0] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            output += "AB'";
            if(output == ""){
                output += "AB'";
            }else output += "+AB'";
        }

        //left
        if (A[0][0] == 1 && A[1][0] == 1 && A[2][0] == 1 && A[3][0] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[3][0] = 1;
            if(output == ""){
                output += "С'D'";
            }else output += "+C'D'";
        }

        //left_center
        if (A[0][1] == 1 && A[1][1] == 1 && A[2][1] == 1 && A[3][1] == 1 &&
                (checked[0][1] == 0 || checked[1][1] == 0 || checked[2][1] == 0 || checked[3][1] == 0)) {

            checked[0][1] = 1;
            checked[1][1] = 1;
            checked[2][1] = 1;
            checked[3][1] = 1;
            if(output == ""){
                output += "С'D";
            }else output += "+C'D";
        }

        //right_center
        if (A[0][2] == 1 && A[1][2] == 1 && A[2][2] == 1 && A[3][2] == 1 &&
                (checked[0][2] == 0 || checked[1][2] == 0 || checked[2][2] == 0 || checked[3][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            checked[2][2] = 1;
            checked[3][2] = 1;
            if(output == ""){
                output += "СD";
            }else output += "+CD";
        }

        //right
        if (A[0][3] == 1 && A[1][3] == 1 && A[2][3] == 1 && A[3][3] == 1 &&
                (checked[0][3] == 0 || checked[1][3] == 0 || checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            checked[3][3] = 1;
            if(output == ""){
                output += "СD'";
            }else output += "+CD'";
        }

        //top_left
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][1] == 1 && A[1][1] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][1] == 0 || checked[1][1] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[0][1] = 1;
            checked[1][1] = 1;
            if(output == ""){
                output += "A'C'";
            }else output += "+A'C'";
        }

        //top_right
        if (A[0][2] == 1 && A[0][3] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            if(output == ""){
                output += "A'C";
            }else output += "+A'C";
        }

        //bottom_left
        if (A[2][0] == 1 && A[3][0] == 1 && A[2][1] == 1 && A[3][1] == 1 &&
                (checked[2][0] == 0 || checked[3][0] == 0 || checked[2][1] == 0 || checked[3][1] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[2][1] = 1;
            checked[3][1] = 1;
            if(output == ""){
                output += "AC'";
            }else output += "+AC'";
        }

        //bottom_right
        if (A[2][2] == 1 && A[2][3] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[2][2] == 0 || checked[2][3] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[2][2] = 1;
            checked[2][3] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            if(output == ""){
                output += "AC";
            }else output += "+AC";
        }

        //center
        if (A[1][1] == 1 && A[1][2] == 1 && A[2][1] == 1 && A[2][2] == 1 &&
                (checked[1][1] == 0 || checked[1][2] == 0 || checked[2][1] == 0 || checked[2][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            if(output == ""){
                output += "BD";
            }else output += "+BD";
        }

        //center-top
        if (A[0][1] == 1 && A[0][2] == 1 && A[1][1] == 1 && A[1][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            if(output == ""){
                output += "A'D";
            }else output += "+A'D";
        }

        //center-bottom
        if (A[2][1] == 1 && A[2][2] == 1 && A[3][1] == 1 && A[3][2] == 1 &&
                (checked[2][1] == 0 || checked[2][2] == 0 || checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            if(output == ""){
                output += "AD";
            }else output += "+AD";
        }

        //center-left
        if (A[1][0] == 1 && A[2][0] == 1 && A[1][1] == 1 && A[2][1] == 1 &&
                (checked[1][0] == 0 || checked[2][0] == 0 || checked[1][1] == 0 || checked[2][1] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[1][1] = 1;
            checked[2][1] = 1;
            if(output == ""){
                output += "BC'";
            }else output += "+BC'";
        }

        //center-right
        if (A[1][2] == 1 && A[2][2] == 1 && A[1][3] == 1 && A[2][3] == 1 &&
                (checked[1][2] == 0 || checked[2][2] == 0 || checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][2] = 1;
            checked[2][2] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            if(output == ""){
                output += "BC";
            }else output += "+BC";
        }

        //corners
        if (A[0][0] == 1 && A[0][3] == 1 && A[3][0] == 1 && A[3][3] == 1 &&
                (checked[0][0] == 0 || checked[0][3] == 0 || checked[2][1] == 0 || checked[2][2] == 0)) {
            checked[0][0] = 1;
            checked[0][3] = 1;
            checked[3][0] = 1;
            checked[3][3] = 1;
            if(output == ""){
                output += "B'D'";
            }else output += "+B'D'";
        }

        //left-right-top
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][3] == 1 && A[1][3] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[0][3] = 1;
            checked[1][3] = 1;
            if(output == ""){
                output += "A'D'";
            }else output += "+A'D'";
        }

        //left-right-bottom
        if (A[2][0] == 1 && A[3][0] == 1 && A[2][3] == 1 && A[3][3] == 1 &&
                (checked[2][0] == 0 || checked[3][0] == 0 || checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[2][3] = 1;
            checked[3][3] = 1;
            if(output == ""){
                output += "AD'";
            }else output += "+AD'";
        }

        //left-right-center
        if (A[1][0] == 1 && A[2][0] == 1 && A[1][3] == 1 && A[2][3] == 1 &&
                (checked[1][0] == 0 || checked[2][0] == 0 || checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            if(output == ""){
                output += "BD'";
            }else output += "+BD'";
        }

        //top-bottom-left
        if (A[0][0] == 1 && A[0][1] == 1 && A[3][0] == 1 && A[3][1] == 1 &&
                (checked[0][0] == 0 || checked[0][1] == 0 || checked[3][0] == 0 || checked[3][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[3][0] = 1;
            checked[3][1] = 1;
            if(output == ""){
                output += "B'C'";
            }else output += "+B'C'";
            output += "B'C'";
        }

        //top-bottom-right
        if (A[0][2] == 1 && A[0][3] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[3][0] = 1;
            checked[3][1] = 1;
            if(output == ""){
                output += "B'C";
            }else output += "+B'C";
        }

        //top-bottom-center
        if (A[0][1] == 1 && A[0][2] == 1 && A[3][1] == 1 && A[3][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            if(output == ""){
                output += "B'D";
            }else output += "+B'D";
        }


    }

    private void check2() {
        // top (left-right)
        if (A[0][0] == 1 && A[0][1] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            if(output == ""){
                output += "A'B'C'";
            }else output += "+A'B'C'";
        }
        if (A[0][1] == 1 && A[0][2] == 1 && (checked[0][1] == 0 || checked[0][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            if(output == ""){
                output += "A'B'D";
            }else output += "+A'B'D";
        }
        if (A[0][2] == 1 && A[0][3] == 1 && (checked[0][2] == 0 || checked[0][3] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            if(output == ""){
                output += "A'B'C";
            }else output += "+A'B'C";
        }
        if (A[0][3] == 1 && A[0][0] == 1 && (checked[0][3] == 0 || checked[0][0] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            if(output == ""){
                output += "A'B'D'";
            }else output += "+A'B'D'";
        }

        //top_center (left-right)
        if (A[1][0] == 1 && A[1][1] == 1 && (checked[1][0] == 0 || checked[1][1] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            if(output == ""){
                output += "A'BC'";
            }else output += "+A'BC'";
        }
        if (A[1][1] == 1 && A[1][2] == 1 && (checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
            if(output == ""){
                output += "A'BD";
            }else output += "+A'BD";
        }
        if (A[1][2] == 1 && A[1][3] == 1 && (checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            if(output == ""){
                output += "A'BC";
            }else output += "+A'BC";
        }
        if (A[1][3] == 1 && A[1][0] == 1 && (checked[1][3] == 0 || checked[1][0] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            if(output == ""){
                output += "A'BD'";
            }else output += "+A'BD'";
        }

        //bot_center (left-right)
        if (A[2][0] == 1 && A[2][1] == 1 && (checked[2][0] == 0 || checked[2][1] == 0)) {
            checked[2][0] = 1;
            checked[2][1] = 1;
            if(output == ""){
                output += "ABC'";
            }else output += "+ABC'";
        }
        if (A[2][1] == 1 && A[2][2] == 1 && (checked[2][1] == 0 || checked[2][2] == 0)) {
            checked[2][1] = 1;
            checked[2][2] = 1;
            if(output == ""){
                output += "ABD";
            }else output += "+ABD";
        }
        if (A[2][2] == 1 && A[2][3] == 1 && (checked[2][2] == 0 || checked[2][3] == 0)) {
            checked[2][2] = 1;
            checked[2][3] = 1;
            if(output == ""){
                output += "ABC";
            }else output += "+ABC";
        }
        if (A[2][3] == 1 && A[2][0] == 1 && (checked[2][3] == 0 || checked[2][0] == 0)) {
            checked[2][3] = 1;
            checked[2][0] = 1;
            if(output == ""){
                output += "ABD'";
            }else output += "+ABD'";
        }

        //bot (left-right)
        if (A[3][0] == 1 && A[3][1] == 1 && (checked[3][0] == 0 || checked[3][1] == 0)) {
            checked[3][0] = 1;
            checked[3][1] = 1;
            if(output == ""){
                output += "AB'C'";
            }else output += "+AB'C'";
        }
        if (A[3][1] == 1 && A[3][2] == 1 && (checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[3][1] = 1;
            checked[3][2] = 1;
            if(output == ""){
                output += "A'B'D";
            }else output += "+A'B'D";
        }
        if (A[3][2] == 1 && A[3][3] == 1 && (checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[3][2] = 1;
            checked[3][3] = 1;
            if(output == ""){
                output += "AB'C";
            }else output += "+AB'C";
        }
        if (A[3][3] == 1 && A[3][0] == 1 && (checked[3][3] == 0 || checked[3][0] == 0)) {
            checked[3][0] = 1;
            checked[3][3] = 1;
            if(output == ""){
                output += "AB'D'";
            }else output += "+AB'D'";
        }

        //left (top-bot)
        if (A[0][0] == 1 && A[1][0] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            if(output == ""){
                output += "A'C'D'";
            }else output += "+A'C'D'";
        }
        if (A[1][0] == 1 && A[2][0] == 1 && (checked[1][0] == 0 || checked[2][0] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
            if(output == ""){
                output += "BC'D'";
            }else output += "+BC'D'";
        }
        if (A[2][0] == 1 && A[3][0] == 1 && (checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
            if(output == ""){
                output += "AC'D'";
            }else output += "AC'D'";;
        }
        if (A[3][0] == 1 && A[0][0] == 1 && (checked[3][0] == 0 || checked[0][0] == 0)) {
            checked[3][0] = 1;
            checked[0][0] = 1;
            if(output == ""){
                output += "B'C'D'";
            }else output += "+B'C'D'";
        }

        //left_center (top-bot)
        if (A[0][1] == 1 && A[1][1] == 1 && (checked[0][1] == 0 || checked[1][1] == 0)) {
            checked[0][1] = 1;
            checked[1][1] = 1;
            if(output == ""){
                output += "A'C'D";
            }else output += "+A'C'D";
        }
        if (A[1][1] == 1 && A[2][1] == 1 && (checked[1][1] == 0 || checked[2][1] == 0)) {
            checked[1][1] = 1;
            checked[2][1] = 1;
            if(output == ""){
                output += "A'B'C'";
            }else output += "+A'B'C'";
        }
        if (A[2][1] == 1 && A[3][1] == 1 && (checked[2][1] == 0 || checked[3][1] == 0)) {
            checked[2][1] = 1;
            checked[3][1] = 1;
            if(output == ""){
                output += "BC'D";
            }else output += "+BC'D";
        }
        if (A[3][1] == 1 && A[0][1] == 1 && (checked[3][1] == 0 || checked[0][1] == 0)) {
            checked[3][1] = 1;
            checked[0][1] = 1;
            if(output == ""){
                output += "B'C'D";
            }else output += "+B'C'D";
        }

        //right_center(top-bot)
        if (A[0][2] == 1 && A[1][2] == 1 && (checked[0][2] == 0 || checked[1][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            if(output == ""){
                output += "A'CD";
            }else output += "+A'CD";
        }
        if (A[1][0] == 1 && A[2][0] == 1 && (checked[1][0] == 0 || checked[2][0] == 0)) {
            checked[1][2] = 1;
            checked[2][2] = 1;
            if(output == ""){
                output += "BCD";
            }else output += "+BCD";
        }
        if (A[2][0] == 1 && A[3][0] == 1 && (checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[2][2] = 1;
            checked[3][2] = 1;
            if(output == ""){
                output += "ACD";
            }else output += "+ACD";
        }
        if (A[3][0] == 1 && A[0][0] == 1 && (checked[3][0] == 0 || checked[0][0] == 0)) {
            checked[3][2] = 1;
            checked[0][2] = 1;
            if(output == ""){
                output += "B'CD";
            }else output += "+B'CD";
        }

        //right (top-bot)
        if (A[0][3] == 1 && A[1][3] == 1 && (checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
            if(output == ""){
                output += "A'CD'";
            }else  output += "+A'CD'";
        }
        if (A[1][3] == 1 && A[2][3] == 1 && (checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][3] = 1;
            checked[2][3] = 1;
            if(output == ""){
                output += "BC'D'";
            }else  output += "+BC'D'";
        }
        if (A[2][3] == 1 && A[3][3] == 1 && (checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[2][3] = 1;
            checked[3][3] = 1;
            if(output == ""){
                output += "ACD'";
            }else  output += "+ACD'";
        }
        if (A[3][3] == 1 && A[0][3] == 1 && (checked[3][3] == 0 || checked[0][3] == 0)) {
            checked[3][3] = 1;
            checked[0][3] = 1;
            if(output == ""){
                output += "B'CD'";
            }else   output += "+B'CD'";
        }
    }

    private void nogrouping() {
        if(A[0][0] == 1){
            if(output == ""){
                output += "A'B'C'D'";
            }else output += "+A'B'C'D'";
        }
        if(A[0][1] == 1){
            if(output == ""){
                output += "A'B'C'D";
            }else output += "+A'B'C'D";
        }
        if(A[0][2] == 1){
            if(output == ""){
                output += "A'B'CD";
            }else output += "+A'B'CD";
        }
        if(A[0][3] == 1){
            if(output == ""){
                output += "A'B'CD'";
            }else output += "+A'B'CD'";;

        }
        if(A[1][0] == 1){
            if(output == ""){
                output += "A'BC'D'";
            }else output += "+A'BC'D'";
        }
        if(A[1][1] == 1){
            if(output == ""){
                output += "A'BCD";
            }else output += "+A'BCD";
        }
        if(A[1][2] == 1){
            if(output == ""){
                output += "A'BCD";
            }else output += "+A'BCD";
        }
        if(A[1][3] == 1){
            if(output == ""){
                output += "A'BCD'";
            }else output += "+A'BCD'";
        }
        if(A[2][0] == 1){
            if(output == ""){
                output += "ABC'D'";
            }else output += "+ABC'D'";

        }
        if(A[2][1] == 1){
            if(output == ""){
                output += "ABC'D";
            }else  output += "+ABC'D";

        }
        if(A[2][2] == 1){
            if(output == ""){
                output += "ABCD";
            }else output += "+ABCD";
        }
        if(A[2][3] == 1){
            if(output == ""){
                output += "ABCD'";
            }else  output += "+ABCD'";

        }
        if(A[3][0] == 1){
            if(output == ""){
                output += "AB'C'D'";
            }else  output += "+AB'C'D'";
        }
        if(A[3][1] == 1){
            if(output == ""){
                output += "AB'C'D";
            }else output += "+AB'C'D";
        }
        if(A[3][2] == 1){
            if(output == ""){
                output += "AB'CD";
            }else output += "+AB'CD";
        }
        if(A[3][3] == 1){
            if(output == ""){
                output += "AB'CD'";
            }else  output += "+AB'CD'";
        }
    }
}
