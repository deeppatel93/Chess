package chessPieces;
/**
 * This class implements the Pawn.
 * 
 * @author Deep Patel, Xi Chen
 *
 */
public class Pawn extends Pieces {

	/**
	 * Field to see if it's possible to perform enpassant.
	 */
	boolean enpassant=false;
	
	/**
	 * Initializes an instance of Pawn.
	 * 
	 * @param pieceName name of Piece
	 * @param aSide color
	 */
	public Pawn(String pieceName, char aSide) {
		
		super(pieceName, aSide);
		
	}

	/**
	 * Returns the a boolean depending on if the move is valid
	 * 
	 * @param The Pieces board, starting row, starting column, end row, and end column
	 * @return True or false based on the validity of the move.
	 */
	public boolean isValid(Pieces[][] board, int startRow, int startCol, int nRow, int nCol , String upgrade) {
		char c= board[startRow][startCol].side;
		//checking if no move is excuted
		if(super.isValid(board, startRow, startCol, nRow, nCol)==false){
			
			return false;
				
		}
		//check if the upgrade field is received
		if(upgrade==null){
		
			//first time moving pawn, if it moves 2 spots, set enpassant to true
		//if ((c=='w' && startRow==6 && nRow == 4) || (c=='b' && startRow==1 && nRow == 3)) {
			if(Math.abs(startRow-nRow)==2){
			
			enpassant = true;
			return true;
			
			//moving pawn 1 step forward
			}
		else if (((c=='w' && startRow<=6 && nRow==startRow-1 && startCol==nCol)|| (c=='b' && startRow>=1 && nRow==startRow+1 && startCol==nCol)) && isEmpty(board[nRow][nCol])){
			enpassant=false;	
			return true;
			
			//check if going diagonal is valid
		}
		else if ((startRow<=6) && (c=='w') && (Math.abs(startRow-nRow)==Math.abs(startCol-nCol)) && (Math.abs(startRow-nRow)==1) && ((board[nRow][nCol].side!='s'))&& (board[nRow][nCol].side!=c) ){
			
			
				enpassant=false;
				return true;
				
			
			
		}
		else if((startRow>=1) && (c=='b') && (Math.abs(startRow-nRow)==Math.abs(startCol-nCol)) && (Math.abs(startRow-nRow)==1) && ((board[nRow][nCol].side!='s')) && (board[nRow][nCol].side!=c)){
			
			
				enpassant=false;
				return true;
			
		
			
		}//checks for enpassant
		else if((startRow==3) && (c=='w') && (Math.abs(startRow-nRow)==Math.abs(startCol-nCol)) && (Math.abs(startRow-nRow)==1) && ((board[nRow][nCol].side=='s') && board[nRow+1][nCol].name.charAt(1)=='p')){
			
		
				Pawn pawn = (Pawn)board[nRow+1][nCol];
				if(pawn.getEnpassant()==true){
				
				return true;
				}
				
			}
		else if((startRow==4) && (c=='b') && (Math.abs(startRow-nRow)==Math.abs(startCol-nCol)) && (Math.abs(startRow-nRow)==1) && ((board[nRow][nCol].side=='s') && board[nRow-1][nCol].name.charAt(1)=='p')){
			
				Pawn pawn = (Pawn)board[nRow-1][nCol];
				if(pawn.getEnpassant()==true){
		
				return true;
				}
				
			
		}
			else{
			enpassant=false;
			return false;
			
		}
		
		
	}
		//if upgrade field is received, check if pawn is at the right spot
		else{
		char side =board[startRow][startCol].side;
		if(isValid(board, startRow , startCol, nRow, nCol)&& side=='w' && nRow==0){
			enpassant = false;
			return true;
			
		}else if (isValid(board, startRow , startCol, nRow, nCol)&& side=='b' && nRow==7){
			enpassant=false;
			return true;
			
			
		}else{
			enpassant=false;
			return false;
		}
		
		}
		
		return false;
	}
	/**
	 * Returns the a boolean depending if enpassant is true or not
	 *
	 * @return True or false based on if enpassant is true.
	 */
	public boolean getEnpassant(){
		
		return enpassant;
		
	}

}