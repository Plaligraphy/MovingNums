package pkg;


import java.util.Arrays;
import java.util.Scanner;

public class Snake {
    int[] col1 = new int[7];
    int[] col2 = new int[7];
    int[] col3 = new int[7];
    int[] col4 = new int[7];
    int[] col5 = new int[7];
    int[] col0 = new int[7];
    int curX;
    int curY;
    public void init() throws InterruptedException {
        setCurs();
        zero();
        cls();
        setSnakePos(curX,curY,1);
        start();
    }
    private void setCurs() {
        curX = 3;
        curY = 3;
    }
    private void start() throws InterruptedException {
        checkBounds();
        cls();
        Scanner in = new Scanner(System.in);
        draw();
        System.out.println("up/down/left/right?");
        String dir = in.nextLine();
        if(dir.equalsIgnoreCase("up")) {
            curY--;
        }else if(dir.equalsIgnoreCase("down")) {
            curY++;
        }else if(dir.equalsIgnoreCase("left")) {
            curX--;
        }else if(dir.equalsIgnoreCase("right")) {
            curX++;
        }else if(dir.equalsIgnoreCase("e")) {
            System.exit(0);
        }
        zero();
        setSnakePos(curX,curY,1);
        draw();
        Thread.sleep(2000);
        cls();
        start();
    }private void checkBounds() {
        if(curX > 6) {
            curX=3;
        }
        if(curY > 6) {
            curY=3;
        }
    }
    private void zero(){
        Arrays.fill(col0, 0);
        Arrays.fill(col1, 0);
        Arrays.fill(col2, 0);
        Arrays.fill(col3, 0);
        Arrays.fill(col4, 0);
        Arrays.fill(col5, 0);
    }private void draw() {
        System.out.println(col0[0]+"  "+col0[1]+"  "+col0[2]+"  "+col0[3]+"  "+col0[4]+"  "+col0[5]);
        System.out.println(col1[0]+"  "+col1[1]+"  "+col1[2]+"  "+col1[3]+"  "+col1[4]+"  "+col1[5]);
        System.out.println(col2[0]+"  "+col2[1]+"  "+col2[2]+"  "+col2[3]+"  "+col2[4]+"  "+col2[5]);
        System.out.println(col3[0]+"  "+col3[1]+"  "+col3[2]+"  "+col3[3]+"  "+col3[4]+"  "+col3[5]);
        System.out.println(col4[0]+"  "+col4[1]+"  "+col4[2]+"  "+col4[3]+"  "+col4[4]+"  "+col4[5]);
        System.out.println(col5[0]+"  "+col5[1]+"  "+col5[2]+"  "+col5[3]+"  "+col5[4]+"  "+col5[5]);

    }private void setSnakePos(int x, int y, int charNum) {
        switch(y) {
            case 0:
                col0[x] = charNum;
                break;
            case 1:
                col1[x] = charNum;
                break;
            case 2:
                col2[x] = charNum;
                break;
            case 3:
                col3[x] = charNum;
                break;
            case 4:
                col4[x] = charNum;
                break;
            case 5:
                col5[x] = charNum;
                break;
            /*case 6:
                col6[x] = 1;
                break;*/
        }
    }private void cls() {
        for(int i = 0; i < 1000; i++) {
                System.out.println();
            }
    }
}
