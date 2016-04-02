package chess;
import java.io.IOException;
import java.util.ArrayList;

import chess.Board;
import chessPieces.Bishop;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Pawn;
import chessPieces.Pieces;
import chessPieces.Queen;
import chessPieces.Rook;
import chessPieces.Space;

/**
 * This class initializes the Pieces chess board and array of captured pieces and starts the chess game .
 * 
 * @author Deep Patel, Xi Chen
 *
 */

public class Chess {

	public static void main(String[] args) throws IOException{
		
		Pieces[][] p = {{new Rook("bR",'b'), new Knight("bN",'b'), new Bishop("bB",'b'), new Queen("bQ", 'b'),new King("bK",'b'),new Bishop("bB",'b'),new Knight("bN",'b'), new Rook("bR",'b'),new Space(" 8", 'x')},
				{new Pawn("bp", 'b'),new Pawn("bp", 'b'),new Pawn("bp", 'b'),new Pawn("bp", 'b'),new Pawn("bp", 'b'),new Pawn("bp", 'b'),new Pawn("bp", 'b'),new Pawn("bp", 'b'),new Space(" 7", 'x')},
				{new Space("  ", 's'), new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space(" 6", 'x')},
				{new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space(" 5", 'x')},
				{new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space(" 4", 'x')},
				{new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space("  ", 's'),new Space(" 3", 'x')},
				{new Pawn("wp", 'w'),new Pawn("wp", 'w'),new Pawn("wp", 'w'),new Pawn("wp", 'w'),new Pawn("wp", 'w'),new Pawn("wp", 'w'),new Pawn("wp", 'w'),new Pawn("wp", 'w'),new Space(" 2", 'x')},
				{new Rook("wR",'w'), new Knight("wN",'w'), new Bishop("wB",'w'), new Queen("wQ", 'w'),new King("wK",'w'),new Bishop("wB",'w'),new Knight("wN",'w'),new Rook("wR",'w'),new Space(" 1", 'x')},
				{new Space(" a", 'x'),new Space(" b", 'x'),new Space(" c", 'x'),new Space(" d", 'x'),new Space(" e", 'x'),new Space(" f", 'x'),new Space(" g", 'x'),new Space(" h", 'x'),new Space("   ", 'x')}};
		ArrayList<Pieces> c = new ArrayList<Pieces>();
		Board b = new Board(p,c);
		b.play(p,c);
		
	} 

}
