public class DrawView extends Panel{

    //画板的宽度高度
    public static final int VIEW_WIDTH = 40;
    public static final int VIEW_HEIGHT = 40;
    public static final int VIEW_NUMBER = 15;
    private Image iBuffer;
    private Graphics gBuffer;
    private Snake snake;
    private Node egg;

    public DrawView(Snake snake, Node egg) {

        this.snake = snake;
        this.egg = egg;
    }

    public void paint(Graphics g) {

        snake.snakeMove();
        this.drawGridding(g);
        this.drawSnake(g);
        this.drawEgg(g);
        snake.eatEgg(egg);
        System.out.println("("+snake.getSnakeHead().getNodeX()+","+snake.getSnakeHead().getNodeY()+")");
    }
    public void update(Graphics g) {
        if(iBuffer==null)
        {
            iBuffer=createImage(DrawView.VIEW_WIDTH * DrawView.VIEW_NUMBER + 1, DrawView.VIEW_HEIGHT * DrawView.VIEW_NUMBER + 1);
            gBuffer=iBuffer.getGraphics();
        }
        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0,0,DrawView.VIEW_WIDTH * DrawView.VIEW_NUMBER + 1, DrawView.VIEW_HEIGHT * DrawView.VIEW_NUMBER + 1);
        paint(gBuffer);
        g.drawImage(iBuffer,0,0,this);
    }
    //画网格
    public void drawGridding(Graphics g) {

        g.setColor(new Color(128,128,128));
        for(int i = 0; i < VIEW_WIDTH; i++) {
            g.drawLine(0, i * VIEW_NUMBER, VIEW_WIDTH * VIEW_NUMBER, i * VIEW_NUMBER);
        }
        for(int i = 0; i < VIEW_HEIGHT; i++) {
            g.drawLine(i * VIEW_NUMBER, 0, i * VIEW_NUMBER, VIEW_WIDTH * VIEW_NUMBER);
        }

    }
    //画Snake
    public void drawSnake(Graphics g) {

        for(int i = 0; i < snake.getSnakeBody().size(); i ++) {
            g.setColor(Color.white);
            if(i == 0)
                g.setColor(Color.lightGray);
            g.fillRect(snake.getSnakeBody().get(i).getNodeX(), snake.getSnakeBody().get(i).getNodeY(), VIEW_NUMBER, VIEW_NUMBER);
        }
    }
    //画Egg
    public void drawEgg(Graphics g) {

        g.setColor(Color.yellow);
        g.fillRect(egg.getNodeX(), egg.getNodeY(), VIEW_NUMBER, VIEW_NUMBER);
    }

}