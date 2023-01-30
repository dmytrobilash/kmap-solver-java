package com.hfad.karnaughmap_java.solvers;


public class map2x2_solver {
    private String output = "";
    private final int[][] A = new int[2][2];
    private final int[][] checked = new int[2][2];

    public map2x2_solver(int[] val) {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                A[i][j] = val[count++];
                checked[i][j] = 0;
            }
        }
    }

    public String solve() {
        if (!check4()) {
            // reaches if all values are 1
            output = "1";
        } else if (A[0][0] == 0 && A[0][1] == 0 && A[1][0] == 0 && A[1][1] == 0) {
            output = "0";
        } else {
            // reaches if smaller groups are to be found rather than 4
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (A[i][j] == 1 && checked[i][j] == 0) {
                        if (check2(i, j)) {
                            nogrouping(i, j);
                        }
                    }
                }
            }
        }
        return output;
    }

    // check for 4
    private boolean check4() {
        boolean search_smaller_group = false;

        outer:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (A[i][j] == 1) {
                    search_smaller_group = false;
                } else {
                    // breaks outer loop and returns true to find smaller groups
                    search_smaller_group = true;
                    break outer;
                }
            }
        }
        return search_smaller_group;
    }

    // check for 2
    private boolean check2(int r, int c) {
        boolean search_smaller_group = true;
        String local = "";

        if (A[r][c] == 1 && A[r][(c + 1) % 2] == 1) { // columns ++
            if (r == 0) {
                local = "A'";
            }
            if (r == 1) {
                local = "A";
            }

            if (output.matches("")) {
                output = output + local;
            } else {
                output = output + " + " + local;
            }

            search_smaller_group = false;
            // make checked
            checked[r][c] = 1;
            checked[r][(c + 1) % 2] = 1;
        } else if (A[r][c] == 1 && A[(r + 1) % 2][c] == 1) { // rows ++
            if (c == 0) {
                local = "B'";
            }
            if (c == 1) {
                local = "B";
            }

            if (output.matches("")) {
                output = output + local;
            } else {
                output = output + " + " + local;
            }

            search_smaller_group = false;
            // make checked
            checked[r][c] = 1;
            checked[(r + 1) % 2][c] = 1;
        }
        return search_smaller_group;
    }

    // no grouping
    private void nogrouping(int r, int c) {
        String local = "";

        if (r == 0) {
            local = "A'";
        }
        if (r == 1) {
            local = "A";
        }
        if (c == 0) {
            local = local + "B'";
        }
        if (c == 1) {
            local = local + "B";
        }

        if (output.matches("")) {
            output = output + local;
        } else {
            output = output + " + " + local;
        }
        checked[r][c] = 1;
    }

    public String SoPtoPoSConverter(String sop) {
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

    public String getGroups() {
        StringBuilder groups = new StringBuilder();
        if (!check4()) {
            groups.append("[0 1 2 3]");
        } else {
            if (!check2(0, 0) && !check2(0, 1)) {
                groups.append("[0 1] ");
            }
            if (!check2(0, 0) && !check2(1, 0)){
                groups.append("[0 2] ");
            }
            if (!check2(2, 2) && !check2(0, 1)){
                groups.append("[1 3] ");
            }
            if (!check2(2, 2) && !check2(1, 0)){
                groups.append("[2 3] ");
            }
        }
        return groups.toString();
    }
}