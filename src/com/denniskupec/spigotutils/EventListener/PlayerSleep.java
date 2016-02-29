// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils.EventListener;

import com.denniskupec.spigotutils.Schedule;
import static com.denniskupec.spigotutils.SpigotUtils.PREFIX;
import com.denniskupec.spigotutils.Time;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerSleep implements Listener
{
   
   protected static double pSleepCount = 0.00;
   
   @EventHandler
   public void onBedEnter(PlayerBedEnterEvent Event)
   {
      PlayerSleep.pSleepCount++;
      
      double ratio = PlayerSleep.pSleepCount / Bukkit.getOnlinePlayers().size();
      
      if(ratio >= 0.5) {
         Schedule.later(()-> {
            Event.getPlayer().getWorld().setTime(Time.MORNING);
            Bukkit.broadcastMessage(PREFIX + "Time set to morning.");
         }, 3);
      }
   }
   
   @EventHandler
   public void onBedLeave(PlayerBedLeaveEvent Event)
   {
      PlayerSleep.pSleepCount--;
   }
   
}
