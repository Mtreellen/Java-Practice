
public class SnakeGameView extends Frame{

    private JLabel jl;
    private DrawView drawView;
    private Panel panel;
    private JLabel scoreTitle;
    private JLabel score;
    private Panel rule;
    private JTextArea hint;

    private Random random;
    public static boolean gameState = true;
    public static int gameScore = 0;
    private Snake snake;
    private Node egg;
    private GameRunThread grt;
    private static Thread thread;

    public SnakeGameView() {

        random = new Random();
        //初始化Snake
        snake = new Snake(10 * DrawView.VIEW_NUMBER + random.nextInt(19) * DrawView.VIEW_NUMBER,
                10 * DrawView.VIEW_NUMBER + random.nextInt(19) * DrawView.VIEW_NUMBER,this);
        //初始化Egg
        egg = new Node(random.nextInt(DrawView.VIEW_WIDTH - 1) * DrawView.VIEW_NUMBER,
                random.nextInt(DrawView.VIEW_WIDTH - 1) * DrawView.VIEW_NUMBER);
        //初始化画板
        drawView = new DrawView(snake, egg);
        grt = new GameRunThread(drawView, snake);
        thread = new Thread(grt);

        jl = new JLabel("SnakeGame-3.0",JLabel.CENTER);
        panel = new Panel();
        scoreTitle = new JLabel("Score", JLabel.CENTER);
        score = new JLabel(gameScore + "", JLabel.CENTER);
        rule = new Panel();
        hint = new JTextArea("    操作方式\n      ↑\n  ←      →\n      ↓\n\n【Esc】退出程序\n\n关于\n");
    }

    //设置鸡蛋
    public void setEgg(int eggX, int eggY) {

        this.egg.setNodeX(eggX);
        this.egg.setNodeY(eggY);
    }
    //获得
    public JLabel getJTextArea() {
        return score;
    }
    //主方法
    public static void main(String[] args) {

        new SnakeGameView().showView();
        thread.start();
    }
    public void showView() {

        jl.setFont(new Font("宋体", 1, 18));//设置字体，0正常，1粗体
        jl.setForeground(Color.white);//设置颜色
        jl.setBounds(0, 0, DrawView.VIEW_HEIGHT * DrawView.VIEW_NUMBER + 70, 40);
        drawView.setBackground(new Color(51,51,51));
        drawView.setBounds(20, 50, DrawView.VIEW_WIDTH * DrawView.VIEW_NUMBER + 1, DrawView.VIEW_HEIGHT * DrawView.VIEW_NUMBER + 1);
        panel.setLayout(null);
        panel.setBackground(new Color(0,102,102));
        panel.setBounds(DrawView.VIEW_WIDTH * DrawView.VIEW_NUMBER + 40, 50, 150, DrawView.VIEW_HEIGHT * DrawView.VIEW_NUMBER);
        scoreTitle.setFont(new Font("宋体", 1, 18));//设置字体，0正常，1粗体
        scoreTitle.setForeground(Color.white);//设置颜色
        scoreTitle.setBounds(0, 0, 150, 50);
        score.setFont(new Font("宋体", 1, 20));//设置字体，0正常，1粗体
        score.setForeground(Color.white);//设置颜色
        score.setBounds(0, 50, 150, 40);
        rule.setBackground(new Color(0,128,128));
        rule.setBounds(0, 90, 150, 1);
        hint.setFont(new Font("宋体", 0, 16));//设置字体，0正常，1粗体
        hint.setBounds(10, 100, 130, 150);
        hint.setBackground(new Color(0,102,102));

        panel.add(scoreTitle);
        panel.add(score);
        panel.add(rule);
        panel.add(hint);
        this.add(jl);
        this.setTitle("SnakeGame-3.0");
        this.setSize(DrawView.VIEW_WIDTH * DrawView.VIEW_NUMBER + 210, DrawView.VIEW_HEIGHT * DrawView.VIEW_NUMBER + 70);
        this.setLocation(500, 200);
        this.setLayout(null);
        //this.setUndecorated(true);
        this.setBackground(new Color(0,128,128));
        this.add(drawView);
        this.add(panel);
        this.addKeyListener(new GameControl(snake));
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        this.setVisible(true);

    }

}