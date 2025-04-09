public class PracticeProblem {

	public static void main(String args[]) {

	}
	public static int searchMazeMoves(String[][] maze) {
		int rows = maze.length;
		int cols = maze[0].length;

		boolean[][] visited = new boolean[rows][cols];
		int result = searchMazeMovesHelper(maze, rows - 1, 0, visited, 0);
		return (result == Integer.MAX_VALUE ? -1 : result);
	}

	private static int searchMazeMovesHelper(String[][] maze, int r, int c, boolean[][] visited, int moves) {
		if (maze[r][c].equals("F")) {
			return moves;
		}

		visited[r][c] = true;
		int min = Integer.MAX_VALUE;

		int[] dr = {-1,0,};
		int[] dc = {0,1,};
		for (int i = 0; i < 2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && !visited[nr][nc] && !maze[nr][nc].equals("*")) {
				int candidate = searchMazeMovesHelper(maze, nr, nc, visited, moves + 1);
				if (candidate < min) {
					min = candidate;
				}
			}
		}
		visited[r][c] = false;
		return min;
	}

	public static int noOfPaths(String[][] maze) {
		int rows = maze.length;
		int cols = maze[0].length;
		boolean[][] visited = new boolean[rows][cols];
		return noOfPathsHelper(maze, rows - 1, 0, visited);
	}

	private static int noOfPathsHelper(String[][] maze, int r, int c, boolean[][] visited) {
		if (maze[r][c].equals("F")) {
			return 1;
		}

		visited[r][c] = true;
		int count = 0;
		int[] dr = {-1,0,};
		int[] dc = {0,1,};
		for (int i = 0; i < 2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && !visited[nr][nc] && !maze[nr][nc].equals("*")) {
				count += noOfPathsHelper(maze, nr, nc, visited);
			}

		}
	visited[r][c] = false;
	return count;
 	}
}