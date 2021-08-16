import com.sun.source.util.Trees;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int start, end, N;
    private static long sum= 0;
    private static long[] fruitWeights = {30,40,10,20 ,30};
    private static TreeSet<Long> set = (TreeSet<Long>)new TreeSet<Long>().descendingSet();

    private static void input(){
        N = 3;
    }

    private static void pro(){

        TreeSet<Long> reverseTree = (TreeSet<Long>)new TreeSet<Long>().descendingSet();

        for (int i = 0; i <= N-1; i++) {
            reverseTree.add(fruitWeights[i]);
        }
        set.add(reverseTree.first());

        for (int end = N; end < fruitWeights.length; end++ ,start++) {
//            sum+= fruitWeights[end];
            reverseTree.add(fruitWeights[end]);
//            sum-= fruitWeights[start];
            reverseTree.remove(fruitWeights[start]);

            set.add(reverseTree.first());
        }

        System.out.println(set);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}

//    문제 설명
//    과일 게임
//    무더운 여름 김토스는 친구들과 계곡으로 여행을 가게 되었습니다. 계곡을 눈앞에 두고 게임을 놓칠 수 없었던 김토스는 게임을 제안하게 됩니다.
//
//        N개의 과일이 있을 때, 연속된 K개의 과일을 골라 K개 중 가장 무거운 과일의 무게를 점수로 해서 가장 높은 점수가 나온 사람이 계곡에 입수하는 게임입니다.
//
//        김토스는 게임을 하기 전 N개의 과일의 무게가 주어질 때, 나올 수 있는 모든 점수를 구하고 싶습니다.
//
//        입력 예시
//        solution(fruitWeights, k) 함수의 인자는 아래와 같이 전달됩니다.
//
//        N개의 과일의 무게 W[i]를 담고 있는 배열 : fruitWeights (1 <= N <= 500000, 1 <= W[i] <= 2,147,483,647)
//        상수 K : k (1 <= K <= N)
//        출력 예시
//        주어진 N개의 과일의 무게 목록(fruitWeights)과 k 값을 바탕으로 나올 수 있는 모든 점수를 중복되지 않게 내림차순으로 정렬해 반환합니다.
//
//        예시
//        입력
//        fruitWeights: [30 40 10 20 30]
//        k: 3
//        출력
//        [40 30]
//        설명
//        '연속된 K개의 과일'의 경우의 수는 [30 40 10], [10 20 30], [40 10 20]이 존재하며, 각각의 경우에 대해 40점, 30점, 40점이 나올 수 있습니다. 따라서 solution(fruitWeights, k)는 [40, 30]을 반환합니다.
//
//        참고사항
//        시간복잡도에 유의하여 함수를 구현해주세요.
//
//        #include <stdio.h>
//        #include <stdbool.h>
//        #include <stdlib.h>
//
//// fruitWeights_len은 배열 fruitWeights의 길이입니다.
//        int* solution(int fruitWeights[], size_t fruitWeights_len, int k) {
//        // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
//        int* answer = (int*)malloc(1);
//        return answer;
//        }