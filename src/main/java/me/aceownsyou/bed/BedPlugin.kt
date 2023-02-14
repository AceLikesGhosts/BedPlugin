package me.aceownsyou.bed

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.plugin.java.JavaPlugin

class BedPlugin : JavaPlugin() {
    override fun onEnable() {
        defaultLocation = config.getString("defaultLocation", "world@0@0@0@0@0")?.let { decodeLocation(it) };
        useDefaultLocation = config.getBoolean("useDefaultLocation");

        logger.info("${ChatColor.GRAY}*--*=========================*--*");
        logger.info("${ChatColor.translateAlternateColorCodes('&', "&d")}» Loaded BedPlugin");
        logger.info("${ChatColor.GRAY}by ace.#0003");
        logger.info("");
        logger.info("${ChatColor.translateAlternateColorCodes('&', "&d")}» Config:");
        logger.info("useDefaultLocation: $useDefaultLocation");
        logger.info("defaultLocation: ${config.getString("defaultLocation", "world@0@0@0@0@0")}");
        logger.info("");
        logger.info("*--*=========================*--*");

        getCommand("bed")?.setExecutor(BedCommand());
        getCommand("encodeposition")?.setExecutor(EncodePosition());
    }

    override fun onDisable() {
    }

    companion object {
        var defaultLocation: Location? = null;
        var useDefaultLocation: Boolean = false;

        fun encodeLocation(loc: Location): String {
            return loc.world?.name
                .toString() + "@" + loc.x + "@" + loc.y + "@" + loc.z + "@" + loc.yaw + "@" + loc.pitch
        }

        fun decodeLocation(loc: String): Location {
            val args = loc.split("@").toTypedArray()
            return Location(
                Bukkit.getWorld(args[0]),
                args[1].toDouble(),
                args[2].toDouble(),
                args[3].toDouble(),
                args[4].toFloat(),
                args[5].toFloat()
            )
        }
    }
}