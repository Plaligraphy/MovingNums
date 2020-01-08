package serverpkg;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(4000);
        String line;
        try {
            while (true) {
                Socket socket = listener.accept();
                BufferedReader readerChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                try {
                    writerChannel.write(new Date().toString() + "\n\r");
                    writerChannel.flush();

                    while ((line = readerChannel.readLine()) != null) {
                        System.out.println(line);
                    }
                } finally {
                    socket.close();
                }
            }
        }finally{
            listener.close();
        }

    }
}
