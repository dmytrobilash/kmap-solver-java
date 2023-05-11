package com.dmytrobilash.karnaughmap_java.model.SoP;

public class FourVariablesSoP {

    private String groups = "";
    private String output = "";
    private final int[][] A = new int[4][4];
    private final int[][] checked = new int[4][4];

    public FourVariablesSoP(int[] val) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
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
            groups+="[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]";
        } else if (checkAllZero()) {
            output = "0";
            groups +="";
        } else {
            check8();
            check4();
            check2();
            nogrouping();
        }
        return output;
    }
    public String getGroups(){
        solve();
        return groups;
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
            if(output.equals("")){
                output += "A'";
            }else output += "+A'";
            groups+="[0,1,2,3,4,5,6,7]";
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
            if(output.equals("")){
                output += "A";
            }else output += "+A";
            groups+="[8,9,10,11,12,13,14,15]";
        }

        //center_horizontal
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
            if(output.equals("")){
                output += "B";
            }else output += "+B";
            groups+="[4,5,6,7,8,9,10,11]";
        }

        //sides_horizontal
        if (A[0][0] == 1 && A[0][1] == 1 && A[0][2] == 1 && A[0][3] == 1 &&
                A[3][0] == 1 && A[3][1] == 1 && A[3][2] == 1 && A[3][3] == 1) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[3][0] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "B'";
            }else output += "+B'";
            groups+="[1,2,3,4,12,13,14,15]";
        }

        //left
        if (A[0][0] == 1 && A[1][0] == 1 && A[2][0] == 1 && A[3][0] == 1 &&
                A[0][1] == 1 && A[1][1] == 1 && A[2][1] == 1 && A[3][1] == 1) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[0][1] = 1;
            checked[1][1] = 1;
            checked[2][1] = 1;
            checked[3][1] = 1;
            if(output.equals("")){
                output += "C'";
            }else output += "+C'";
            groups+="[1,4,8,12,1,5,9,13]";
        }

        //right
        if (A[0][2] == 1 && A[1][2] == 1 && A[2][2] == 1 && A[3][2] == 1 &&
                A[0][3] == 1 && A[1][3] == 1 && A[2][3] == 1 && A[3][3] == 1) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            checked[2][2] = 1;
            checked[3][2] = 1;
            checked[0][3] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "C";
            }else output += "+C";
            groups+="[2,6,10,14,3,7,11,15]";
        }

        //center_vertical
        if (A[0][1] == 1 && A[1][1] == 1 && A[2][1] == 1 && A[3][1] == 1 &&
                A[0][2] == 1 && A[1][2] == 1 && A[2][2] == 1 && A[3][2] == 1) {
            checked[0][1] = 1;
            checked[1][1] = 1;
            checked[2][1] = 1;
            checked[3][1] = 1;
            checked[0][2] = 1;
            checked[1][2] = 1;
            checked[2][2] = 1;
            checked[3][2] = 1;
            if(output.equals("")){
                output += "D";
            }else output += "+D";
            groups+="[1,5,9,13,2,6,10,14]";
        }

        //sides_vertical
        if (A[0][0] == 1 && A[1][0] == 1 && A[2][0] == 1 && A[3][0] == 1 &&
                A[0][3] == 1 && A[1][3] == 1 && A[2][3] == 1 && A[3][3] == 1) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[0][3] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "D'";
            }else output += "+D'";
            groups+="[0,4,8,12,3,7,11,15]";
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
            if(output.equals("")){
                output += "A'B'";
            }else output += "+A'B'";
            groups+="[0,1,2,3]";
        }

        //center_top
        if (A[1][0] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[1][0] == 0 || checked[1][1] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "A'B";
            }else output += "+A'B";
            groups+="[4,5,6,7]";
        }

        //center_bottom
        if (A[2][0] == 1 && A[2][1] == 1 && A[2][2] == 1 && A[2][3] == 1 &&
                (checked[2][0] == 0 || checked[2][1] == 0 || checked[2][2] == 0 || checked[2][3] == 0)) {

            checked[2][0] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[2][3] = 1;
            if(output.equals("")){
                output += "AB";
            }else output += "+AB";
            groups+="[8,9,10,11]";
        }

        //bottom
        if (A[3][0] == 1 && A[3][1] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[3][0] == 0 || checked[3][1] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {

            checked[3][0] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "AB'";
            }else output += "+AB'";
            groups+="[12,13,14,15]";
        }

        //left
        if (A[0][0] == 1 && A[1][0] == 1 && A[2][0] == 1 && A[3][0] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[3][0] = 1;
            if(output.equals("")){
                output += "С'D'";
            }else output += "+C'D'";
            groups+="[0,4,8,12]";
        }

        //left_center
        if (A[0][1] == 1 && A[1][1] == 1 && A[2][1] == 1 && A[3][1] == 1 &&
                (checked[0][1] == 0 || checked[1][1] == 0 || checked[2][1] == 0 || checked[3][1] == 0)) {

            checked[0][1] = 1;
            checked[1][1] = 1;
            checked[2][1] = 1;
            checked[3][1] = 1;
            if(output.equals("")){
                output += "С'D";
            }else output += "+C'D";
            groups+="[1,5,9,13]";
        }

        //right_center
        if (A[0][2] == 1 && A[1][2] == 1 && A[2][2] == 1 && A[3][2] == 1 &&
                (checked[0][2] == 0 || checked[1][2] == 0 || checked[2][2] == 0 || checked[3][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            checked[2][2] = 1;
            checked[3][2] = 1;
            if(output.equals("")){
                output += "СD";
            }else output += "+CD";
            groups+="[2,6,10,14]";
        }

        //right
        if (A[0][3] == 1 && A[1][3] == 1 && A[2][3] == 1 && A[3][3] == 1 &&
                (checked[0][3] == 0 || checked[1][3] == 0 || checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "СD'";
            }else output += "+CD'";
            groups+="[3,7,11,15]";
        }

        //top_left
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][1] == 1 && A[1][1] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][1] == 0 || checked[1][1] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[0][1] = 1;
            checked[1][1] = 1;
            if(output.equals("")){
                output += "A'C'";
            }else output += "+A'C'";
            groups+="[0,1,4,5]";
        }

        //top_right
        if (A[0][2] == 1 && A[0][3] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "A'C";
            }else output += "+A'C";
            groups+="[2,6,3,7]";
        }

        //bottom_left
        if (A[2][0] == 1 && A[3][0] == 1 && A[2][1] == 1 && A[3][1] == 1 &&
                (checked[2][0] == 0 || checked[3][0] == 0 || checked[2][1] == 0 || checked[3][1] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[2][1] = 1;
            checked[3][1] = 1;
            if(output.equals("")){
                output += "AC'";
            }else output += "+AC'";
            groups+="[8,9,12,13]";
        }

        //bottom_right
        if (A[2][2] == 1 && A[2][3] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[2][2] == 0 || checked[2][3] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[2][2] = 1;
            checked[2][3] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "AC";
            }else output += "+AC";
            groups+="[10,14,11,15]";
        }

        //center
        if (A[1][1] == 1 && A[1][2] == 1 && A[2][1] == 1 && A[2][2] == 1 &&
                (checked[1][1] == 0 || checked[1][2] == 0 || checked[2][1] == 0 || checked[2][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[2][1] = 1;
            checked[2][2] = 1;
            if(output.equals("")){
                output += "BD";
            }else output += "+BD";
            groups+="[5,6,9,10]";
        }

        //center-top
        if (A[0][1] == 1 && A[0][2] == 1 && A[1][1] == 1 && A[1][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            if(output.equals("")){
                output += "A'D";
            }else output += "+A'D";
            groups+="[1,2,5,6]";
        }

        //center-bottom
        if (A[2][1] == 1 && A[2][2] == 1 && A[3][1] == 1 && A[3][2] == 1 &&
                (checked[2][1] == 0 || checked[2][2] == 0 || checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[2][1] = 1;
            checked[2][2] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            if(output.equals("")){
                output += "AD";
            }else output += "+AD";
            groups+="[9,10,13,14]";
        }

        //center-left
        if (A[1][0] == 1 && A[2][0] == 1 && A[1][1] == 1 && A[2][1] == 1 &&
                (checked[1][0] == 0 || checked[2][0] == 0 || checked[1][1] == 0 || checked[2][1] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[1][1] = 1;
            checked[2][1] = 1;
            if(output.equals("")){
                output += "BC'";
            }else output += "+BC'";
            groups+="[4,5,8,9]";
        }

        //center-right
        if (A[1][2] == 1 && A[2][2] == 1 && A[1][3] == 1 && A[2][3] == 1 &&
                (checked[1][2] == 0 || checked[2][2] == 0 || checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][2] = 1;
            checked[2][2] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            if(output.equals("")){
                output += "BC";
            }else output += "+BC";
            groups+="[6,7,10,11]";
        }

        //corners
        if (A[0][0] == 1 && A[0][3] == 1 && A[3][0] == 1 && A[3][3] == 1 &&
                (checked[0][0] == 0 || checked[0][3] == 0 || checked[3][0] == 0 || checked[3][3] == 0)) {
            checked[0][0] = 1;
            checked[0][3] = 1;
            checked[3][0] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "B'D'";
            }else output += "+B'D'";
            groups+="[0,3,12,15]";
        }

        //left-right-top
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][3] == 1 && A[1][3] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[0][3] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "A'D'";
            }else output += "+A'D'";
            groups+="[0,4,3,7]";
        }

        //left-right-bottom
        if (A[2][0] == 1 && A[3][0] == 1 && A[2][3] == 1 && A[3][3] == 1 &&
                (checked[2][0] == 0 || checked[3][0] == 0 || checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
            checked[2][3] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "AD'";
            }else output += "+AD'";
            groups+="[8,12,11,15]";
        }

        //left-right-center
        if (A[1][0] == 1 && A[2][0] == 1 && A[1][3] == 1 && A[2][3] == 1 &&
                (checked[1][0] == 0 || checked[2][0] == 0 || checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
            checked[1][3] = 1;
            checked[2][3] = 1;
            if(output.equals("")){
                output += "BD'";
            }else output += "+BD'";
            groups+="[4,8,7,11]";
        }

        //top-bottom-left
        if (A[0][0] == 1 && A[0][1] == 1 && A[3][0] == 1 && A[3][1] == 1 &&
                (checked[0][0] == 0 || checked[0][1] == 0 || checked[3][0] == 0 || checked[3][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[3][0] = 1;
            checked[3][1] = 1;
            if(output.equals("")){
                output += "B'C'";
            }else output += "+B'C'";
            groups+="[0,1,12,13]";
        }

        //top-bottom-right
        if (A[0][2] == 1 && A[0][3] == 1 && A[3][2] == 1 && A[3][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[3][2] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "B'C";
            }else output += "+B'C";
            groups+="[2,3,14,15]";
        }

        //top-bottom-center
        if (A[0][1] == 1 && A[0][2] == 1 && A[3][1] == 1 && A[3][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[3][1] = 1;
            checked[3][2] = 1;
            if(output.equals("")){
                output += "B'D";
            }else output += "+B'D";
            groups+="[1,2,13,14]";
        }
    }

    private void check2() {

        // top (left-right)
        if (A[0][0] == 1 && A[0][1] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            if(output.equals("")){
                output += "A'B'C'";
            }else output += "+A'B'C'";
            groups+="[0,1]";
        }
        if (A[0][1] == 1 && A[0][2] == 1 && (checked[0][1] == 0 || checked[0][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            if(output.equals("")){
                output += "A'B'D";
            }else output += "+A'B'D";
            groups+="[1,2]";
        }
        if (A[0][2] == 1 && A[0][3] == 1 && (checked[0][2] == 0 || checked[0][3] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            if(output.equals("")){
                output += "A'B'C";
            }else output += "+A'B'C";
            groups+="[2,3]";
        }
        if (A[0][3] == 1 && A[0][0] == 1 && (checked[0][3] == 0 || checked[0][0] == 0)) {
            checked[0][3] = 1;
            checked[0][0] = 1;
            if(output.equals("")){
                output += "A'B'D'";
            }else output += "+A'B'D'";
            groups+="[0,3]";
        }

        //top_center (left-right)
        if (A[1][0] == 1 && A[1][1] == 1 && (checked[1][0] == 0 || checked[1][1] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            if(output.equals("")){
                output += "A'BC'";
            }else output += "+A'BC'";
            groups+="[4,5]";
        }
        if (A[1][1] == 1 && A[1][2] == 1 && (checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
            if(output.equals("")){
                output += "A'BD";
            }else output += "+A'BD";
            groups+="[5,6]";
        }
        if (A[1][2] == 1 && A[1][3] == 1 && (checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[1][2] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "A'BC";
            }else output += "+A'BC";
            groups+="[6,7]";
        }
        if (A[1][3] == 1 && A[1][0] == 1 && (checked[1][3] == 0 || checked[1][0] == 0)) {
            checked[1][3] = 1;
            checked[1][0] = 1;
            if(output.equals("")){
                output += "A'BD'";
            }else output += "+A'BD'";
            groups+="[4,7]";
        }

        //bot_center (left-right)
        if (A[2][0] == 1 && A[2][1] == 1 && (checked[2][0] == 0 || checked[2][1] == 0)) {
            checked[2][0] = 1;
            checked[2][1] = 1;
            if(output.equals("")){
                output += "ABC'";
            }else output += "+ABC'";
            groups+="[8,9]";
        }
        if (A[2][1] == 1 && A[2][2] == 1 && (checked[2][1] == 0 || checked[2][2] == 0)) {
            checked[2][1] = 1;
            checked[2][2] = 1;
            if(output.equals("")){
                output += "ABD";
            }else output += "+ABD";
            groups+="[9,10]";
        }
        if (A[2][2] == 1 && A[2][3] == 1 && (checked[2][2] == 0 || checked[2][3] == 0)) {
            checked[2][2] = 1;
            checked[2][3] = 1;
            if(output.equals("")){
                output += "ABC";
            }else output += "+ABC";
            groups+="[10,11]";
        }
        if (A[2][3] == 1 && A[2][0] == 1 && (checked[2][3] == 0 || checked[2][0] == 0)) {
            checked[2][3] = 1;
            checked[2][0] = 1;
            if(output.equals("")){
                output += "ABD'";
            }else output += "+ABD'";
            groups+="[8,11]";
        }

        //bot (left-right)
        if (A[3][0] == 1 && A[3][1] == 1 && (checked[3][0] == 0 || checked[3][1] == 0)) {
            checked[3][0] = 1;
            checked[3][1] = 1;
            if(output.equals("")){
                output += "AB'C'";
            }else output += "+AB'C'";
            groups+="[12,13]";
        }
        if (A[3][1] == 1 && A[3][2] == 1 && (checked[3][1] == 0 || checked[3][2] == 0)) {
            checked[3][1] = 1;
            checked[3][2] = 1;
            if(output.equals("")){
                output += "A'B'D";
            }else output += "+A'B'D";
            groups+="[13,14]";
        }
        if (A[3][2] == 1 && A[3][3] == 1 && (checked[3][2] == 0 || checked[3][3] == 0)) {
            checked[3][2] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "AB'C";
            }else output += "+AB'C";
            groups+="[14,15]";
        }
        if (A[3][3] == 1 && A[3][0] == 1 && (checked[3][3] == 0 || checked[3][0] == 0)) {
            checked[3][0] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "AB'D'";
            }else output += "+AB'D'";
            groups+="[12,15]";
        }

        //left (top-bot)
        if (A[0][0] == 1 && A[1][0] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            if(output.equals("")){
                output += "A'C'D'";
            }else output += "+A'C'D'";
            groups+="[0,4]";
        }
        if (A[1][0] == 1 && A[2][0] == 1 && (checked[1][0] == 0 || checked[2][0] == 0)) {
            checked[1][0] = 1;
            checked[2][0] = 1;
            if(output.equals("")){
                output += "BC'D'";
            }else output += "+BC'D'";
            groups+="[4,8]";
        }
        if (A[2][0] == 1 && A[3][0] == 1 && (checked[2][0] == 0 || checked[3][0] == 0)) {
            checked[2][0] = 1;
            checked[3][0] = 1;
            if(output.equals("")){
                output += "AC'D'";
            }else output += "+AC'D'";
            groups+="[8,12]";
        }
        if (A[3][0] == 1 && A[0][0] == 1 && (checked[3][0] == 0 || checked[0][0] == 0)) {
            checked[3][0] = 1;
            checked[0][0] = 1;
            if(output.equals("")){
                output += "B'C'D'";
            }else output += "+B'C'D'";
            groups+="[0,12]";
        }

        //left_center (top-bot)
        if (A[0][1] == 1 && A[1][1] == 1 && (checked[0][1] == 0 || checked[1][1] == 0)) {
            checked[0][1] = 1;
            checked[1][1] = 1;
            if(output.equals("")){
                output += "A'C'D";
            }else output += "+A'C'D";
            groups+="[1,5]";
        }
        if (A[1][1] == 1 && A[2][1] == 1 && (checked[1][1] == 0 || checked[2][1] == 0)) {
            checked[1][1] = 1;
            checked[2][1] = 1;
            if(output.equals("")){
                output += "A'B'C'";
            }else output += "+A'B'C'";
            groups+="[5,9]";
        }
        if (A[2][1] == 1 && A[3][1] == 1 && (checked[2][1] == 0 || checked[3][1] == 0)) {
            checked[2][1] = 1;
            checked[3][1] = 1;
            if(output.equals("")){
                output += "BC'D";
            }else output += "+BC'D";
            groups+="[9,13]";
        }
        if (A[3][1] == 1 && A[0][1] == 1 && (checked[3][1] == 0 || checked[0][1] == 0)) {
            checked[3][1] = 1;
            checked[0][1] = 1;
            if(output.equals("")){
                output += "B'C'D";
            }else output += "+B'C'D";
            groups+="[1,13]";
        }

        //right_center(top-bot)
        if (A[0][2] == 1 && A[1][2] == 1 && (checked[0][2] == 0 || checked[1][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            if(output.equals("")){
                output += "A'CD";
            }else output += "+A'CD";
            groups+="[2,6]";
        }
        if (A[1][2] == 1 && A[2][2] == 1 && (checked[1][2] == 0 || checked[2][2] == 0)) {
            checked[1][2] = 1;
            checked[2][2] = 1;
            if(output.equals("")){
                output += "BCD";
            }else output += "+BCD";
            groups+="[6,10]";
        }
        if (A[2][2] == 1 && A[3][2] == 1 && (checked[2][2] == 0 || checked[3][2] == 0)) {
            checked[2][2] = 1;
            checked[3][2] = 1;
            if(output.equals("")){
                output += "ACD";
            }else output += "+ACD";
            groups+="[10,14]";
        }
        if (A[3][2] == 1 && A[0][2] == 1 && (checked[3][2] == 0 || checked[0][2] == 0)) {
            checked[3][2] = 1;
            checked[0][2] = 1;
            if(output.equals("")){
                output += "B'CD";
            }else output += "+B'CD";
            groups+="[2,14]";
        }

        //right (top-bot)
        if (A[0][3] == 1 && A[1][3] == 1 && (checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
            if(output.equals("")){
                output += "A'CD'";
            }else  output += "+A'CD'";
            groups+="[3,7]";
        }
        if (A[1][3] == 1 && A[2][3] == 1 && (checked[1][3] == 0 || checked[2][3] == 0)) {
            checked[1][3] = 1;
            checked[2][3] = 1;
            if(output.equals("")){
                output += "BC'D'";
            }else  output += "+BC'D'";
            groups+="[7,11]";
        }
        if (A[2][3] == 1 && A[3][3] == 1 && (checked[2][3] == 0 || checked[3][3] == 0)) {
            checked[2][3] = 1;
            checked[3][3] = 1;
            if(output.equals("")){
                output += "ACD'";
            }else  output += "+ACD'";
            groups+="[11,15]";
        }
        if (A[3][3] == 1 && A[0][3] == 1 && (checked[3][3] == 0 || checked[0][3] == 0)) {
            checked[3][3] = 1;
            checked[0][3] = 1;
            if(output.equals("")){
                output += "B'CD'";
            }else   output += "+B'CD'";
            groups+="[3,15]";
        }
    }

    private void nogrouping() {
        if(A[0][0] == 1 && checked[0][0] == 0){
            if(output.equals("")){
                output += "A'B'C'D'";
            }else output += "+A'B'C'D'";
            groups+="[0]";
        }
        if(A[0][1] == 1 && checked[0][1] == 0){
            if(output.equals("")){
                output += "A'B'C'D";
            }else output += "+A'B'C'D";
            groups+="[1]";
        }
        if(A[0][2] == 1 && checked[0][2] == 0){
            if(output.equals("")){
                output += "A'B'CD";
            }else output += "+A'B'CD";
            groups+="[2]";
        }
        if(A[0][3] == 1 && checked[0][3] == 0){
            if(output.equals("")){
                output += "A'B'CD'";
            }else output += "+A'B'CD'";
            groups+="[3]";
        }
        if(A[1][0] == 1 && checked[1][0] == 0){
            if(output.equals("")){
                output += "A'BC'D'";
            }else output += "+A'BC'D'";
            groups+="[4]";
        }
        if(A[1][1] == 1 && checked[1][1] == 0){
            if(output.equals("")){
                output += "A'BCD";
            }else output += "+A'BCD";
            groups+="[5]";
        }
        if(A[1][2] == 1 && checked[1][2] == 0){
            if(output.equals("")){
                output += "A'BCD";
            }else output += "+A'BCD";
            groups+="[6]";
        }
        if(A[1][3] == 1 && checked[1][3] == 0){
            if(output.equals("")){
                output += "A'BCD'";
            }else output += "+A'BCD'";
            groups+="[7]";
        }
        if(A[2][0] == 1 && checked[2][0] == 0){
            if(output.equals("")){
                output += "ABC'D'";
            }else output += "+ABC'D'";
            groups+="[8]";
        }
        if(A[2][1] == 1 && checked[2][1] == 0){
            if(output.equals("")){
                output += "ABC'D";
            }else  output += "+ABC'D";
            groups+="[9]";
        }
        if(A[2][2] == 1 && checked[2][2] == 0){
            if(output.equals("")){
                output += "ABCD";
            }else output += "+ABCD";
            groups+="[10]";
        }
        if(A[2][3] == 1 && checked[2][3] == 0){
            if(output.equals("")){
                output += "ABCD'";
            }else  output += "+ABCD'";
            groups+="[11]";
        }
        if(A[3][0] == 1 && checked[3][0] == 0){
            if(output.equals("")){
                output += "AB'C'D'";
            }else  output += "+AB'C'D'";
            groups+="[12]";
        }
        if(A[3][1] == 1 && checked[3][1] == 0){
            if(output.equals("")){
                output += "AB'C'D";
            }else output += "+AB'C'D";
            groups+="[13]";
        }
        if(A[3][2] == 1 && checked[3][2] == 0){
            if(output.equals("")){
                output += "AB'CD";
            }else output += "+AB'CD";
            groups+="[14]";
        }
        if(A[3][3] == 1 && checked[3][3] == 0){
            if(output.equals("")){
                output += "AB'CD'";
            }else  output += "+AB'CD'";
            groups+="[15]";
        }
    }
}
