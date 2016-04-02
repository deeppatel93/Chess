package chessPieces;
/**
 * This abstract class implements the Piece object.
 * 
 * @author Deep Patel, Xi Chen
 *
 */
public abstract class Pieces {
	
	/**
	 * Name of chess piece in board.
	 */
	public String name;
	
	/**
	 * Team of piece .
	 */
	public char side;
	
	/**
	 * Initializes an instance of Piece.
	 * 
	 * @param pieceName name of Piece
	 * @param aSide color
	 */
	public Pieces (String pieceName, char aSide){
		
		this.name = pieceName;
		this.side = aSide;
		
		
	}
	/**
	 * Returns the a boolean depending on if the current space is a space or not
	 * 
	 * @param piece Piece
	 * @return True or false depending if the piece is a space or not.
	 */
	public boolean isEmpty(Pieces piece){
		if(piece.side == 's'){
			return true;
			
		}return false;
		
		
	}
	/**
	 * Returns the a boolean depending on if the move is valid
	 * 
	 * @param The Pieces board, starting row, starting column, end row, and end column
	 * @return True or false based on the validity of the move.
	 */
	public boolean isValid (Pieces[][] board, int startRow, int startCol, int nRow, int nCol){
		if(startRow == nRow && startCol == nCol){
			return false;
		}
		 if(startRow < 0 || nRow > 7 || nRow < 0 || startRow > 7 || startCol < 0 || nCol > 7 || nCol <0 || startCol > 7){
			 return false;
	}	
		 return true;
	}
		
	/**
	 * Returns the Piece as a string
	 * 
	 * @return String of the piece.
	 */
	public String toString(){
		
		return this.name;
		
	}
	
}
