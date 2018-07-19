package com.basic_class_03;

/**
 * “之”字形打印矩阵
 */
public class ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int aR = 0;   //a点行
		int aC = 0;
		int bR = 0;	  //b点行
		int bC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;		//控制方向，是左下到右上还是右上到左下
		while (aR != endR + 1) {
			printLevel(matrix, aR, aC, bR, bC, fromUp);
			if (aC == endC) {
				aR = aR + 1;
			} else {
				aC = aC + 1;
			}
			if (bR == endR) {
				bC = bC + 1;
			} else {
				bR = bR + 1;
			}
//			aR = aC == endC ? aR + 1 : aR;
//			aC = aC == endC ? aC : aC + 1;
//			bC = bR == endR ? bC + 1 : bC;
//			bR = bR == endR ? bR : bR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int aR, int aC, int bR, int bC,
			boolean f) {
		if (f) {
			//左下->右上
			while (aR != bR + 1) {
				System.out.print(m[aR++][aC--] + " ");
			}
		} else {
			//右上->左下
			while (bR != aR - 1) {
				System.out.print(m[bR--][bC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

	//我的一种思路：在同一条线上的点的横纵坐标之和为固定数值

}
