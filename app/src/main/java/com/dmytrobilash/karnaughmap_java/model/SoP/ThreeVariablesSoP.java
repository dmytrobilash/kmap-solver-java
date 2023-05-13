package com.dmytrobilash.karnaughmap_java.model.SoP;

public class ThreeVariablesSoP {

    private String groups = "";
    private String output = "";
    private final int[][] A = new int[2][4];
    private final int[][] checked = new int[2][4];

    public ThreeVariablesSoP(int[] val) {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (val[count] == 2) {
                    A[i][j] = 1;
                    checked[i][j] = 1;
                } else {
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
            groups += "[0,1,2,3,4,5,6,7,8]";
        } else if (checkAllZero()) {
            output = "0";
            groups += "";
        } else {
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
            groups += "[0,1,2,3]";
        }

        //bottom
        if (A[1][0] == 1 && A[1][1] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[1][0] == 0 || checked[1][1] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[1][0] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            if (output.equals("")) {
                output += "A";
            } else output += "+A";
            groups += "[4,5,6,7]";
        }

        //left
        if (A[0][0] == 1 && A[0][1] == 1 && A[1][0] == 1 && A[1][1] == 1 &&
                (checked[0][0] == 0 || checked[0][1] == 0 || checked[1][0] == 0 || checked[1][1] == 0)) {

            checked[0][0] = 1;
            checked[0][1] = 1;
            checked[1][0] = 1;
            checked[1][1] = 1;
            if (output.equals("")) {
                output += "B'";
            } else output += "+B'";
            groups += "[0,1,4,5]";
        }

        //right
        if (A[0][2] == 1 && A[0][3] == 1 && A[1][2] == 1 && A[1][3] == 1 &&
                (checked[0][2] == 0 || checked[0][3] == 0 || checked[1][2] == 0 || checked[1][3] == 0)) {

            checked[0][2] = 1;
            checked[0][3] = 1;
            checked[1][2] = 1;
            checked[1][3] = 1;
            if (output.equals("")) {
                output += "B";
            } else output += "+B";
            groups += "[2,3,6,7]";
        }

        //center
        if (A[0][1] == 1 && A[0][2] == 1 && A[1][1] == 1 && A[1][2] == 1 &&
                (checked[0][1] == 0 || checked[0][2] == 0 || checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            checked[1][1] = 1;
            checked[1][2] = 1;
            if (output.equals("")) {
                output += "C";
            } else output += "+C";
            groups += "[1,2,5,6]";
        }

        //sides
        if (A[0][0] == 1 && A[1][0] == 1 && A[0][3] == 1 && A[1][3] == 1 &&
                (checked[0][0] == 0 || checked[1][0] == 0 || checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            checked[0][3] = 1;
            checked[1][3] = 1;
            if (output.equals("")) {
                output += "C'";
            } else output += "+C'";
            groups += "[0,4,3,7]";
        }
    }

    private void check2() {

        if (A[0][0] == 1 && A[1][0] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)) {
            checked[0][0] = 1;
            checked[1][0] = 1;
            if (output.equals("")) {
                output += "B'C'";
            } else output += "+B'C'";
            groups += "[0,4]";
        }

        if (A[0][1] == 1 && A[1][1] == 1 && (checked[0][1] == 0 || checked[1][1] == 0)) {
            checked[0][1] = 1;
            checked[1][1] = 1;
            if (output.equals("")) {
                output += "B'C";
            } else output += "+B'C";
            groups += "[1,5]";
        }
        if (A[0][2] == 1 && A[1][2] == 1 && (checked[0][2] == 0 || checked[1][2] == 0)) {
            checked[0][2] = 1;
            checked[1][2] = 1;
            if (output.equals("")) {
                output += "BC";
            } else output += "+BC";
            groups += "[2,6]";

        }
        if (A[0][3] == 1 && A[1][3] == 1 && (checked[0][3] == 0 || checked[1][3] == 0)) {
            checked[0][3] = 1;
            checked[1][3] = 1;
            if (output.equals("")) {
                output += "BC'";
            } else output += "+BC'";
            groups += "[3,7]";
        }

        if (A[0][0] == 1 && A[0][1] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)) {
            checked[0][0] = 1;
            checked[0][1] = 1;
            if (output.equals("")) {
                output += "A'B'";
            } else output += "+A'B'";
            groups += "[0,1]";
        }

        if (A[0][1] == 1 && A[0][2] == 1 && (checked[0][1] == 0 || checked[0][2] == 0)) {
            checked[0][1] = 1;
            checked[0][2] = 1;
            if (output.equals("")) {
                output += "A'C";
            } else output += "+A'C";
            groups += "[1,2]";
        }

        if (A[0][2] == 1 && A[0][3] == 1 && (checked[0][2] == 0 || checked[0][3] == 0)) {
            checked[0][2] = 1;
            checked[0][3] = 1;
            if (output.equals("")) {
                output += "A'B";
            } else output += "+A'B";
            groups += "[2,3]";
        }

        if (A[0][0] == 1 && A[0][3] == 1 && (checked[0][0] == 0 || checked[0][3] == 0)) {
            checked[0][0] = 1;
            checked[0][3] = 1;
            if (output.equals("")) {
                output += "A'C'";
            } else output += "+A'C'";
            groups += "[0,3]";

        }
        if (A[1][0] == 1 && A[1][1] == 1 && (checked[1][0] == 0 || checked[1][1] == 0)) {
            checked[1][0] = 1;
            checked[1][1] = 1;
            if (output.equals("")) {
                output += "AB'";
            } else output += "+AB'";
            groups += "[4,5]";
        }
        if (A[1][1] == 1 && A[1][2] == 1 && (checked[1][1] == 0 || checked[1][2] == 0)) {
            checked[1][1] = 1;
            checked[1][2] = 1;
            if (output.equals("")) {
                output += "AC";
            } else output += "+AC";
            groups += "[5,6]";
        }
        if (A[1][2] == 1 && A[1][3] == 1 && (checked[1][2] == 0 || checked[1][3] == 0)) {
            checked[1][2] = 1;
            checked[1][3] = 1;
            if (output.equals("")) {
                output += "AB";
            } else output += "+AB";
            groups += "[6,7]";
        }
        if (A[1][0] == 1 && A[1][3] == 1 && (checked[1][0] == 0 || checked[1][3] == 0)) {
            checked[1][0] = 1;
            checked[1][3] = 1;
            if (output.equals("")) {
                output += "AC'";
            } else output += "+AC'";
            groups += "[4,7]";
        }
    }

