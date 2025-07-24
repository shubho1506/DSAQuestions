package POTD;

//You are given a string s and two integers x and y. You can perform two types of operations any number of times.
//Remove substring "ab" and gain x points.
//For example, when removing "ab" from "cabxbae" it becomes "cxbae".
//Remove substring "ba" and gain y points.
//For example, when removing "ba" from "cabxbae" it becomes "cabxe".
//Return the maximum points you can gain after applying the above operations on s.

//Example 1:
//
//Input: s = "cdbcbbaaabab", x = 4, y = 5
//Output: 19
//Explanation:
//- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
//- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
//- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
//- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
//Total score = 5 + 4 + 5 + 5 = 19.
//Example 2:
//
//Input: s = "aabbaaxybbaabb", x = 5, y = 4
//Output: 20

public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        System.out.println(maximumGain("aabbaaxybbaabb",5,4));
        System.out.println(maximumGainOptimmized("aabbaaxybbaabb",5,4));
    }

    public static int maximumGain(String s, int x, int y) {
        int rem_ab_F = 0;
        int rem_ab_S = 0;
        int rem_ba_F = 0;
        int rem_ba_S = 0;

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length() - 1;) {
            if (sb.charAt(i) == 'a' && sb.charAt(i + 1) == 'b') {
                rem_ab_F++;
                sb.delete(i, i + 2);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }

        for (int i = 0; i < sb.length() - 1;) {
            if (sb.charAt(i) == 'b' && sb.charAt(i + 1) == 'a') {
                rem_ba_S++;
                sb.delete(i, i + 2);
                if (i > 0){
                    i--;
                }
            } else {
                i++;
            }
        }

        StringBuilder sb1 = new StringBuilder(s);

        for (int i = 0; i < sb1.length() - 1;) {
            if (sb1.charAt(i) == 'b' && sb1.charAt(i + 1) == 'a') {
                rem_ba_F++;
                sb1.delete(i, i + 2);
                if (i > 0){
                    i--;
                }
            } else {
                i++;
            }
        }

        for (int i = 0; i < sb1.length() - 1;) {
            if (sb1.charAt(i) == 'a' && sb1.charAt(i + 1) == 'b') {
                rem_ab_S++;
                sb1.delete(i, i + 2);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }

        return Math.max((rem_ab_F * x + rem_ba_S * y), (rem_ba_F * y + rem_ab_S * x));
    }

    public static int maximumGainOptimmized(String s, int x, int y){
        if(x>y){
            return maxGain(s,x,"ab",y,"ba");
        }
        return maxGain(s,y,"ba",x,"ab");
    }

    private static int maxGain(String str,int x,String firstPair,int y,String secondPair){
        StringBuilder sb = new StringBuilder();
        int points = 0;

        for(char c : str.toCharArray()){
            sb.append(c);
            if(sb.length()>=2 && sb.charAt(sb.length()-2)==firstPair.charAt(0) && sb.charAt(sb.length()-1)==firstPair.charAt(1)){
                sb.delete(sb.length()-2,sb.length());
                points += x;
            }
        }

        StringBuilder finalsb = new StringBuilder();
        for (char c : sb.toString().toCharArray()){
            finalsb.append(c);
            if(finalsb.length()>=2 && finalsb.charAt(finalsb.length()-2)==secondPair.charAt(0) && finalsb.charAt(finalsb.length()-1)==secondPair.charAt(1)){
                finalsb.delete(finalsb.length()-2,finalsb.length());
                points += y;
            }
        }

        return points;
    }

}
