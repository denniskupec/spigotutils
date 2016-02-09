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
import com.denniskupec.spigotutils.Schedule;
import com.denniskupec.spigotutils.Log;
import com.denniskupec.spigotutils.PlayerList;
import com.denniskupec.spigotutils.SpigotUtils;
import java.util.HashMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class Teleport implements CommandExecutor
{
    
   public static HashMap<Player, Player> tpQueue = new HashMap();
   
   public void Teleport()
   {
      Log.debug("Teleport queue initialized. (size = " + Teleport.tpQueue.size() + ")");
   }

   @Override
   public boolean onCommand(CommandSender cSender, Command cCommand, String cString, String[] args)
   {
      if(cSender instanceof Player == false) {
         cSender.sendMessage("Command cannot be executed from console.");
         return false;
      }
       
      switch(cString) {
         case "tpa":
            return this.doTeleportRequest(cSender, cCommand, cString, args);
           
         case "tpaccept":
            return this.doTeleportAccept(cSender, cCommand, cString, args);
            
         case "tpdeny":
            return this.doTeleportDeny(cSender, cCommand, cString, args);
               
         default:
            return false;
               
      }
   }
    
   protected boolean doTeleportRequest(CommandSender cSender, Command cCommand, String cString, String[] args)
   {
      if(args.length < 1 || args[0] == null) {
         return false;
      }
       
      Player PlayerB = PlayerList.isOnline(args[0]);
       
      if(PlayerB == null) {
         cSender.sendMessage(PREFIX + "Player is not online.");
         return true;
      }
      
      if(PlayerB.equals((Player) cSender) && !SpigotUtils.DEBUG) {
         cSender.sendMessage(PREFIX + "You cannot teleport to yourself.");
         return true;
      }
      
      if(Teleport.tpQueue.containsKey((Player) cSender)) {
         Teleport.tpQueue.remove((Player) cSender);
      }

      Teleport.tpQueue.put((Player) cSender, PlayerB);
      
      Log.debug("Players " + cSender.getName() + " ==> " + PlayerB.getName() + " added to teleport queue. (size " + Teleport.tpQueue.size() + ")");
      
      PlayerB.sendMessage(PREFIX + ChatColor.BOLD + cSender.getName() + ChatColor.RESET + ChatColor.RED + " has requested to teleport to your location.");
      PlayerB.sendMessage(PREFIX + "Type " + ChatColor.BOLD + "/tpaccept" + ChatColor.RESET + ChatColor.RED + " to accept or " + ChatColor.BOLD + "/tpdeny" + ChatColor.RESET + ChatColor.RED + " to reject.");
      cSender.sendMessage(PREFIX + "Requesting teleport...");

      Schedule.later(() -> {
         if(Teleport.tpQueue.containsKey((Player) cSender)) {
            Teleport.tpQueue.remove((Player) cSender);
            cSender.sendMessage(PREFIX + "Teleport request expired.");
            Log.info(cSender.getName() + " removed from teleport queue. 180 sec. timeout reached.");
         }
      }, 180);
       
      return true;
   }
    
   public boolean doTeleportDeny(CommandSender cSender, Command cCommand, String cString, String[] args)
   {
      Player PlayerB = (Player) cSender;
      
      Log.debug("teleport deny response from: " + cSender.getName());
      
      if(Teleport.tpQueue.containsValue(PlayerB)) {
         Player PlayerA = Teleport.tpQueue.entrySet().stream().filter(entry -> entry.getValue().equals(PlayerB)).findFirst().get().getKey();
         
         Teleport.tpQueue.remove(PlayerA);
         
         Log.debug("removing from queue PlayerA: " + PlayerA.getName());

         PlayerA.sendMessage(PREFIX + "Teleport request rejected.");
         PlayerB.sendMessage(PREFIX + "Teleport request rejected.");
         
         return true;
      }
      
      Log.debug("Player was not in queue, nothing to deny!");
      return false;
   }
    
   public boolean doTeleportAccept(CommandSender cSender, Command cCommand, String cString, String[] args)
   {
      Player PlayerB = (Player) cSender;
      
      Log.debug("teleport accept response from: " + PlayerB.getName());
       
      if(Teleport.tpQueue.containsValue(PlayerB)) {
         
        Player PlayerA = Teleport.tpQueue.entrySet().stream().filter(entry -> entry.getValue().equals(PlayerB)).findFirst().get().getKey();
            
         Teleport.tpQueue.remove(PlayerA);
         Log.debug("removing from queue PlayerA: " + PlayerA.getName());
         
         PlayerB.sendMessage(PREFIX + "Teleport request accepted!");
         PlayerA.sendMessage(PREFIX + "Teleporting...");
         
         if(SpigotUtils.DEBUG) {
            PlayerA.teleport(PlayerB.getWorld().getSpawnLocation());
         } else {
            PlayerA.teleport(PlayerB);
         }
         
         PlayerB.sendMessage(PREFIX + ChatColor.BOLD + PlayerA.getName() + ChatColor.RESET + ChatColor.GREEN + " has arrived!");
         
         return true;
      }
      
      Log.debug("Player was not in queue, nothing to deny!");
      return false;
   }
      
}
