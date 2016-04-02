package chessPieces;
//@author Deep Patel, Xi Chen
/**
 * This class implements the Rook.
 * 
 * @author Deep Patel, Xi Chen
 *
 */
public class Rook extends Pieces {
	
	/**
	 * Field to see if the Rook has moved before.
	 */
	boolean moved = false;
	
	/**
	 * Initializes an instance of Rook.
	 * 
	 * @param pieceName name of Piece
	 * @param aSide color
	 */
	public Rook(String pieceName, char aSide) {
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
		if(super.isValid(board, startRow, startCol, nRow, nCol)==false){
			
			return false;
			
		}
		if((startRow != nRow) && (startCol != nCol)){
			return false;
		}
		if(startRow == nRow){
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
		moved = true;
		return true;
	}		
}
