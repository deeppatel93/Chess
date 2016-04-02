package chess;
/**
 * This class implements the board and is where the game is played.
 * 
 * @author Deep Patel, Xi Chen
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import chessPieces.Bishop;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Pawn;
import chessPieces.Pieces;
import chessPieces.Queen;
import chessPieces.Rook;
import chessPieces.Space;

public class Board {
	/**
	 * Name of board with the pieces.
	 */
	public Pieces[][] board;
	/**
	 * Name of arraylist of captures pieces.
	 */
	public ArrayList<Pieces> cap;
	/**
	 * Name of arraylist of captured pieces
	 */
	public ArrayList<Pieces> preCap;
	
	/**
	 * Initializes an instance of Board.
	 * 
	 * @param 2-d array of pieces
	 * @param cap arraylist of captured pieces
	 * 
	 */
	public Board(Pieces board[][],ArrayList<Pieces> cap){
		this.board = board;
		this.cap = new ArrayList<Pieces>();
		this.preCap = new ArrayList<Pieces>();
	}

	/**
	 * Returns array index of the column
	 * 
	 * @param string of input
	 * @return Returns index of the column and returns 10 if invalid
	 */
	
	public int getCol(String hi){
		char c = hi.charAt(0);
		int col = 0;
		switch(c) {
	    case 'a':
	        col = 0; 
	        break;
	    case 'b':
	        col = 1;
	        break;
	    case 'c':
	        col = 2; 
	        break;
	    case 'd':
	        col = 3;
	        break;
	    case 'e':
	        col = 4; 
	        break;
	    case 'f':
	        col = 5;
	        break;
	    case 'g':
	        col = 6; 
	        break;
	    case 'h':
	        col = 7;
	        break;
	    default: 
	    	col = 10;
	}
		return col;
	}
	/**
	 * Returns array index of the row
	 * 
	 * @param string of input
	 * @return Returns index of the row and returns 10 if invalid
	 */
	public int getRow(String hi){
		char c = hi.charAt(1);
		int row = 0;
		switch(c) {
	    case '8':
	        row = 0; 
	        break;
	    case '7':
	        row = 1;
	        break;
	    case '6':
	        row = 2; 
	        break;
	    case '5':
	        row = 3;
	        break;
	    case '4':
	        row = 4; 
	        break;
	    case '3':
	        row = 5;
	        break;
	    case '2':
	        row = 6; 
	        break;
	    case '1':
	        row = 7;
	        break;
	    default: 
	    	row = 10;
	    
	}
		return row;
	} 
	
	/**
	 * Returns boolean if the starting position inputed is valid based on position, and players turns
	 * 
	 * @param board with pieces, 
	 * @param starting row, 
	 * @param starting column,
	 * @param current players color
	 * @return Returns true if valid or false if invalid
	 */
	public boolean checkStart(Pieces checkBoard[][], int row, int col, char color){
		Pieces test = checkBoard[row][col];
		if(test.name.equals("##")){
			return false;
		}
		else if(test.name.equals("  ")){
			return false;
		}
		else{
			char c = test.side;
			if(color != (c)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns boolean if the end position inputed is valid based on position, and players turns
	 * 
	 * @param board with pieces, 
	 * @param starting row,
	 * @param starting column
	 * @return Returns true if valid or false if invalid
	 */
	public boolean checkEnd(Pieces[][] checkBoard, int row, int col,int color) {
		Pieces test = checkBoard[row][col];
		char c = test.side;
		if(color == c){
			return false;
		}
		return true;
	}  
	/**
	 * Moves piece to end position
	 * 
	 * @param board with pieces,
	 * @param starting row, 
	 * @param starting column,
	 * @param end row
	 * @param end col 
	 * @param current players color
	 * @return Returns true if valid or false if invalid
	 */
	public Pieces[][] movePiece(Pieces[][] checkBoard, int startRow, int startCol, int endRow, int endCol){
		Pieces start = checkBoard[startRow][startCol];
		Pieces end = checkBoard[endRow][endCol];
		Pieces temp = start;
		
		if(end.name.equals("##") || end.name.equals("  ")){
			if(end.name.equals("##")){
				end.name = "  ";
			}
			checkBoard[startRow][startCol] = end;
			checkBoard[endRow][endCol] = temp;
		}
		else{
			cap.add(checkBoard[endRow][endCol]);
			checkBoard[startRow][startCol] = new Space("  ", 's');
			checkBoard[endRow][endCol] = temp;
		}
		return checkBoard;
	}
	
	/**
	 * Prints the board as stirng
	 * 
	 * @param Pieces Board
	 *
	 */
	public void printBoard(Pieces zoard[][]){
		int count = 1;
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(zoard[i][j].side == 's' && count % 2 == 0){
					zoard[i][j].name = "##";
				}
				if(zoard[i][j].side == 'd'){
					
				}
				else{
					count++;
				}
			}
		}
		System.out.println();
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(zoard[i][j].toString() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Returns  int array index of the row and column of the white king
	 * 
	 * @param Pieces checkBoard
	 * @return Returns the location of the king in an int array
	 */
	int[] findWhiteKing(Pieces checkBoard[][]){
		int[] pos = new int[2];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(checkBoard[i][j].name.equals("wK")){
					pos[0] = i;
					pos[1] = j;
					return pos;
				}
			}
		}
		return pos;
	}
	
	/**
	 * Returns  int array index of the row and column of the black king
	 * 
	 * @param Pieces checkBoard
	 * @return Returns the location of the king in an int array
	 */
	int[] findBlackKing(Pieces checkBoard[][]){
		int[] pos = new int[2];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(checkBoard[i][j].name.equals("bK")){
					pos[0] = i;
					pos[1] = j;
					return pos;
				}
			}
		}
		return pos;
	}
	/**
	 * Returns boolean whether the white king is in check or not
	 * 
	 * @param Pieces checkBoard
	 * @return True or false based on if the king is in check
	 */
	boolean isWhiteCheck(Pieces checkBoard[][]){
		int[] pos = findWhiteKing(checkBoard);
		int row = pos[0];
		int col = pos[1];
		boolean inCheck = false;
		String upgrade = null;
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(checkBoard[i][j].side == 'b'){
					if(checkBoard[i][j].name.charAt(1) == 'p'){
						Pawn pawn = new Pawn("bp", 'b');
						inCheck = pawn.isValid(checkBoard, i,j,row,col,upgrade);	
					}
					else{
						inCheck = checkBoard[i][j].isValid(checkBoard, i, j,row,col);
					}
					if(inCheck){
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Returns boolean whether the black king is in check or not
	 * 
	 * @param Pieces checkBoard
	 * @return True or false based on if the king is in check
	 */
	boolean isBlackCheck(Pieces checkBoard[][]){
		int[] pos = findBlackKing(checkBoard);
		int row = pos[0];
		int col = pos[1];
		boolean inCheck = false;
		String upgrade = null;
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(checkBoard[i][j].side == 'w'){
					if(checkBoard[i][j].name.charAt(1) == 'p'){
						Pawn pawn = new Pawn("wp", 'w');
						inCheck = pawn.isValid(checkBoard, i,j,row,col,upgrade);	
					}
					else{
	
						inCheck = checkBoard[i][j].isValid(checkBoard, i, j,row,col);
					}
					if(inCheck){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Plays the chess game
	 * 
	 * @param Pieces checkBoard
	 * @param Captured pieces
	 * 
	 */
	public void play(Pieces board[][],ArrayList<Pieces> cap) throws IOException{
		int z = 0;
		int count = 0;
		boolean checkDraw = false;
		char color;
		boolean inCheck = false;
		Pieces[][] checkBoard =  new Pieces[9][9];
		while(z < 3242424){
			cap = preCap;
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					checkBoard[i][j] = board[i][j];
				}
			}
			
			
			count++;
			printBoard(board);
			
			if(inCheck){
				System.out.println("Check");
			}
			
			if(count % 2 == 0){
				System.out.print("Black's Move: ");
				color = 'b';
			}
			else{
				System.out.print("White's Move: ");
				color = 'w';
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String move = br.readLine();
			if(checkDraw){
				if(move.equals("draw")){
					System.out.println("Game is a draw");
					return;
				}
				else{
					checkDraw = false;
				}
			}
			if(move.equals("resign")){
				if(count % 2 == 0){
					System.out.println("White wins!");
				}
				else{
					System.out.println("Black wins!");
				}
				return;
			}

			
			if(move.length() < 1 || (!move.contains(" "))){
				System.out.print("Illegal move, try again\n");
				count--;
			}
			else{
				String space = " ";
				String[] spl = move.split(space);
				
				String start   = spl[0];
				String end     = spl[1];
				String upgrade = null;
				if(spl.length == 3){
					if(spl[2].equals("draw?")){
						checkDraw = true;
					}
					else{
						upgrade = spl[2];
					}
				}
				int startRow   = getRow(start);
				int startCol   = getCol(start); 
				int endRow     = getRow(end);
				int endCol     = getCol(end);
				if(startRow == 10 || startCol == 10 || endRow == 10 || endCol == 10){
					System.out.print("Illegal move, try again\n");
					count--;
				}
				else{
					boolean isValid = true;
					boolean castle = false;
					int col = Math.abs(startCol - endCol);
					int row = Math.abs(startRow - endRow);
					if(checkStart(checkBoard, startRow,startCol,color) == false){
						System.out.print("Illegal move, try again\n");
						count--;
					}
					else{
						if(checkEnd(checkBoard,endRow,endCol,color) == false){
							System.out.print("Illegal move, try again\n");
							count--;
						}
						else{ 
							if(checkBoard[startRow][startCol].name.charAt(1) == 'K'){
								if(row == 0 && col == 2 || col == 3){
					
									Rook rook;
									King king = (King)checkBoard[startRow][startCol];
									if(startRow == 7 && endRow == 7 && startCol == 4 && endCol == 6 && checkBoard[startRow][startCol].name.equals("wK") && checkBoard[7][7].name.equals("wR") && checkBoard[startRow][startCol +1].side == 's' && checkBoard[startRow][startCol + 2].side == 's' && king.getMove() == false){
										checkBoard[startRow][startCol] = new Space("  ", 's');
										checkBoard[7][7] = new Space("  ", 's');
										checkBoard[7][5] = new Rook("wR",'w');
										checkBoard[7][6] = new King("wK" , 'w');
										castle = true;
									}
									else if(startRow == 7 && endRow == 7 && startCol == 4 && endCol == 2 && checkBoard[startRow][startCol].name.equals("wK") && checkBoard[7][0].name.equals("wR") && checkBoard[startRow][startCol - 1].side == 's' && checkBoard[startRow][startCol - 2].side == 's' && checkBoard[startRow][startCol - 3].side == 's' && king.getMove() == false){
										checkBoard[startRow][startCol] = new Space("  ", 's');
										checkBoard[7][0] = new Space("  ", 's');
										checkBoard[7][3] = new Rook("wR",'w');
										checkBoard[7][2] = new King("wK" , 'w');	
										castle = true;
									}
									else if(startRow == 0 && endRow == 0 && startCol == 4 && endCol== 6 && checkBoard[startRow][startCol].name.equals("bK") && checkBoard[0][7].name.equals("bR") && checkBoard[startRow][startCol + 1].side == 's' && checkBoard[startRow][startCol + 2].side == 's' && king.getMove() == false){
										checkBoard[startRow][startCol] = new Space("  ", 's');
										checkBoard[0][7] = new Space("  ", 's');
										checkBoard[0][5] = new Rook("bR",'b');
										checkBoard[0][6] = new King("bK" , 'b');	
										castle = true;
									}
									else if(startRow == 0 && endRow == 0 && startCol == 4 && endCol == 2 && checkBoard[startRow][startCol].name.equals("bK") && checkBoard[0][0].name.equals("bR") && checkBoard[startRow][startCol - 1].side == 's' && checkBoard[startRow][startCol - 2].side == 's' && checkBoard[startRow][startCol - 3].side == 's' && king.getMove() == false){
										checkBoard[startRow][startCol] = new Space("  ", 's');
										checkBoard[0][0] = new Space("  ", 's');
										checkBoard[0][3] = new Rook("bR",'b');
										checkBoard[0][2] = new King("bK" , 'b');	
										castle = true;
									}
									else{
										isValid = checkBoard[startRow][startCol].isValid(checkBoard, startRow, startCol, endRow, endCol);
									}
								
								}
								else{
									isValid = checkBoard[startRow][startCol].isValid(checkBoard, startRow, startCol, endRow, endCol);
								}
							}
							else{
								if(checkBoard[startRow][startCol].name.charAt(1) == 'p'){
									Pawn pawn=(Pawn)checkBoard[startRow][startCol];
									
									if(upgrade == null){
										isValid = pawn.isValid(checkBoard, startRow, startCol, endRow, endCol,null);
									}
									else{
										
										isValid = pawn.isValid(checkBoard, startRow, startCol, endRow, endCol, upgrade);

									}
							}
							
								else{
									isValid = checkBoard[startRow][startCol].isValid(checkBoard, startRow, startCol, endRow, endCol);
								}
							}
						
							if(isValid == false){
								System.out.print("Illegal move, try again\n");
								count--;
							}
							else{
								if(castle == false){
									movePiece(checkBoard, startRow,startCol,endRow,endCol);
									if((endRow>0 && endRow<7)&&(endCol>0 && endCol<7)){
										
									if(checkBoard[endRow][endCol].side=='w' && endRow==2 &&  checkBoard[endRow+1][endCol].name.charAt(1)=='p'&& endCol%2==0 &&checkBoard[endRow][endCol].name.charAt(1)=='p' ){
										Pawn pawn = (Pawn)board[endRow+1][endCol];
										if(pawn.getEnpassant()==true){
											cap.add(board[endRow+1][endCol]);
											checkBoard[endRow+1][endCol]=new Space("##",'s');
										}
									}else if (checkBoard[endRow][endCol].side=='w' && endRow==2 && checkBoard[endRow+1][endCol].name.charAt(1)=='p' && endCol%2!=0 &&checkBoard[endRow][endCol].name.charAt(1)=='p'){
										Pawn pawn = (Pawn)board[endRow+1][endCol];
										if(pawn.getEnpassant()==true){
											cap.add(board[endRow+1][endCol]);
											checkBoard[endRow+1][endCol]=new Space("  ",'s');
										}
									}else if (checkBoard[endRow][endCol].side=='b' && endRow==5 &&checkBoard[endRow-1][endCol].name.charAt(1)=='p' && endCol%2!=0 && checkBoard[endRow][endCol].name.charAt(1)=='p'){
										Pawn pawn = (Pawn)board[endRow-1][endCol];
										if(pawn.getEnpassant()==true){
											cap.add(board[endRow-1][endCol]);
											checkBoard[endRow-1][endCol]=new Space("##",'s');
										}
									}else if (checkBoard[endRow][endCol].side=='b' && endRow==5&& checkBoard[endRow-1][endCol].name.charAt(1)=='p' && endCol%2==0 && checkBoard[endRow][endCol].name.charAt(1)=='p'){
										Pawn pawn = (Pawn)board[endRow-1][endCol];
										if(pawn.getEnpassant()==true){

											cap.add(board[endRow-1][endCol]);
											checkBoard[endRow-1][endCol]=new Space("  ",'s');
										}
									}
										
										}

									if(checkBoard[endRow][endCol].name.charAt(1) == 'p' && checkBoard[endRow][endCol].side== 'w' && endRow == 0){
										if(upgrade == null){
											checkBoard[endRow][endCol] = new Queen("wQ",'w');
										}
										else{
											switch(upgrade.charAt(0)){
												case 'N':
													checkBoard[endRow][endCol] = new Knight("wN",'w');
													break;
												case 'B':
													checkBoard[endRow][endCol] = new Bishop("wB",'w');
													break;
												case 'R': 
													checkBoard[endRow][endCol] = new Rook("wR",'w');
													break;
												default:
													System.out.print("Illegal move, try again\n");
													count--;
													continue;
											}
										}
									}
									if(checkBoard[endRow][endCol].name.charAt(1) == 'p' && checkBoard[endRow][endCol].side== 'b' && endRow == 7){
										if(upgrade == null){
											checkBoard[endRow][endCol] = new Queen("bQ",'b');
										}
										else{
											switch(upgrade.charAt(0)){
												case 'N':
													checkBoard[endRow][endCol] = new Knight("bN",'b');
													break;
												case 'B':
													checkBoard[endRow][endCol] = new Bishop("bB",'b');
													break;
												case 'R': 
													checkBoard[endRow][endCol] = new Rook("bR",'b');
													break;
												default:
													System.out.print("Illegal move, try again\n");
													count--;
													continue;
											}
										}
									}
									

								}
								boolean whiteInCheck = isWhiteCheck(checkBoard);
								boolean blackInCheck = isBlackCheck(checkBoard);
								if(color == 'w' && whiteInCheck == true){
									System.out.print("Illegal move, try again\n");
									for(int i = 0; i < 9; i++){
										for(int j = 0; j < 9; j++){
											checkBoard[i][j] = board[i][j];
										}
									}
									count--;	
								}
								else if(color == 'b' && blackInCheck == true){
									System.out.print("Illegal move, try again\n");
									for(int i = 0; i < 9; i++){
										for(int j = 0; j < 9; j++){
											checkBoard[i][j] = board[i][j];
										}
									}
									count--;
								}
								else{
									if(color == 'w' && blackInCheck == true){
										inCheck = true;
									}
									else if(color == 'b' && whiteInCheck == true){
										inCheck = true;
										
									}
									else{
										inCheck = false;
									
									}
								}	
							}
						}
					
					}
				}
		
		
		}
			preCap = cap;
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					board[i][j] = checkBoard[i][j];
				}
			}	
	}
}
	
	/**
	 * Returns  checks if its checkmate 
	 * 
	 * @param Pieces checkBoard
	 * @param king row
	 * @param king col
	 * @return returns true if its checkmate and false if not
	 */
public boolean whiteCheckMate(Pieces[][] checkBoard, int kingRow, int kingCol) {
	Pieces boardForCheck[][]=board;
	for(int i=0; i<=8; i++){
		for(int j=0; j<=8; j++){
			if(board[kingRow][kingCol].isValid(board, kingRow, kingCol, i, j)){
				movePiece(boardForCheck,kingRow,kingCol,i,j);
				if(!isWhiteCheck(boardForCheck)){
					return false;
				}for (int x=0;i<9;i++){
					for(int y=0; j<9; j++){
						boardForCheck[x][y]=board[x][y];
					}
				}
				
			}
			
		}
		
	}
	
	
	
	return true;
	}
	

/**
 * Returns  checks if its checkmate 
 * 
 * @param Pieces checkBoard
 * @param king row
 * @param king col
 * @return returns true if its checkmate and false if not
 */
public boolean blackCheckMate (Pieces board[][], int kingRow, int kingCol){
		
		
		Pieces boardForCheck[][]=board;
		for(int i=0; i<=8; i++){
			for(int j=0; j<=8; j++){
				if(board[kingRow][kingCol].isValid(board, kingRow, kingCol, i, j)){
					movePiece(boardForCheck,kingRow,kingCol,i,j);
					if(!isBlackCheck(boardForCheck)){
						return false;
					}for (int x=0;i<9;i++){
						for(int y=0; j<9; j++){
							boardForCheck[x][y]=board[x][y];
						}
					}
					
				}
				
			}
			
		}
		
		
		
		return true;
		}

}