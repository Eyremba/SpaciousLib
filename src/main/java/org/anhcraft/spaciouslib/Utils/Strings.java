package org.anhcraft.spaciouslib.Utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Strings {
    private String prefix;

    /**
     * Manage chat string in server
     *
     * @param prefix Chat prefix
     *
     */
    public Strings(String prefix){
        this.prefix = prefix;
    }

	public String reword(String a){
		return a.replace("&", "§");
	}

	public void sendSender(String a) {
        Bukkit.getConsoleSender().sendMessage(reword(prefix + a));
    }

    public void sendSenderNoPrefix(String a) {
        Bukkit.getServer().getConsoleSender().sendMessage(reword(a));
    }

    public void sendPlayer(String a, Player p) {
        p.sendMessage(reword(prefix + a));
    }

    public void sendPlayerNoPrefix(String a, Player p) {
        p.sendMessage(reword(a));
    }

    public void sendSender(String a, CommandSender s) {
        s.sendMessage(reword(prefix + a));
    }

    public void sendSenderNoPrefix(String a, CommandSender s) {
        s.sendMessage(reword(a));
    }

    public void sendAllPlayers(String a) {
        for(Player p: Bukkit.getServer().getOnlinePlayers()) {
             p.sendMessage(reword(prefix + a));
        }
    }

    public void sendAllPlayersNoPrefix(String a) {
        for(Player p: Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage(reword(a));
        }
    }

    public void sendGlobal(String a) {
        Bukkit.getServer().broadcastMessage(reword(prefix + a));
    }

    public void sendGlobalNoPrefix(String a) {
        Bukkit.getServer().broadcastMessage(reword(a));
    }

    public void sendGlobal(String a, World w){
        for(Player p: w.getPlayers()){
            sendPlayer(a, p);
        }
    }

    public void sendGlobalNoPrefix(String a, World w) {
        for(Player p: w.getPlayers()){
            sendPlayerNoPrefix(a, p);
        }
    }
}
