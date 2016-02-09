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
