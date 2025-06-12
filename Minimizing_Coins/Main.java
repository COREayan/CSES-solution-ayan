import java.util.*;
import java.io.*;

public class Main {
	public static int solution(int n, int amount, int[] coins) {
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		
		for (int i=1; i<=amount; i++) {
			for (int coin : coins) {
				if (i-coin>=0) {
					dp[i] = Math.min(dp[i], dp[i-coin]+1);
				}
			}
		}
		
		return (dp[amount] == amount+1) ? -1 : dp[amount];
	}
	
	public static void main(String[] args) {
		/*
			Time limit: 1.00 s || Memory limit: 512 MB
Consider a money system consisting of n coins. Each coin has a positive integer value. Your task is to produce a sum of money x 
using the available coins in such a way that the number of coins is minimal.
For example, if the coins are \{1,5,7\} and the desired sum is 11, an optimal solution is 5+5+1 which requires 3 coins.
Input
The first input line has two integers n and x: the number of coins and the desired sum of money.
The second line has n distinct integers c_1,c_2,\dots,c_n: the value of each coin.
Output
Print one integer: the minimum number of coins. If it is not possible to produce the desired sum, print -1.
Constraints

1 \le n \le 100
1 \le x \le 10^6
1 \le c_i \le 10^6

Example
Input:
3 11
1 5 7

Output:
3
		*/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] coins = new int[n];
		
		for (int i=0; i<n; i++) {
			coins[i] = sc.nextInt();
		}
		
		int result = solution(n, x, coins);
		System.out.println(result);
	}
}