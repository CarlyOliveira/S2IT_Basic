
public class Matrix {

	public static void main(String[] args) {
		
		
	int[][] mtx = { {8, 43, 5, 19, 90 }, {10, 11, 15, -7, -4 }, {100, 0, 45, -70, -40 },{80, 3, 25, -72, -44 }, {16, 13, 15, -78, -45 }, {70, 81, 35, -74, -47 } };	
	Matrix matriz = new Matrix();
	System.out.println(matriz.diffDiagonal(mtx, 4));
	
	}
	
	
	public int diffDiagonal(int[][] mtrx, int n) {
		
		if(mtrx == null ) {
			return 0;
		}
		
		//tratamento não especificado no teste.
		//else if(mtrx[0].length < n ) {
//			return 0;
//		}
		
		int dA = 0;
		int dB = 0;		
		
		for (int i = 0; i < n; i++) {
			int[] js = mtrx[i];
			
			dA += js[i];			
			dB += js[n - (i + 1)];
		}
	
		return Math.abs(dA - dB);
		}

}

