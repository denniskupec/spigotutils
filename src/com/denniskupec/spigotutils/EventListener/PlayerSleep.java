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
