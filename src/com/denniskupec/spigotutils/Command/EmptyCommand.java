// "SpigotUtils"
// Copyright (c) 2016 Dennis Kupec

package com.denniskupec.spigotutils.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class EmptyCommand implements CommandExecutor
{
    
    @Override
    public boolean onCommand(CommandSender cSender, Command cCommand, String cString, String[] args)
    {
       if(cSender instanceof Player) 
       {
          return true; 
       }
       
       return true;
    }
    
}
