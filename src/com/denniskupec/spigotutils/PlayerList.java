// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils;

import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerList
{
    
   public static Collection list()
   {
      return Bukkit.getOnlinePlayers();
   }
    
   public static Player isOnline(String username)
   {
      return Bukkit.getOnlinePlayers().stream().filter((Player player) -> player.getName().equalsIgnoreCase(username)).findFirst().orElse(null);
   }
    
   public static int count()
   {
      return Bukkit.getOnlinePlayers().size();
   }
   
}
