# CSES - Coin Combinations 1

Consider a money system consisting of n coins. Each coin has a positive integer value. Your task is to calculate the number of distinct ways you can produce a money sum x using the available coins.
For example, if the coins are {2,3,5} and the desired sum is 9, there are 8 ways:

- 2+2+5
- 2+5+2
- 5+2+2
- 3+3+3
- 2+2+2+3
- 2+2+3+2
- 2+3+2+2
- 3+2+2+2

## Input
The first input line has two integers n and x: the number of coins and the desired sum of money.
The second line has n distinct integers c1, c2, ..., cn: the value of each coin.

## Output
Print one integer: the number of ways modulo 10^9+7.

## Constraints
- 1 <= n <= 100
- 1 <= x <= 10^6
- 1 <= ci <= 10^6

## Example

### Input:
3 9 <br>
2 3 5

### Output:
8

Link: https://cses.fi/problemset/task/1635
