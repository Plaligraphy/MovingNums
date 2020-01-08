package serverpkg;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class SampleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 4000);
        BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader readerChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;

        writerChannel.write("Connected to client");
        writerChannel.flush();

        while ((line = readerChannel.readLine()) != null)
        {
            System.out.println(line);
        }

    }
}
