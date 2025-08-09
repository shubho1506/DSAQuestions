package GreedyProblems.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a
//deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time.
//You will earn the profit associated with a job only if it is completed by its deadline.
//Your task is to find:
//The maximum number of jobs that can be completed within their deadlines.
//The total maximum profit earned by completing those jobs.

//Examples :
//Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
//Output: [2, 60]
//Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).

//Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
//Output: [2, 127]
//Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).

//Input: deadline[] = [3, 1, 2, 2], profit[] = [50, 10, 20, 30]
//Output: [3, 100]
//Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).

public class JobSequencingProblem {
    public static void main(String[] args) {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        System.out.println(jobSequencing(deadline,profit));
    }
    static class Job{
        int deadline;
        int profit;
        Job(int d,int p){
            this.deadline = d;
            this.profit = p;
        }
    }

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int count = 0;
        int totalProfit = 0;
        int maxDL = Integer.MIN_VALUE;
        ArrayList<Job> jobs = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<deadline.length;i++){
            jobs.add(new Job(deadline[i],profit[i]));
            maxDL = Math.max(maxDL,deadline[i]);
        }
        int[] slots = new int[maxDL+1];
        Arrays.fill(slots,-1);
        jobs.sort((a, b) -> b.profit - a.profit);
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = 1;
                    count++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        ans.add(count);
        ans.add(totalProfit);
        return ans;
    }
}
