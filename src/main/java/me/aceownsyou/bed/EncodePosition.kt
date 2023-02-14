package me.aceownsyou.bed

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class EncodePosition : CommandExecutor {
    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        p0.sendMessage("${ChatColor.GOLD}${BedPlugin.encodeLocation((p0 as Player).location)}")
        return true;
    }
}