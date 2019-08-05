public class Snake {

    private LinkedList<Node> snakeBody;
    private Random random;
    //Snake的方向    0上， 1 右 ， 2 下 ， 3 左
    private int direction = 0;

    private SnakeGameView snakeGameView;

    public Snake(int snakeHeadX, int snakeHeadY, SnakeGameView snakeGameView) {
        random = new Random();
        snakeBody = new LinkedList<>();
        snakeBody.add(new Node(snakeHeadX, snakeHeadY));
        this.snakeGameView = snakeGameView;
    }

    //获取Snake的方向
    public int getDirection() {

        return direction;
    }
    //设置Snake方向
    public void setDirection(int direction) {

        this.direction = direction;
    }
    //获取Snake头部结点
    public Node getSnakeHead() {

        return snakeBody.getFirst();
    }
    //获取Snake尾部结点
    public Node getSnakeTail() {

        return snakeBody.getLast();
    }
    //获取Snake的Body
    public LinkedList<Node> getSnakeBody(){

        return snakeBody;
    }
    //Snake移动
    public void snakeMove() {

        switch(direction) {
            case 0:
                snakeBody.addFirst(new Node(getSnakeHead().getNodeX() ,getSnakeHead().getNodeY() - DrawView.VIEW_NUMBER));
                break;
            case 1:
                snakeBody.addFirst(new Node(getSnakeHead().getNodeX() + DrawView.VIEW_NUMBER,getSnakeHead().getNodeY()));
                break;
            case 2:
                snakeBody.addFirst(new Node(getSnakeHead().getNodeX(),getSnakeHead().getNodeY()+ DrawView.VIEW_NUMBER));
                break;
            case 3:
                snakeBody.addFirst(new Node(getSnakeHead().getNodeX() - DrawView.VIEW_NUMBER,getSnakeHead().getNodeY()));
                break;
        }
        snakeBody.removeLast();
    }
    //Snake 吃Egg
    public void eatEgg(Node egg) {
        if(snakeBody.getFirst().getNodeX() == egg.getNodeX() && snakeBody.getFirst().getNodeY() == egg.getNodeY()) {
            snakeBody.add(egg);
            //产蛋
            snakeGameView.setEgg(random.nextInt(DrawView.VIEW_WIDTH - 1) * DrawView.VIEW_NUMBER,
                    random.nextInt(DrawView.VIEW_WIDTH - 1) * DrawView.VIEW_NUMBER);
            SnakeGameView.gameScore = SnakeGameView.gameScore + 5;
            snakeGameView.getJTextArea().setText(SnakeGameView.gameScore + "");
            System.out.println("吃到蛋了");
        }
    }
    //Snake越界
    public void snakeRunInterface() {

        if(this.getSnakeHead().getNodeX() < 0 || this.getSnakeHead().getNodeY() < 0||
                this.getSnakeHead().getNodeX() > (DrawView.VIEW_WIDTH * DrawView.VIEW_NUMBER)||
                this.getSnakeHead().getNodeY() > (DrawView.VIEW_WIDTH * DrawView.VIEW_NUMBER)) {
            SnakeGameView.gameState = false;
        }
    }
}
