package POTD;

//Given an array arr[] of time strings in 24-hour clock format "HH:MM:SS", return the minimum difference in seconds
// between any two time strings in the arr[].
//The clock wraps around at midnight, so the time difference between "23:59:59" and "00:00:00" is 1 second.

//Examples:
//Input: arr[] = ["12:30:15", "12:30:45"]
//Output: 30
//Explanation: The minimum time difference is 30 seconds.
//Input: arr[] = ["00:00:01", "23:59:59", "00:00:05"]
//Output: 2
//Explanation: The time difference is minimum between "00:00:01" and "23:59:59".

import java.util.Arrays;

public class DifferenceCheck {
    public static void main(String[] args) {
        String[] arr = {"00:00:01", "23:59:59", "00:00:05"};
        System.out.println(minDifference(arr));
    }

    public static int minDifference(String[] arr) {
        int[] timeInSeconds = new int[arr.length];
        int diff = Integer.MAX_VALUE;
        int idx=0;

        for(String str :  arr){
            String[] time = str.split(":");
            int hr = Integer.parseInt(time[0])*60*60;
            int min = Integer.parseInt(time[1])*60;
            int sec = Integer.parseInt(time[2]);
//            int hr = Integer.parseInt(str.substring(0,2))*60*60;
//            int min = Integer.parseInt(str.substring(3,5))*60;
//            int sec = Integer.parseInt(str.substring(6,8));
            timeInSeconds[idx++] = hr+min+sec;
        }
        Arrays.sort(timeInSeconds);
        for(int i=1;i<timeInSeconds.length;i++){
            diff = Math.min(diff,timeInSeconds[i]-timeInSeconds[i-1]);
        }
        int fullRotation = 24*60*60;
        return Math.min(diff,timeInSeconds[0]+(fullRotation-timeInSeconds[timeInSeconds.length-1]));
    }
}
