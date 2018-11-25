package server.task;

import javafx.concurrent.Task;
import message.Message;
import server.Connection;

import java.io.EOFException;
import java.io.ObjectInputStream;

public class ReceiveTask extends Task<Message> {
    private final Connection connection;

    public ReceiveTask(Connection connection) {
        this.connection = connection;
    }

    @Override protected Message call() {
        try {


            ObjectInputStream inputStream = connection.getInputStream();
            while (!isCancelled()) {
                try {
                    Object receiveObject = inputStream.readObject();
                    if (receiveObject instanceof Message) {
                        Message message = (Message) receiveObject;
                        updateValue(message);
                    }
                } catch (EOFException e) {
                    Thread.sleep(10);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end receive");
        return null;
    }
}
