package com.example.WS;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String toString(){
        return String.format("id: %d\ncontent: %s", id, content);
    }
}