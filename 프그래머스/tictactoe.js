const gameOver = (board, piece) => {
  const pairIndex = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let [i, j, k] of pairIndex) {
    if (board[i] === piece && board[j] === piece && board[k] === piece)
      return true;
  }

  return false;
};

const solution = (board) => {
  const gameBoard = board.map((block) => block.split("")).flat();

  const gamePiece = {
    O: 0,
    X: 0,
  };

  for (const piece of gameBoard) {
    if (piece === "O") gamePiece.O += 1;
    else if (piece === "X") gamePiece.X += 1;
  }

  if (gamePiece.O < gamePiece.X || 1 < gamePiece.O - gamePiece.X) return 0;

  const winO = gameOver(gameBoard, "O");
  const winX = gameOver(gameBoard, "X");

  if (winO && winX) return 0;
  if (winO && gamePiece.O - gamePiece.X !== 1) return 0;
  if (winX && gamePiece.O !== gamePiece.X) return 0;

  return 1;
};
