/**
 * A Connect-4 player that makes random valid moves.
 * 
 * @author Daniel Szafir
 *
 */
public class GreedyPlayer implements Player
{

    @Override
    public String name() {
        return "PureGreed";
    }

    @Override
    public void init(int id, int msecPerMove, int rows, int cols) {
    }
    
    
    
    @Override
    public void calcMove(
        Connect4Board board, int oppMoveCol, Arbitrator arb) 
        throws TimeUpException {
        // Make sure there is room to make a move.
        if (board.isFull()) {
            throw new Error ("Complaint: The board is full!");
        }
        // make a move
        
        
    }
    public static int[] evaluator(Connect4Board aBoard) {
    	//three layers: first is chip strengths, then p1 move values, then p2 move values
    	int[][][] valueBoard = new int[6][7][3];
    	int[] values = new int[2];
    	values[0] = values[1] = 0;
    	for(int r = 0; r < aBoard.numRows(); r++) {
        	for(int c = 0; c < aBoard.numCols(); c++) {
        		valueBoard[r][c][0] = 0;
        		if(aBoard.get(r, c) == 1) {
        			valueBoard[r][c][0]++;
        			if(r+1<6 && aBoard.get(r+1, c) == 1) {
        				valueBoard[r][c][0]++;
        				if(r+2<6 && aBoard.get(r+2, c) == 1) valueBoard[r][c][0]++;
        			}
        			if(r-1>=0 && aBoard.get(r-1, c) == 1) {
        				valueBoard[r][c][0]++;
        				if(r-2>=0 && aBoard.get(r-2, c) == 1) valueBoard[r][c][0]++;
        			}
        			if(c+1<7 && aBoard.get(r, c+1) == 1) {
        				valueBoard[r][c][0]++;
        				if(c+2<7 && aBoard.get(r, c+2) == 1) valueBoard[r][c][0]++;
        			}
        			if(c-1>=0 && aBoard.get(r, c-1) == 1) {
        				valueBoard[r][c][0]++;
        				if(c-2>=0 && aBoard.get(r, c-2) == 1) valueBoard[r][c][0]++;
        			}
        		}
        	}
        }
    	
    	return values;
    }
}
