package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws Exception {

        String port = args[0];
        String fileName = args[1];
       
        File file = new File(fileName);
        // if(!file.exists()) {
        //     System.out.println("Cookie file not found");
        //     System.exit(0);
        // }

        //creating serversocket object
        ServerSocket ss = new ServerSocket(Integer.parseInt(port));
        System.out.println("Listening on port: " + port);

        //accepting connection
        Socket socket = ss.accept();
        System.out.println("Connection is established");
       
        //create a data stream to accept data
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        DataInputStream dis = new DataInputStream(bis);

        // create a data stream to send data
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        DataOutputStream dos = new DataOutputStream(bos);

        // create string to store client message
        String msg = "";

         // before can use method of class must create an object of that class
        Cookie cookie = new Cookie();
        cookie.readCookie(fileName);
        

        while (!msg.equals("close")) {
       
            msg = dis.readUTF();

            if(msg.equalsIgnoreCase("get-cookie")) {

                String reply = cookie.cookieText();
                dos.writeUTF(reply);
                
                dos.flush();
                
        } 

    } 
                dos.close();
                bos.close();

                dis.close();
                bis.close();

                socket.close();
                

    }
}
