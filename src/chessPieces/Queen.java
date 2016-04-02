package chessPieces;
/**
 * This class implements the Queen.
 * 
 * @author Deep Patel, Xi Chen
 *
 */
public class Queen extends Pieces {
	
	/**
	 * Initializes an instance of Queen.
	 * 
	 * @param pieceName name of Piece
	 * @param aSide color
	 */
	public Queen(String pieceName, char aSide) {
		super(pieceName, aSide);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Returns the a boolean depending on if the move is valid
	 * 
	 * @param The Pieces board, starting row, starting column, end row, and end column
	 * @return True or false based on the validity of the move.
	 */
	public boolean isValid(Pieces[][] board, int startRow, int startCol, int nRow, int nCol) {
		int row = Math.abs(startRow - nRow);
		int col = Math.abs(startCol- nCol);
		int colPos;
		if(super.isValid(board, startRow, startCol, nRow, nCol)==false){
			
			return false;
			
		}
		if(row == col){
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
		}
		else if(startRow == nRow){
			if(startCol < nCol){
				for(int i = startCol + 1; i < nCol; i++){
					if((board[startRow][i].side == 's')){
						continue;
					}
					else{
						return false;
					}
				}
			}
			else{
				for(int i = startCol - 1; i > nCol; i--){
					if((board[startRow][i].side == 's')){
						continue;
					}
					else{
						return false;
					}
				}
			}
		}
		else if(startCol == nCol){
			if(startRow  < nRow){
				for(int i = startRow + 1; i < nRow; i++){
					if(board[i][startCol].side == 's'){
						continue;
					}
					else{
						return false;
					}
			}
			}
			else{
				for(int i = startRow - 1; i > nRow; i--){
					
					if(board[i][startCol].side == 's'){
						continue;
					}
					else{
						return false;
					}
			}
			}
		}
		else{
			return false;
		}
		return true;
		
	}
	
		
	
}
