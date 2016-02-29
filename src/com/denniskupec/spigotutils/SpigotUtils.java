// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils;

import org.bukkit.plugin.java.JavaPlugin;
import com.denniskupec.spigotutils.Command.*;
import com.denniskupec.spigotutils.EventListener.*;
import org.bukkit.Bukkit;

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
