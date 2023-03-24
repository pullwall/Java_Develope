import java.io.IOException;

import java.util.ArrayList;

import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer {
    private static final String TAG = "ChatServer : "; // 태그 생성.
    private ArrayList<ServerThread> vcClient;
    private ServerSocket serverSocket;
    private Socket socket;

    public static final int cs_port = 2777;
    public static final int cs_maxclient = 50;

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(cs_port);
            vcClient = new ArrayList<>();
            while(true) {
                socket = null;
                ServerThread ci = null;
                System.out.println(TAG + "클라이언트 요청 대기중.....");
                try {
                    socket = serverSocket.accept();
                    ci = new ServerThread(socket);
                    System.out.println(TAG + "요청이 성공함");
                    ci.start();
                    vcClient.add(ci);
                } catch(IOException e) {
                    System.out.println(TAG + e);
                    try {
                        if (socket != null) socket.close();
                    } catch(IOException el) {
                        System.out.println(TAG + el);
                    } finally {
                        socket = null;
                    }
                }
                
            }
        } catch (Exception e) {
             System.out.println(TAG + "연결안됨");
        }
    } 
    
}

    
