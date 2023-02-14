package me.aceownsyou.bed

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class BedCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if(sender.isOp && args.size == 1) {
            val player: Player? = Bukkit.getPlayer(args[0]);

            if(player == null) {
                sender.sendMessage(ChatColor.RED.toString() + "Failed to find player \"" + args[0] + "\".");
                return true;
            }

            weirdTeleport(player, sender as Player);
            return true;
        }

        weirdTeleport(sender as Player, null);
        return true;
    }

    private fun weirdTeleport(to: Player, forcer: Player?)
    {
        if(forcer !== null)
        {
            teleportToOther(to, forcer);
            return;
        }

        val location: Location? = to.bedSpawnLocation;

        if(location == null && BedPlugin.useDefaultLocation)
        {
            to.teleport(BedPlugin.defaultLocation as Location);
            to.sendMessage("${ChatColor.RED}Failed to find your bed, teleported you to default location!");
            to.sendMessage("${ChatColor.GRAY}If you do not like this functionality, contact the server owner.");
            return;
        }
        else if(location == null && !BedPlugin.useDefaultLocation)
        {
            to.sendMessage("${ChatColor.RED}Failed to find your bed! Is it missing or obstructed?")
            return;
        }

        to.teleport(location as Location);
        to.sendMessage("${ChatColor.GOLD}Teleported you to your bed!")
    }

    private fun teleportToOther(to: Player, forcer: Player)
    {
        val location: Location? = to.bedSpawnLocation;

        if(location == null)
        {
            forcer.sendMessage("${ChatColor.WHITE}${to.name} ${ChatColor.RED}has no bed!");
            return;
        }

        forcer.teleport(location);
        forcer.sendMessage("${ChatColor.GOLD}Teleported you to ${ChatColor.WHITE}${to.displayName}${ChatColor.GOLD}'s bed.")
    }
}