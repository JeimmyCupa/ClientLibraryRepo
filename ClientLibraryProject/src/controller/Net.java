package controller;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Net {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    public Net(Socket socket) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        
    }
    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    public DataInputStream getInput() {
        return input;
    }
    public void setInput(DataInputStream input) {
        this.input = input;
    }
    public DataOutputStream getOutput() {
        return output;
    }
    public void setOutput(DataOutputStream output) {
        this.output = output;
    }
    public void close() {
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
