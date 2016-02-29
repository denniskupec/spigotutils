// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils;

import java.util.logging.Level;
import org.bukkit.Bukkit;

public class Log
{
    
   public static void info(String logMessage)
   {
      Bukkit.getLogger().log(Level.INFO, logMessage);
   }
   
   public static void warn(String logMessage)
   {
      Bukkit.getLogger().log(Level.WARNING, logMessage);
   }
   
   public static void error(String logMessage)
   {
      Bukkit.getLogger().log(Level.SEVERE, logMessage);
   }
   
   public static void config(String key, String value, String logMessage)
   {
      Bukkit.getLogger().log(Level.CONFIG, "{0} => {1} ({2})", new Object[]{key, value, logMessage});
   }
   
   public static void debug(String logMessage)
   {
      if(SpigotUtils.DEBUG)
      {
         Bukkit.getLogger().log(Level.INFO, "[D] {0}", logMessage);
      }
   }
    
}
