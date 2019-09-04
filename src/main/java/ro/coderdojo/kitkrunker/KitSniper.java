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
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author LMM
 */
public class KitSniper implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String args[]) {
        Player player = (Player) cs;
        Material BOW = Material.BOW;
        ItemStack[] bow = new ItemStack[]{new ItemStack(BOW, 1)};
        ItemStack[] arrows = new ItemStack[]{new ItemStack(Material.ARROW, 64)};
        player.getInventory().addItem(bow);
        player.getInventory().addItem(arrows);
        player.setMaxHealth(14.0);
        player.setHealth(14.0);
        return false;
    }
}
