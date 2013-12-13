package com.github.pblolpb.noshift;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoShift extends JavaPlugin implements Listener {

	public void onEnable () {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerShift(PlayerToggleSneakEvent event){
		Player player = event.getPlayer();
		if(!player.hasPermission("noshift.shift")){
			if(!event.isSneaking()){
				event.setCancelled(true);
			}
		}
	}
}