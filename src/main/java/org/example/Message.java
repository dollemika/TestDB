package org.example;

public class Message {
    public Message(int id, String text, User sender, User target) {
        this.id = id;
        this.text = text;
        this.sender = sender;
        this.target = target;
    }

    int id;
    String text;
    User sender;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", sender=" + sender +
                ", target=" + target +
                '}';
    }

    User target;
}
