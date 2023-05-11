package com.hfad.karnaughmap_java.model.PoS;

public class ThreeVariablesPoS {

    private String output = "";
    private final int[][] A = new int[2][4];
    private final int[][] checked = new int[2][4];

    public ThreeVariablesPoS(int[] val) {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if(val[count] == 2){
                    A[i][j] = 1;
                    checked[i][j] = 1;
                }
                else{
                    A[i][j] = val[count];
                    checked[i][j] = 0;
                }
                count++;
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
            output += "A'";
        }

        //bottom
        if (A[1][0] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[1][0] == 0 || checked[1][1] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "A";
            }else output += "+A";

        }

        //left
        if (A[0][0] == 1 && A[0][1] == 1 && A[1][0] == 1 && A[1][1] == 1 &&
                (checked[0][0] == 0 || checked[0][1] == 0 || checked[1][0] == 0 || checked[1][1] == 0)) {

            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[1][0] = 1;
            checked[1][1] = 1;
            if(output.equals("")){
                output += "B'";
            }else output += "+B'";
        }

        //right
        if (A[0][2] == 1 && A[0][3] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "B";
            }else output += "+B";
        }

        //center
        if (A[0][1] == 1 && A[0][2] == 1 && A[1][1] == 1 && A[1][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            if(output.equals("")){
                output += "C";
            }else output += "+C";
        }

        //sides
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][3] == 1 && A[1][3] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[0][3] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "C'";
            }else  output += "+C'";
        }
    }

    private void check2() {

        if (A[0][0] == 1 && A[1][0] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            if(output.equals("")){
                output += "B'C'";
            }else output += "+B'C'";


        }
        if (A[0][1] == 1 && A[1][1] == 1 && (checked[0][1] == 0 || checked[1][1] == 0)) {
            checked[0][1] = 1;
            checked[1][1] = 1;
            if(output.equals("")){
                output += "B'C";
            }else  output += "+B'C";


        }
        if (A[0][2] == 1 && A[1][2] == 1 && (checked[0][2] == 0 || checked[1][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            if(output.equals("")){
                output += "BC";
            }else  output += "+BC";


        }
        if (A[0][3] == 1 && A[1][3] == 1 && (checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "BC'";
            }else output += "+BC'";

        }

        if (A[0][0] == 1 && A[0][1] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            if(output.equals("")){
                output += "A'B'";
            }else output += "+A'B'";
        }

        if (A[0][1] == 1 && A[0][2] == 1 && (checked[0][1] == 0 || checked[0][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            if(output.equals("")){
                output += "A'C";
            }else output += "+A'C";
        }

        if (A[0][2] == 1 && A[0][3] == 1 && (checked[0][2] == 0 || checked[0][3] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            if(output.equals("")){
                output += "A'B";
            }else  output += "+A'B";

        }

        if (A[0][0] == 1 && A[0][3] == 1 && (checked[0][0] == 0 || checked[0][3] == 0)) {
            checked[0][0] = 1;
            checked[0][3] = 1;
            if(output.equals("")){
                output += "A'C'";
            }else output += "+A'C'";


        }
        if (A[1][0] == 1 && A[1][1] == 1 && (checked[1][0] == 0 || checked[1][1] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            if(output.equals("")){
                output += "AB'";
            }else output += "+AB'";

        }
        if (A[1][1] == 1 && A[1][2] == 1 && (checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
            if(output.equals("")){
                output += "AC";
            }else output += "+AC";

        }
        if (A[1][2] == 1 && A[1][3] == 1 && (checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[1][2] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "AB";
            }else output += "+AB";

        }
        if (A[1][0] == 1 && A[1][3] == 1 && (checked[1][0] == 0 || checked[1][3] == 0)) {
            checked[1][0] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "AC'";
            }else output += "+AC'";

        }
    }

    // no grouping
    private void nogrouping() {
        if (A[0][0] == 1 && checked[0][0] == 0) {
            if(output.equals("")){
                output += "A'B'C'";
            }else output += "+A'B'C'";

        }
        if (A[0][1] == 1 && checked[0][1] == 0) {
            if(output.equals("")){
                output += "A'B'C";
            }else output += "+A'B'C";

        }
        if (A[0][2] == 1 && checked[0][2] == 0) {
            if(output.equals("")){
                output += "A'BC";
            }else output += "+A'BC";

        }
        if (A[0][3] == 1 && checked[0][3] == 0) {
            if(output.equals("")){
                output += "A'BC'";
            }else  output += "+A'BC'";

        }
        if (A[1][0] == 1 && checked[1][0] == 0) {
            if(output.equals("")){
                output += "AB'C'";
            }else  output += "AB'C'";

        }
        if (A[1][1] == 1 && checked[1][1] == 0) {
            if(output.equals("")){
                output += "AB'C";
            }else  output += "+AB'C";

        }
        if (A[1][2] == 1 && checked[1][2] == 0) {
            if(output.equals("")){
                output += "ABC";
            }else  output += "+ABC";

        }
        if (A[1][3] == 1 && checked[1][3] == 0) {
            if(output.equals("")){
                output += "ABC'";
            }else output += "+ABC'";
        }
    }
}