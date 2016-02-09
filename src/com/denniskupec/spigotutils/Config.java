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
