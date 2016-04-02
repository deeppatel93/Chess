package chessPieces;
/**
 * This class implements the Bishop.
 * 
 * @author Deep Patel, Xi Chen
 *
 */
public class Bishop extends Pieces{
	
	/**
	 * Initializes an instance of Rook.
	 * 
	 * @param pieceName name of Piece
	 * @param aSide color
	 */

	public Bishop(String pieceName, char aSide) {
		super(pieceName, aSide);
		
	}
	
	
	@Override
	/**
	 * Returns the a boolean depending on if the move is valid
	 * 
	 * @param The Pieces board, starting row, starting column, end row, and end column
	 * @return True or false based on the validity of the move.
	 */
	public boolean isValid(Pieces[][] board, int startRow, int startCol, int nRow, int nCol) {
		int colPos;
		if(super.isValid(board, startRow, startCol, nRow, nCol)==false){
			
			return false;
			
		}else if(Math.abs(startRow-nRow)==Math.abs(startCol-nCol)){
			
			
			
			if(startRow<nRow && startCol<nCol){
				colPos=startCol+1;
			for(int i=startRow+1; i<nRow; i++){
				
				if(!isEmpty(board[i][colPos])){
					return false;
					
				}colPos++;
				
			}
		}
			
			
			if(startRow>nRow && startCol>nCol){
				colPos=startCol-1;
				for(int i=startRow-1; i>nRow; i--){
					
					if(!isEmpty(board[i][colPos])){
						return false;
						
					}colPos--;
					
				}
				
			}
			if(startRow<nRow && startCol>nCol){
				colPos=startCol-1;
				
				for(int i=startRow+1; i<nRow; i++){
					
					if(!isEmpty(board[i][colPos])){
						return false;
						
					}colPos--;
					
				}
			}
			if (startRow>nRow && startCol<nCol){
				colPos=startCol+1;
				
				for(int i=startRow-1; i>nRow; i--){
					
					if(!isEmpty(board[i][colPos])){
						return false;
						
					}colPos++;
					
				}
				
			}
			
			if(board[nRow][nCol].side != board[startRow][startCol].side){
				return true;
				
			}
		}
		
		
	return false;

}
}
