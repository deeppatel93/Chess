package chessPieces;

/**
 * This class implements the King.
 * 
 * @author Deep Patel, Xi Chen
 *
 */
public class King extends Pieces {
	
	/**
	 * Field to see if the King has moved before.
	 */
	boolean moved = false;
	
	/**
	 * Initializes an instance of King.
	 * 
	 * @param pieceName name of Piece
	 * @param aSide color
	 */
	public King(String pieceName, char aSide) {
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
		int col = Math.abs(startCol - nCol);
		if(super.isValid(board, startRow, startCol, nRow, nCol)==false){
			
			return false;
			
		}	
		if(row > 1 || col > 1){
			return false;
		}
		
		moved = true;
		return true;
		
	}
	/**
	 * Returns the a boolean depending on if the move is valid
	 * @return True or false based on the validity of the move.
	 */
	public boolean getMove(){
		return moved;
	}
}