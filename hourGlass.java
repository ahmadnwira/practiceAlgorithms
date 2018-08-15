public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();
        
        int s=0;
        int ss=0;
        
        int largestSum = arr[s][ss] + arr[s][ss+1] + arr[s][ss+2];
            largestSum +=  arr[s+1][ss+1];
            largestSum +=  arr[s+2][ss] + arr[s+2][ss+1] + arr[s+2][ss+2];

        for(int i=0; i<32; i++) {
            int currentSum = arr[s][ss] + arr[s][ss+1] + arr[s][ss+2];
            currentSum +=  arr[s+1][ss+1];
            currentSum +=  arr[s+2][ss] + arr[s+2][ss+1] + arr[s+2][ss+2];

            
            if(currentSum > largestSum) {
                largestSum = currentSum;
            }

            ss++;
            if(ss == 4) {
                s++;
                s%=4;
                ss=0;
            }
        }

        System.out.println(largestSum);
    }
}