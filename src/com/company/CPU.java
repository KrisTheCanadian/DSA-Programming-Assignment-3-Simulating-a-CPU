package com.company;


import java.io.FileWriter;
import java.io.IOException;

public class CPU<T extends IPriorityQueue<Job>> {

    Job[] jobsInputArray;
    T priorityQueue;
    int CPU_Cycles = 0;

    int totalNumberOfJobs = 0;
    int priorityChanges = 0;
    int systemTime_Cycles = 0;
    long actual_system_time_start;
    long actual_system_time_finish;
    long actual_system_time;
    int completedJobs = 0;
    long averageWaitTime = 0;

    CPU(Job[] jobs, T queue){
        priorityQueue = queue;
        jobsInputArray = jobs;
        totalNumberOfJobs = jobs.length;
        insertAllElements();
    }

    private void insertAllElements(){
        for(Job job : jobsInputArray){
            priorityQueue.insert(job, job.jobPriority);
        }
    }

    public void processJobs(){ //TODO Add starvation fix after 30 processes
        actual_system_time = System.currentTimeMillis();
        Job currentJob;
        while(priorityQueue.size() > 0){
            currentJob = priorityQueue.remove();
            processJob(currentJob);
            completedJobs++;
        }
        actual_system_time_finish = System.currentTimeMillis();
        actual_system_time = actual_system_time_finish - actual_system_time;
        OutputReport();
    }

    private void OutputReport(){
        try {
            FileWriter outFile = new FileWriter("output.txt");

            outFile.write("Current system time (cycles): " + systemTime_Cycles + " \n"
                    + "Total number of jobs executed: " + totalNumberOfJobs + "\n"
                    + "Average process waiting time: " + (averageWaitTime/totalNumberOfJobs) + "\n"
                    + "Total number of priority changes: " + priorityChanges + "\n"
                    + "Actual system time needed to execute all jobs: " + actual_system_time + "\n"
                    );

            outFile.close();
            System.out.println("Report Successfully Created.");
        } catch (IOException e) {
            System.out.println("An error occurred without creating the report.");
            e.printStackTrace();
        }
    }

    private void processJob(Job currentJob){
        currentJob.waitTime = System.currentTimeMillis() - currentJob.entryTime;
        averageWaitTime += currentJob.waitTime;
        for(CPU_Cycles = 0; CPU_Cycles < currentJob.jobLength; CPU_Cycles++){
            System.out.println("Now executing: " + currentJob.jobName + " Job Length: " + currentJob.jobLength +
                    " Current remaining length " + CPU_Cycles + "Initial Priority: " + currentJob.jobPriority + " Current Priority: " + currentJob.finalPriority );
        }
        currentJob.endTime = System.currentTimeMillis();
        systemTime_Cycles += CPU_Cycles;
    }



}
