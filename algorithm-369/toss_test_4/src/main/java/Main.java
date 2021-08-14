import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] dp;
    private static int N;

    private static void input() {
        N = fr.nextInt();

        dp = new int[70+1];

        dp[1]= 1;
        dp[2]= 2;
        dp[3] = 4;
    }

    private static void pro(){
        for (int i = 4; i <= N ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) {
        while(true){

            input();
            pro();
        }
    }

    static class FastReader{
        private BufferedReader bf;
        private StringTokenizer st;

        public FastReader(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public String nextLine(){
            String str = "";

            try {
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

//    문제 설명
//    계단을 오르는 방법
//        김토스가 N개의 계단을 오르려고 합니다. 김토스는 한번에 1~3개의 계단을 이동할 수 있습니다.
//
//        N개의 계단을 올라가는 방법이 총 몇 가지가 있는지 계산하는 함수를 구현해주세요.
//
//        입력 예시
//        solution(numOfStairs) 함수의 인자는 아래와 같이 전달됩니다.
//
//        계단의 수 N : numOfStairs (1 <= N <= 70)
//        출력 예시
//        주어진 계단의 수 N(numOfStairs)로부터, 계단을 오를 수 있는 방법의 수를 반환합니다.
//
//        예시
//        계단이 1개라면, 오를 수 있는 방법은 한 번에 1계단을 올라서 총 1가지이다.
//
//        [1]
//        계단이 2개라면, 오를 수 있는 방법은 한 번에 1계단씩 2번 오르거나, 한 번에 2계단을 올라서 총 2가지이다.
//
//        [1, 1], [2]
//        계단이 3개라면, 오를 수 있는 방법은 총 4가지이다.
//
//        [1, 1, 1], [1, 2], [2, 1], [3]
//        계단이 4개라면, 오를 수 있는 방법은 총 7가지이다.
//
//        [1, 1, 1, 1], [1, 2, 1], [2, 1, 1], [1, 1, 2], [2, 2], [1, 3], [3, 1]
//
//
//        #include <stdio.h>
//        #include <stdbool.h>
//        #include <stdlib.h>
//
//        long long solution(int numOfStairs) {
//        long long answer = 0;
//        return answer;
//        }