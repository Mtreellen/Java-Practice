import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
class ChessDemo extends Panel implements ActionListener{
    char whoTurn = 'O';  //人—O,计算机--X
    Button b[] = new Button[9];  //9个按钮
    StringBuffer chess = new StringBuffer("KKKKKKKKK");
    //将九宫格用一位数组来表示,用K字符表示空位置

    public ChessDemo(){
        setLayout(new GridLayout(3,3,3,3));
        for (int i=0;i<9;i++) {
            b[i] = new Button("");
            add(b[i]);
            b[i].setActionCommand(String.valueOf(i));
            b[i].addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Button me = (Button)(e.getSource());
        if (!me.getLabel().equals("")) //不允许在已有棋子位置下棋
            return;
        me.setLabel("" + whoTurn); 
        int row = Integer.parseInt(me.getActionCommand()); //求位置
        chess.setCharAt(row,whoTurn); 
        gameOver();  //判断游戏是否结束
        whoTurn = (whoTurn=='O') ? 'X' : 'O'; //轮换玩家
        computerTake();  //计算机下
    }

    public  int  findplace() { //计算机找下棋位置
        for (int r=0;r<9;r++)
            if (chess.charAt(r)=='K') {    //找个空位置
                chess.setCharAt(r,whoTurn);     //先填上棋子
                if (isWin(whoTurn))  { //看自己下此位置是否能赢
                    chess.setCharAt(r,'K');  // 恢复原状
                    return r;
                }
                else
                    chess.setCharAt(r,'K');   // 恢复原状
            }
        // 没自己能直接赢得位置再看对方能赢的地方
        char  whoTurn2 = (whoTurn=='O') ? 'X' : 'O'; 
        for (int r=0;r<9;r++)
            if (chess.charAt(r)=='K') {
                chess.setCharAt(r,whoTurn2);
                if (isWin(whoTurn2)) {
                    chess.setCharAt(r,'K');
                    return r;
                }
                else
                    chess.setCharAt(r,'K');
            }
        if (chess.charAt(4)=='K') {
            return 4;      //占据中央，返回4
        }
        else  {
            for (int d=1;d<5;d++) {   // 随机找个空位置
                int rand= (int)(Math.random() * 9);
                if (chess.charAt(rand)=='K')
                    return rand;
            }
        }
        return -1;  //特殊返回
    }

    public void computerTake(){
        int x = findplace();  //根据策略找位置
        chess.setCharAt(x,whoTurn);
        b[x].setLabel(String.valueOf(whoTurn));
        gameOver();
        whoTurn = (whoTurn=='O') ? 'X' : 'O';
    }

    public void gameOver() {
        if (isWin(whoTurn)) { //判是否取胜
            JOptionPane.showMessageDialog(null, whoTurn+" win!");
            System.exit(0);
        } else if (isFull()) { //判是否下满格子
            JOptionPane.showMessageDialog(null, "game is over!");
            System.exit(0);
        }
    }

    public boolean isWin(char who){
        String s3 = "" + who + who + who;
        String sum;
        String sum1;
        String sum2;//用来拼接一个方向的棋子标识
        for(int k=0;k<3;k++)
        {
            sum1=""+chess.charAt(k)+chess.charAt(k+3)+chess.charAt(k+6);//垂直方向
            sum2=""+chess.charAt(k*3+0)+chess.charAt(k*3+1)+chess.charAt(k*3+2);//水平方向
            if(sum1.equals(s3)||sum2.equals(s3))
            {
                return true;
            }
            else
            {
                sum1="";
                continue;
            }
        }
        sum=""+chess.charAt(0)+chess.charAt(4)+chess.charAt(8); //正对角线
        if (sum.equals(s3)) return true;
        sum=""+chess.charAt(2)+chess.charAt(4)+chess.charAt(6); //反对角线
        if (sum.equals(s3)) return true;
        return false;
    }

    public boolean isFull() {  //判是否棋盘下满了
        return chess.toString().indexOf("K")== -1;
    }

    public static void main(String args[]) {
        Frame f = new Frame();
        f.add(new ChessDemo());
        f.setSize(300,300);
        f.setVisible(true);
    }
}
