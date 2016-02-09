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

package com.denniskupec.spigotutils;

import org.bukkit.plugin.java.JavaPlugin;
import com.denniskupec.spigotutils.Command.*;
import com.denniskupec.spigotutils.EventListener.*;
import org.bukkit.Bukkit;

// Firebase token
// wnjvHzQkjmtf5WX0npFNF4EujDq76DyX3IfRsg13

public class SpigotUtils extends JavaPlugin
{

   private static SpigotUtils Instance = null;
   public final static boolean DEBUG = false;
   public final static String PREFIX = "§6>> §a";
   public final static String PREFIX_BC = "§6!!! §r§c";
    
   public void SpigotUtils()
   {
      SpigotUtils.Instance = this;
   }
    
   @Override
   public void onEnable()
   {
      this.getConfig().options().copyDefaults(true);
      saveConfig();
      
      this.getCommand("tpa").setExecutor(new Teleport());
      this.getCommand("tpaccept").setExecutor(new Teleport());
      this.getCommand("tpdeny").setExecutor(new Teleport());
      this.getCommand("broadcast").setExecutor(new Broadcast());
      this.getCommand("spawn").setExecutor(new Spawn());
      this.getCommand("setspawn").setExecutor(new SetSpawn());
      //this.getCommand("isonline").setExecutor(new IsOnline());
      
      // event listeners
      Bukkit.getServer().getPluginManager().registerEvents(new PlayerSleep(), this);
      Bukkit.getServer().getPluginManager().registerEvents(new ServerJoinSpawn(), this);
   }
   
   @Override
   public void onDisable()
   {
      
   }
    
   public static SpigotUtils getInstance()
   {
      return SpigotUtils.Instance;
   }
    
   public static void main(String[] args)
   {
   }
}
