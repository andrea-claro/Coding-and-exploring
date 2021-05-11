package com.example.profiles;

public class DataSource {

    private int port;
    private String server;

    public DataSource(){

    }

    public DataSource(int port, String server) {
        this.port = port;
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "port=" + port +
                ", server='" + server + '\'' +
                '}';
    }
}
