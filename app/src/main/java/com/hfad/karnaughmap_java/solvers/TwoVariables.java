package com.hfad.karnaughmap_java.solvers;


public class TwoVariables {
    private String output = "";
    private final int[][] A = new int[2][2];
    private final int[][] checked = new int[2][2];

    public TwoVariables(int [] val) {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
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
        if (check4()) {
            // reaches if all values are 1
            output = "1";
            return output;
        } else if (A[0][0] == 0 && A[0][1] == 0 && A[1][0] == 0 && A[1][1] == 0) {
            output = "0";
            return output;
        }
        check2();
        nogrouping();
        return output;
    }

    // check for 4
    private boolean check4() {
        return A[0][0] == 1 && A[0][1] == 1 && A[1][0] == 1 && A[1][1] == 1;
    }

    // check for 2
    private void check2() {
        if(A[0][0] == 1 && A[0][1] == 1 && (checked[0][0] == 0 || checked[0][1] == 0)){
            checked[0][0] = 1;
            checked[0][1] = 1;
            if(output.equals("")){
                output+="A'";
            }
            else output+="+A'";
        }
        if(A[0][0] == 1 && A[1][0] == 1 && (checked[0][0] == 0 || checked[1][0] == 0)){
            checked[0][0] = 1;
            checked[1][0] = 1;
            if(output.equals("")){
                output+="B'";
            }
            else output+="+B'";
        }
        if(A[1][0] == 1 && A[1][1] == 1 && (checked[1][0] == 0 || checked[1][1] == 0)){
            checked[1][0] = 1;
            checked[1][1] = 1;
            if(output.equals("")){
                output+="A";
            }
            else output+="+A";
        }
        if(A[0][1] == 1 && A[1][1] == 1 && (checked[0][1] == 0 || checked[1][1] == 0)){
            checked[0][1] = 1;
            checked[1][1] = 1;
            if(output.equals("")){
                output+="B";
            }
            else output+="+B";
        }
    }

    // no grouping
    private void nogrouping() {
        if(A[0][0] == 1 && checked[0][0] == 0){
            if(output.equals("")){
                output+="A'B'";
            }
            else output+="+A'B'";
        }
        if(A[0][1] == 1 && checked[0][1] == 0){
            if(output.equals("")){
                output+="A'B";
            }
            else output+="+A'B";
        }
        if(A[1][0] == 1 && checked[1][0] == 0){
            if(output.equals("")){
                output+="AB'";
            }
            else output+="+AB'";
        }
        if(A[1][1] == 1 && checked[1][1] == 0){
            if(output.equals("")){
                output+="AB";
            }
            else output+="+AB";
        }
    }

    /*public String SoPtoPoSConverter(String sop) {
        String optimizedSolution;
        String i1 = sop.replace(" + ", ") * (");
        String i2 = "(" + i1.replace("'", " + ") + ")";
        StringBuilder i3 = new StringBuilder();
        if (sop.equals("1")) {
            return "0";
        } else if (sop.equals("0")) {
            return "1";
        } else {
            for (int i = 0; i < i2.length(); i++) {
                String ch;
                if (i2.charAt(i) == 'A' || i2.charAt(i) == 'B' || i2.charAt(i) == 'C' || i2.charAt(i) == 'D') {
                    if (!i2.regionMatches(i + 1, " + ", 0, 3)) {
                        ch = i2.charAt(i) + "' + ";
                    } else {
                        ch = Character.toString(i2.charAt(i));
                    }
                } else {
                    ch = Character.toString(i2.charAt(i));
                }
                i3.append(ch);
            }
            optimizedSolution = i3.toString().replace(" + )", ")");
            return optimizedSolution;
        }
    }
       */
    /*public String getGroups() {
        StringBuilder groups = new StringBuilder();
        if (check4()) {
            groups.append("[0 1 2 3]");
        } else {
            if (!check2(0, 0) && !check2(0, 1)) {
                groups.append("[0 1] ");
            }
            if (!check2(0, 0) && !check2(1, 0)){
                groups.append("[0 2] ");
            }
            if (!check2(1, 1) && !check2(0, 1)){
                groups.append("[1 3] ");
            }
            if (!check2(1, 1) && !check2(1, 0)){
                groups.append("[2 3] ");
            }
        }
        return groups.toString();
    }*/
}