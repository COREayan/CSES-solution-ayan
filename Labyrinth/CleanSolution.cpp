#include <iostream>
#include <vector>
#include <queue>
#include <cstdio>

using namespace std;

// Maximum grid size
const int MAX = 1000;

// Directions: Down, Up, Right, Left
const int dx[] = {1, -1, 0, 0};
const int dy[] = {0, 0, 1, -1};
const char dir[] = {'D', 'U', 'R', 'L'};

// Grids to track visited cells, parent direction, and distances
bool visited[MAX][MAX];
char parent[MAX][MAX], directionPath[1000000];
int dist[MAX][MAX];

// Grid dimensions and coordinates of start and end points
int n, m, startX, startY, endX, endY;

// Check if the next cell is valid for traversal
bool isValid(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m && !visited[x][y];
}

// Perform Breadth-First Search (BFS) to find the shortest path
void bfs() {
    queue<pair<int, int>> q;
    q.push({startX, startY});
    visited[startX][startY] = true;

    while (!q.empty()) {
        auto [x, y] = q.front();
        q.pop();

        // Explore all 4 possible directions
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny)) {
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                parent[nx][ny] = dir[i];  // Store the direction from which we arrived
                q.push({nx, ny});
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

int main() {
    // Read grid dimensions
    scanf("%d %d\n", &n, &m);

    vector<string> maze(n);

    // Read the maze layout and locate start (A) and end (B)
    for (int i = 0; i < n; ++i) {
        getline(cin, maze[i]);
        for (int j = 0; j < m; ++j) {
            if (maze[i][j] == '#') visited[i][j] = true;      // Mark walls as visited
            else if (maze[i][j] == 'A') startX = i, startY = j; // Start position
            else if (maze[i][j] == 'B') endX = i, endY = j;     // End position
        }
    }

    // Perform BFS from the start point
    bfs();

    // If end is not reachable
    if (!visited[endX][endY]) {
        printf("NO\n");
    } else {
        printPath();  // Print path if found
    }

    return 0;
}
