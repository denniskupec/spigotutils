// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils.Command;

import com.denniskupec.spigotutils.PlayerList;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;

public class IsOnline implements CommandExecutor
{
   @Override
   public boolean onCommand(CommandSender cSender, Command cCommand, String cString, String[] args)
   {
      if(args.length < 1 || args[0] == null) {
         return false;
      }
       
      if(PlayerList.isOnline(args[0]) != null) {
         cSender.sendMessage("online");
      } else {
         cSender.sendMessage("offline");
      }
      
      return true;
   }
}
