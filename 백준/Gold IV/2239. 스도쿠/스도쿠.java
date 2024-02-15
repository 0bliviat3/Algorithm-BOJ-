import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
	
	static int[][] sudoku = new int[9][9];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			String input = in.readLine();
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = input.charAt(j) - '0';
			}
		}
		
		in.close();
		
		pro(0,0, new AtomicBoolean(false));
	}
	
	static void build() { // 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	static boolean chk(int col, int row , int val) { // 유효성 체크
		
		for(int i = 0; i < 9; i++) { // 현재 행,열에서 채워진 부분 제외
			if(sudoku[i][col] == val) return false;
			if(sudoku[row][i] == val) return false;
		}
		
		int nowcol = col / 3 * 3;
		int nowrow = row / 3 * 3;
		
		for(int i = nowrow; i < nowrow + 3; i++) { // 현재 3X3 에서 채워진 부분 제외
			for(int j = nowcol; j < nowcol + 3; j++) {
				if(sudoku[i][j] == val) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	static void init(int col, int row, boolean flag, AtomicBoolean finishFlag) {
		for(int i = 1; i <= 9; i++) {
			if(sudoku[row][col] == 0 && chk(col, row, i)) {
				sudoku[row][col] = i;
				if(flag) {
					pro(0, row + 1, finishFlag);					
				}else {
					pro(col + 1, row, finishFlag);
				}
				// build가 호출되지 않은 상황.. 즉 스도쿠가 틀렸으므로 현재 칸을 빈칸으로 초기화
				// 이전 재귀로 돌아가게끔 한다.
				sudoku[row][col] = 0; // 초기화
			}
		}
	}
	
	static void pro(int col, int row, AtomicBoolean finishFlag) {
		if(finishFlag.get()) return;
		if(row == 9) { // 작성
			build();
			finishFlag.set(true);
			return;
		}
		if(col == 8) { // 줄바꿈
			init(col, row, true, finishFlag);
			if(sudoku[row][col] == 0) { // 이전 재귀로 돌아가서 다시 init의 반복문으로 돌아가 다른값을 받는다.
				return;
			}
			pro(0,row + 1, finishFlag); // 이후 제대로 된 값을 받은 경우 다음 칸으로 넘어간다.
		}else {
			init(col, row, false, finishFlag);
			if(sudoku[row][col] == 0) { // 또는 반복문을 다 돌았는데도 0인 경우 더 이전 재귀로 돌아가 다른값을 받는다.
				return;
			}
			pro(col + 1, row, finishFlag);
		}
	}

}

