import java.util.*;
import java.io.*;

class Pair {
	int ROW;
	int COL;
	
	public Pair(int r, int c) {
		this.ROW = r;
		this.COL = c;
	}
}

public class Main {
	private int MAX;
	private int[] dr;
	private int[] dc;
	private char[] direction;
	
	private boolean[][] visited; // while taking input, will mark the grid's as #.
	private char[][] parent;     
	private int[][] distance;
	private char[] directionPath;
	
	private int ROW;
	private int COL;
	private int startR;
	private int startC;
	private int endR;
	private int endC;
	
	private boolean isValid(int currentR, int currentC) {
		return currentR>=0 && currentR<this.ROW && currentC>=0 && currentC<this.COL && !this.visited[currentR][currentC];
	}
	
	private void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.push(new Pair(startR, startC));
		this.visited[startR][startC] = true;
		
		while (!q.isEmpty()) {
			Pair top = q.pop();
			for (int i=0; i<4; i++) {
				int newR = top.ROW + dr[i];
				int newC = top.COL + dc[i];
				
				if (isValid(newR, newC)) {
					this.visited[newR][newC] = true;
					this.distance[newR][newC] = distance[top.ROW][top.COL] + 1;
					this.parent[newR][newC] = this.direction[i];
					q.push(new Pair(newR, newC)); 
				}
			}
		}
	}

	// Reconstruct and print the shortest path from B to A
void printPath() {
    printf("YES\n%d\n", dist[endX][endY]);

    int len = dist[endX][endY];
    pair<int, int> pos = {endX, endY};

    // Backtrack from the end to the start using parent direction
    for (int i = len - 1; i >= 0; --i) {
        directionPath[i] = parent[pos.first][pos.second];

        switch (directionPath[i]) {
            case 'D': pos.first -= 1; break;  // Came from above
            case 'U': pos.first += 1; break;  // Came from below
            case 'R': pos.second -= 1; break; // Came from left
            case 'L': pos.second += 1; break; // Came from right
        }
    }

    // Print the reconstructed path
    for (int i = 0; i < len; ++i) {
        printf("%c", directionPath[i]);
    }
    printf("\n");
}

	public static void printPath() {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		this.ROW = sc.nextInt();
		this.COL = sc.nextInt();
		sc.nextLine();
		
		// Maximum grid size
		this.MAX = 1000;
		
		// Directions: Down, Up, Right, Left
		this.dr = {1, -1, 0, 0};
		this.dc = {0, 0, 1, -1};
		this.direction = {'D', 'U', 'R', 'L'};
		
		// Grids to track visited cell, parents direction, and distances.
		this.parent = new char[height][width];
		this.visited = new boolean[height][width];
		this.distance = new int[height][width];
		this.directionPath = new char[1000000];
		
		for (int r=0; r<this.ROW; r++) {
			String currentLine = sc.nextLine();
			for (int c=0; c<this.COL; c++) {
				if (currentLine.charAt(c) == '#') {
					this.visited[r][c] = true;
				} else if (currentLine.charAt(c) == 'A') {
					this.startR = r;
					this.startC = c;
				} else if (currentLine.charAt(c) == 'B') {
					this.endR = r;
					this.endC = c;
				}
			}
		}
		
		bfs();
		
		if (this.visited[this.endR][this.endC]) {
			printPath();
		} else {
			System.out.println("NO\n");
		}		
	}
}