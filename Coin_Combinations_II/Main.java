import java.util.*;
import java.io.*;

public class Main {
	private static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of coins
		int x = sc.nextInt(); // target sum
		
		int[] coins = new int[n];
		for (int i=0; i<n; i++) {
			coins[i] = sc.nextInt();
		}
		
		int[] dp = new int[x+1];
		dp[0] = 1;
		/*
			1. Task is to calculate distinct ways, we can sum up target using coins. 
			we can not repeat. How to do it? 
		*/
		for (int coin : coins) {
			for (int weight = 0; weight <= x; weight++) {
				if (weight - coin >= 0) { // prevent out of bounds cases.
					dp[weight] += dp[weight - coin];
					dp[weight] %= MOD;
				}
			}
		}
		System.out.println(dp[x]);
	}
}