// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Schedule
{
    
   public static final ScheduledExecutorService Executor = Executors.newScheduledThreadPool(2);
   
   public static ScheduledFuture later(Runnable runme, int delay)
   {
      return Schedule.Executor.schedule(runme, delay, TimeUnit.SECONDS);
   }
    
}
