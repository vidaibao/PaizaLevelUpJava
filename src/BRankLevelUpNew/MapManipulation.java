package BRankLevelUpNew;

import java.util.Scanner;

public class MapManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getOne();
		//getUpSideDown();
		getRowColDia();
	}
	
	// 【マップの扱い 1】マップの書き換え・1 マス
	public static void getOne() {
		Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(); int W = sc.nextInt();
        String[] map = new String[H];
        for (int i = 0; i < H; i++) {
			map[i] = sc.next();	// nextLine() ERROR
		}
        int y = sc.nextInt(); int x = sc.nextInt();
        sc.close();
        
        char swap = map[y].charAt(x) == '.' ? '#' : '.';
        char[] temp = new char[W];
        char[] mapY = map[y].toCharArray();
        for (int i = 0; i < W; i++) {
        	temp[i] = (i == x) ? swap : mapY[i];
        }
        map[y] = new String(temp);
        
        // result
        for (int i = 0; i < H; i++) {
			System.out.println(map[i]);
		}
		
	}
	
	// 与えられた座標のマスと上下左右で隣接するマスの最大 5 マス
	public static void getUpSideDown() {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(); int W = sc.nextInt();
        String[][] map = new String[H][W];
        for (int i = 0; i < H; i++) {
			map[i] = sc.next().split("");	
		}
        int y = sc.nextInt(); int x = sc.nextInt();
        sc.close();
        // equals    equals    equals    equals
        map[y][x] = 				  (map[y][x].equals(".")) ? "#" : "."; 
        if (y > 0) 		map[y-1][x] = (map[y-1][x].equals(".")) ? "#" : ".";
        if (y < H-1) 	map[y+1][x] = (map[y+1][x].equals(".")) ? "#" : ".";
        if (x > 0) 		map[y][x-1] = (map[y][x-1].equals(".")) ? "#" : ".";
        if (x < W-1) 	map[y][x+1] = (map[y][x+1].equals(".")) ? "#" : ".";
        
        for (int i = 0; i < H; i++) {
        	System.out.println(String.join("", map[i]));
        }
	}
	
	
	
	public static void getRowColDia() {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(); int W = sc.nextInt();
        String[][] map = new String[H][W];
        for (int i = 0; i < H; i++) {
			map[i] = sc.next().split("");	
		}
        int y = sc.nextInt(); int x = sc.nextInt();
        sc.close();
        
        // origin point saved
        String origin = (map[y][x].equals(".")) ? "#" : ".";
        // row = y
        for (int col = 0; col < W; col++) {
        	map[y][col] = (map[y][col].equals(".")) ? "#" : "."; 
        }
        // col = x
        for (int row = 0; row < H; row++) {
        	map[row][x] = (map[row][x].equals(".")) ? "#" : "."; 
        }
        
        // diagonal to bottomRight y++ x++
        int row = y; int col = x;
        while (++row < H && ++col < W) {
        	map[row][col] = (map[row][col].equals(".")) ? "#" : ".";
		}
        // diagonal to upperLeft y-- x--
        row = y; col = x;
        while (--row > 0 && --col > 0) {
        	map[row][col] = (map[row][col].equals(".")) ? "#" : ".";
		}
        // diagonal to upperRight y-- x++
        row = y; col = x;
        while (--row > 0 && ++col < W) {
        	map[row][col] = (map[row][col].equals(".")) ? "#" : ".";
		}
        // diagonal to bottomLeft y++ x--
        row = y; col = x;
        while (++row < H && --col > 0) {
        	map[row][col] = (map[row][col].equals(".")) ? "#" : ".";
		}
        map[y][x] = origin;

        for (int i = 0; i < H; i++) {
        	System.out.println(String.join("", map[i]));
        }
	}
	
	
	

}
