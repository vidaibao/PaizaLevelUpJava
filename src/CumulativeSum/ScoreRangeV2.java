package CumulativeSum;

import java.util.Scanner;

public class ScoreRangeV2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = scanner.nextInt();
        }

        int root = (int) Math.ceil(Math.sqrt(N));

        int[] rangeMax = new int[root];
        int[] rangeMin = new int[root];
        for (int i = 0; i < root; i++) {
            int start = root * i;
            int end = Math.min(root * (i + 1), N);
            rangeMax[i] = findMax(S, start, end);
            rangeMin[i] = findMin(S, start, end);
        }

        for (int j = 0; j < K; j++) {
            int aLeft = scanner.nextInt() - 1;
            int aRight = scanner.nextInt() - 1;
            int bLeft = scanner.nextInt() - 1;
            int bRight = scanner.nextInt() - 1;

            int[] aMinMax = squareRootDecompositionRange(S, rangeMin, rangeMax, root, aLeft, aRight);
            int[] bMinMax = squareRootDecompositionRange(S, rangeMin, rangeMax, root, bLeft, bRight);

            int aScore = aMinMax[1] - aMinMax[0];
            int bScore = bMinMax[1] - bMinMax[0];

            if (aScore == bScore) {
                System.out.println("DRAW");
            } else if (aScore > bScore) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
		scanner.close();

	}

	
	private static int[] squareRootDecompositionRange(int[] X, int[] rangeMin, int[] rangeMax, int sqrt, int left, int right) {
		// initialize
		int rstMin = X[left]; 
        int rstMax = X[left];
        int now = left;

        while (now <= right) {
        	// if now is first element and block not over right then get result of block
            if (now % sqrt == 0 && now + sqrt <= right) {
                rstMin = Math.min(rstMin, rangeMin[now / sqrt]);
                rstMax = Math.max(rstMax, rangeMax[now / sqrt]);
                now += sqrt;
            } else {
                rstMin = Math.min(rstMin, X[now]);
                rstMax = Math.max(rstMax, X[now]);
                now += 1;
            }
        }

        return new int[]{ rstMin, rstMax };
    }

    private static int findMax(int[] array, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }

    private static int findMin(int[] array, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
    
}
