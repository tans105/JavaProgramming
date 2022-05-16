package competitiveProgramming.geekforgeeks;

import java.util.*;

/*
https://www.geeksforgeeks.org/job-sequencing-problem/

Job Sequencing Problem

Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.

Examples:

Input: Four Jobs with following
deadlines and profits
JobID  Deadline  Profit
  a      4        20
  b      1        10
  c      1        40
  d      1        30
Output: Following is maximum
profit sequence of jobs
        c, a


Input:  Five Jobs with following
deadlines and profits
JobID   Deadline  Profit
  a       2        100
  b       1        19
  c       2        27
  d       1        25
  e       3        15
Output: Following is maximum
profit sequence of jobs
        c, a, e

 */
public class JobSequencing {
    public static void main(String[] args) {
        List<Job> pendingJobs = new ArrayList<>();

        pendingJobs.add(new Job("a", 4, 20));
        pendingJobs.add(new Job("b", 1, 10));
        pendingJobs.add(new Job("c", 1, 40));
        pendingJobs.add(new Job("d", 1, 30));
        System.out.println(sequenceJobs(pendingJobs));

        pendingJobs = new ArrayList<>();
        pendingJobs.add(new Job("a", 2, 100));
        pendingJobs.add(new Job("b", 1, 19));
        pendingJobs.add(new Job("c", 2, 27));
        pendingJobs.add(new Job("d", 1, 25));
        pendingJobs.add(new Job("e", 3, 15));
        System.out.println(sequenceJobs(pendingJobs));
    }

    public static List<Job> sequenceJobs(List<Job> jobs) {
        Collections.sort(jobs);
        Map<Integer, Job> slotMapping = new HashMap<>();

        for (Job job : jobs) {
            int destinedSlot = job.deadline;
            if (slotMapping.containsKey(destinedSlot)) {
                for (int i = destinedSlot - 1; i > 0; i--) {
                    if (!slotMapping.containsKey(i)) {
                        slotMapping.put(i, job);
                        break;
                    }
                }
            } else {
                slotMapping.put(destinedSlot, job);
            }
        }

        jobs = new ArrayList<>();

        for (Map.Entry<Integer, Job> entry : slotMapping.entrySet()) {
            jobs.add(entry.getValue());
        }

        return jobs;
    }


    private static class Job implements Comparable<Job> {
        private String id;
        private Integer deadline;
        private Integer profit;

        public Job(String id, Integer deadline, Integer profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id='" + id + '\'' +
                    ", deadline=" + deadline +
                    ", profit=" + profit +
                    '}';
        }

        @Override
        public int compareTo(Job o) {
            return o.profit.compareTo(this.profit);
        }
    }
}
