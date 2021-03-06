package pkg;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Snake {
    int[] col0 = new int[7];
    int[] col1 = new int[7];
    int[] col2 = new int[7];
    int[] col3 = new int[7];
    int[] col4 = new int[7];
    int[] col5 = new int[7];
    boolean game_running;
    int curX;
    int curY;

    public void init() throws InterruptedException, IOException {
        //TwoPlayer();
        setCurs();              //Sets beginning player position
        zero();                 //Zeros Arrays controlling screen
        cls();                  //Clears Screen
        setPos(curX, curY, 1);//Sets position of character(curX is X coord)(curY is Y coord)(charNum is character select)
        game_running = true;    //Sets while loop to continue looping game
        start();            //Runs method 'start'
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
        System.out.println("Current Coords: (" + curX + "," + curY + ")");
        System.out.println("up/down/left/right?");
        String dir = in.nextLine();
        if (dir.equalsIgnoreCase("up")) {
            curY--;
        } else if (dir.equalsIgnoreCase("down")) {
            curY++;
        } else if (dir.equalsIgnoreCase("left")) {
            curX--;
        } else if (dir.equalsIgnoreCase("right")) {
            curX++;
        } else if (dir.equalsIgnoreCase("e")) {
            System.exit(0);
        } else if (dir.equalsIgnoreCase("refresh")) {
            start();
        }
        zero();
        setPos(curX, curY, 1);
        draw();
        Thread.sleep(1500);
        cls();
        while (game_running) {
            start();
        }
    }

    private void checkBounds() throws InterruptedException {
        if (curX >= 6 || curX <= 0) {
            System.exit(0);
        }
        if (curY >= 6 || curY <= 0) {
            System.exit(0);
        }
    }

    private void zero() {
        Arrays.fill(col0, 0);
        Arrays.fill(col1, 0);
        Arrays.fill(col2, 0);
        Arrays.fill(col3, 0);
        Arrays.fill(col4, 0);
        Arrays.fill(col5, 0);
    }

    private void draw() {
        System.out.println(col0[0] + "  " + col0[1] + "  " + col0[2] + "  " + col0[3] + "  " + col0[4] + "  " + col0[5]);
        System.out.println(col1[0] + "  " + col1[1] + "  " + col1[2] + "  " + col1[3] + "  " + col1[4] + "  " + col1[5]);
        System.out.println(col2[0] + "  " + col2[1] + "  " + col2[2] + "  " + col2[3] + "  " + col2[4] + "  " + col2[5]);
        System.out.println(col3[0] + "  " + col3[1] + "  " + col3[2] + "  " + col3[3] + "  " + col3[4] + "  " + col3[5]);
        System.out.println(col4[0] + "  " + col4[1] + "  " + col4[2] + "  " + col4[3] + "  " + col4[4] + "  " + col4[5]);
        System.out.println(col5[0] + "  " + col5[1] + "  " + col5[2] + "  " + col5[3] + "  " + col5[4] + "  " + col5[5]);

    }

    private void setPos(int x, int y, int charNum) {
        switch (y) {
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
        }
    }

    private void cls() {
        for (int i = 0; i < 1000; i++) {
            System.out.println();
        }
    }

    private void TwoPlayer() throws IOException {
        String line = "";
        String line2 = "";
        String send = "";
        Socket data;
        ServerSocket ss = new ServerSocket(5000);
        new Socket("127.0.0.1", 5000);
        data = ss.accept();
        System.out.println("Accepted!");
        DataInputStream dis = new DataInputStream(new BufferedInputStream(data.getInputStream()));
        DataOutputStream dos = new DataOutputStream(data.getOutputStream());
        while (!line.equalsIgnoreCase("over")) {
            line = dis.readUTF();
            System.out.println(line);
        }
        while (!line2.equalsIgnoreCase("over")) {
            line2 = send;
            dos.writeUTF(line2);
        }
        ss.close();
        dis.close();
        dos.close();


    }
}
