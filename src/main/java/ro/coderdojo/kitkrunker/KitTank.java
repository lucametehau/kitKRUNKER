/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.coderdojo.kitkrunker;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author alexk
 */
public class KitTank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String args[]) {
        Player player = (Player) cs;
        Material SWORD = Material.DIAMOND_SWORD;
        ItemStack[] bow = new ItemStack[]{new ItemStack(SWORD, 1)};
        
        player.getInventory().addItem(bow);
        
        player.setMaxHealth(30.0);
        player.setHealth(30.0);
        return false;
    }
}