    // no grouping
    private void nogrouping() {
        if (A[0][0] == 1 && checked[0][0] == 0) {
            if (output.equals("")) {
                output += "A'B'C'";
            } else output += "+A'B'C'";
            groups += "[0]";
        }
        if (A[0][1] == 1 && checked[0][1] == 0) {
            if (output.equals("")) {
                output += "A'B'C";
            } else output += "+A'B'C";
            groups += "[1]";

        }
        if (A[0][2] == 1 && checked[0][2] == 0) {
            if (output.equals("")) {
                output += "A'BC";
            } else output += "+A'BC";
            groups += "[2]";
        }
        if (A[0][3] == 1 && checked[0][3] == 0) {
            if (output.equals("")) {
                output += "A'BC'";
            } else output += "+A'BC'";
            groups += "[3]";
        }
        if (A[1][0] == 1 && checked[1][0] == 0) {
            if (output.equals("")) {
                output += "AB'C'";
            } else output += "+AB'C'";
            groups += "[4]";
        }
        if (A[1][1] == 1 && checked[1][1] == 0) {
            if (output.equals("")) {
                output += "AB'C";
            } else output += "+AB'C";
            groups += "[5]";
        }
        if (A[1][2] == 1 && checked[1][2] == 0) {
            if (output.equals("")) {
                output += "ABC";
            } else output += "+ABC";
            groups += "[6]";
        }
        if (A[1][3] == 1 && checked[1][3] == 0) {
            if (output.equals("")) {
                output += "ABC'";
            } else output += "+ABC'";
            groups += "[7]";
        }
    }
}

