// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils.Command;

import static com.denniskupec.spigotutils.SpigotUtils.PREFIX;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor
{
   
   @Override
   public boolean onCommand(CommandSender cSender, Command cCommand, String cString, String[] args)
   {
      if(cSender instanceof Player == false) {
         cSender.sendMessage(PREFIX + "Command cannot be run from console.");
         return true; 
      }

      if(cSender.isOp()) {
         
         Player player = (Player) cSender;
         World world = player.getWorld();
         Location pLocation = player.getLocation();
      
         world.setSpawnLocation(pLocation.getBlockX(), pLocation.getBlockY(), pLocation.getBlockZ());
      
         player.sendMessage(PREFIX + "Set spawn location.");
         
         return true;
      }
      
      cSender.sendMessage(PREFIX + "You have no permission to use this command.");
      return true;
   }
   
}
