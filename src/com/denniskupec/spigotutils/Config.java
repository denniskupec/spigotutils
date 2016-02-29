// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils;

import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;

public class Config
{
   
   public static void set(String path, Object value)
   {
     Config.loadConfig().set(path, value);
   }
   
   public static Object get(String path)
   {
      return Config.loadConfig().get(path);
   }
   
   public static int getInt(String path)
   {
      return Config.loadConfig().getInt(path);
   }
   
   public static boolean getBool(String path)
   {
      return Config.loadConfig().getBoolean(path);
   }
   
   public static String getString(String path)
   {
      return Config.loadConfig().getString(path);
   }
   
   public static Color delete(String path)
   {
      return Config.loadConfig().getColor(path);
   }
   
   public static boolean has(String path)
   {
      return Config.loadConfig().contains(path);
   }
   
   public static void addDefault(String path, Object value)
   {
      Config.loadConfig().addDefault(path, value);
   }
   
   public static FileConfiguration loadConfig()
   {
      return SpigotUtils.getInstance().getConfig();
   }
   
   public static void save()
   {
      SpigotUtils.getInstance().saveConfig();
   }
   
}
