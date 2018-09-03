import java.util.PriorityQueue;
import java.util.Scanner;

public class ParallelProcessing {
    public static void main(String[] args) {
        PriorityQueue<Integer> jobQ = new PriorityQueue<Integer>();
        Scanner s = new Scanner(System.in);
        int[] threads = new int[s.nextInt()];
        int jobsCount = s.nextInt();
        while(jobsCount-- > 0) {
            jobQ.add(s.nextInt());
        }
        s.close();

        int time = 0;
        while(jobQ.size() > 0 ) {
            for(int i=0; i<threads.length; i++) {
                if(threads[i] == 0 ) {
                    threads[i] = jobQ.poll();
                    System.out.printf("thread %d started at %d\n", i, time);
                }
                else {
                    threads[i]--;
                    if(threads[i] == 0 ) {
                        threads[i] = jobQ.poll();
                        System.out.printf("thread %d started at %d\n", i, time);
                    }
                }
            }
            time++;
        }
    }
}