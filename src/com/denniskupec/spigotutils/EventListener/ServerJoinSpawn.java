// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils.EventListener;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class ServerJoinSpawn implements Listener
{
   
   @EventHandler(priority = EventPriority.HIGH)
   public void onJoinSpawn(PlayerSpawnLocationEvent Event)
   {
      Location serverSpawn = Event.getPlayer().getWorld().getSpawnLocation();
      
      if(Event.getSpawnLocation().equals(serverSpawn)) {
         Event.setSpawnLocation(serverSpawn.add(0.5, 0, 0.5));
      }
   }
   
}
