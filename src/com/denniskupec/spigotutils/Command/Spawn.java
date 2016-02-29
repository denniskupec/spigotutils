// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils.Command;

import static com.denniskupec.spigotutils.SpigotUtils.PREFIX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Spawn implements CommandExecutor
{
       
   @Override
   public boolean onCommand(CommandSender cSender, Command cCommand, String cString, String[] args)
   {
      if(cSender instanceof Player == false) {
         cSender.sendMessage(PREFIX + "Command cannot be run from console.");
         return true; 
      }
       
      Player player = (Player) cSender;

      cSender.sendMessage(PREFIX + "Teleporting to spawn...");
      
      player.teleport(player.getWorld().getSpawnLocation().add(0.50, 0, 0.50), PlayerTeleportEvent.TeleportCause.PLUGIN);
      
      return true;
   }
}
