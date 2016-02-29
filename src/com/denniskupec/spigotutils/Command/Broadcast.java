// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils.Command;

import static com.denniskupec.spigotutils.SpigotUtils.PREFIX_BC;
import static com.denniskupec.spigotutils.SpigotUtils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor
{
       
   @Override
   public boolean onCommand(CommandSender cSender, Command cCommand, String cString, String[] args)
   {
      if(args.length == 0) {
         cSender.sendMessage(new String[]{
            PREFIX + "Usage: /broadcast <message>",
            PREFIX + "Colors: §0&0 §1&1 §2&2 §3&3 §4&4 §5&5 §6&6 §7&7 §8&8 §9&9 §a&a §b&b §c&c §d&d §e&e §f&f §l&l§r §m&m§r §n&n§r §o&o§r §r&r"
         });
         return true;
      }
      
      if(cSender.isOp()) {
      
         StringBuilder string = new StringBuilder();
      
         for(int i=0; i<args.length; i++) {
            string.append(args[i].replace("&", "\u00A7"));
         
            if(args.length != i+1) {
               string.append(" ");
            }
         }
      
         Bukkit.broadcastMessage(PREFIX_BC + string.toString());
         
         return true;
      }
      
      cSender.sendMessage(PREFIX + "You have no permission to use this command.");
      return true;
   }
}
