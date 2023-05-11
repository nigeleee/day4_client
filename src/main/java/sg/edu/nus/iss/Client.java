package sg.edu.nus.iss;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialArray;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        String host = args[0];
        String port = args[1];
        
        Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
        
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        DataInputStream dis = new DataInputStream(bis);

        // create a data stream to send data
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        DataOutputStream dos = new DataOutputStream(bos);

        //creating string variable to store user input
        String msg = "";
        String reply = "";
        //creating a scanner to allow user input
        Scanner scanner = new Scanner(System.in);
        
        while(!msg.equals("close")) {
            msg = scanner.nextLine();
            
            if (msg.equals("get-cookie")) {
            //when sending a string, use UTF 
            
            dos.writeUTF(msg);
            dos.flush();
            reply = dis.readUTF();
            System.out.println(reply);
        }
            
        
    } 

    dos.close();
    bos.close();
    
    dis.close();
    bis.close();

        socket.close();
    }
}

