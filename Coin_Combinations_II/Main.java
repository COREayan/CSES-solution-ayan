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
		
		long[] dp = new long[x+1];
		dp[0] = 1;
		
		for (int weight=1; weight<=x; weight++) {
			for (int coin : coins) {
				if (weight - coin >= 0) {
					dp[weight] += dp[weight-coin];
					dp[weight] %= MOD;
				}
			}
		}
		
		System.out.println(dp[x]);
	}
}