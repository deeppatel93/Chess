package chessPieces;
/**
 * This class implements the Knight.
 * 
 * @author Deep Patel, Xi Chen
 *
 */
public class Knight extends Pieces {

	/**
	 * Initializes an instance of Knight.
	 * 
	 * @param pieceName name of Piece
	 * @param aSide color
	 */
	public Knight(String pieceName, char aSide) {
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
		int row = Math.abs(startRow - nRow);
		int col = Math.abs(startCol- nCol);
		if(super.isValid(board, startRow, startCol, nRow, nCol)==false){
			
			return false;
			
		}
		if(row != 2 && col != 2){
			return false;
		}
		if(row != 1 && col != 1){
			return false;
		}	

		return true;
		
	} 

	
}
