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
