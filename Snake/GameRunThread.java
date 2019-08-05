public class GameRunThread implements Runnable{

    private int runTime = 200;
    private DrawView drawView;
    private Snake snake;

    public GameRunThread(DrawView drawView, Snake snake) {
        this.drawView = drawView;
        this.snake = snake;
    }

    public void run() {

        while(true) {

            snake.snakeRunInterface();

            if(SnakeGameView.gameState) {

                drawView.repaint();

                try {
                    Thread.sleep(runTime);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}