package BitManipulation.Easy;

//You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].
//Example:
//Input:
//L = 4, R = 8
//Output:
//8
//Explanation:
//4 ^ 5 ^ 6 ^ 7 ^ 8 = 8

public class FindXorOfNumbersFromLtoR {
    public static void main(String[] args) {
        System.out.println(findXOR(4,8));
    }

    public static int findXOR(int l, int r) {
        return solve(l-1)^solve(r);
    }

    private static int solve(int n){
        if(n%4==1){
            return 1;
        }
        else if(n%4==2){
            return n+1;
        }
        else if(n%4==3){
            return 0;
        }
        return n;
    }
}
