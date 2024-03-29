package main.me.gledoussal.status;


import main.ch.jamiete.mcping.MinecraftPing;
import main.ch.jamiete.mcping.MinecraftPingOptions;
import main.ch.jamiete.mcping.MinecraftPingReply;

import java.io.IOException;

public class Server {
    private MinecraftPingReply response;
    public Server(String ip, int port) {
        try {
            response = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname(ip).setPort(port));
        } catch (IOException e) {
            response = null;
        }
    }

    public boolean isOnline() {
        return response != null;
    }

    public int getPlayersCount() {
        return response.getPlayers().getOnline();
    }

    public int getMaxPlayers() {
        return response.getPlayers().getMax();
    }
}
