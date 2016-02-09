/*

SpigotUtils

The MIT License (MIT)

Copyright (c) 2016 Dennis Kupec

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

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
