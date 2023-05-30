package com.dmytrobilash.karnaughmap_java.views.drawing;

public class PoStoSoPConverter {
    public String convert(String str){
        char [] chars = str.toCharArray();
        str = "";

        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ')' || chars[i] == '('){
                str +="";
            }
            else if(chars[i] == 'A' && chars[i+1] !='\''){
                str+="A";
            }
            else if(chars[i] == 'B' && chars[i+1] !='\''){
                str+="B";
            }
            else if(chars[i] == 'C' && chars[i+1] !='\''){
                str+="C";
            }
            else if(chars[i] == 'D' && chars[i+1] !='\''){
                str+="D";
            }
            else if(chars[i] == '+');
            else if(chars[i] == '*'){
                str+="+";
            }
            else if(chars[i] == 'A' && chars[i+1] =='\''){
                str+="A'";
            }
            else if(chars[i] == 'B' && chars[i+1] =='\''){
                str+="B'";
            }
            else if(chars[i] == 'C' && chars[i+1] =='\''){
                str+="C'";
            }
            else if(chars[i] == 'D' && chars[i+1] =='\''){
                str+="D'";
            }
        }
        return str;
    }
}
