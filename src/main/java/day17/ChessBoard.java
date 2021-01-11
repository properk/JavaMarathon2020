package day17;

public class ChessBoard {
    private ChessPiece[][] chessboard;

    public ChessBoard(ChessPiece[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void print() {
        for (ChessPiece[] chess : chessboard) {
            for (ChessPiece chess_simple : chess) {
                System.out.print(chess_simple.getSymbol());
            }
            System.out.println();
        }
    }
}
