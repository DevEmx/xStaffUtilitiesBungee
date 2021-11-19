package tk.emx.xstaffutilsbungee.helpop;

import tk.emx.xstaffutilsbungee.StaffUtils;
import tk.emx.xstaffutilsbungee.utils.ServerUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class HelpOpManager {

    private final StaffUtils plugin;

    public HelpOpManager(StaffUtils plugin) {
        this.plugin = plugin;
    }

    public void helpopMessage(ProxiedPlayer p, String reason) {
        for (ProxiedPlayer online : ProxyServer.getInstance().getPlayers()) {
            if (online.hasPermission("staffutils.helpop.receive")) {
                online.sendMessage(ChatColor.BLUE + p.getName() + " has requested assistance on " + ChatColor.BOLD + ServerUtils.getServer(p) + ":");
                online.sendMessage(ChatColor.AQUA + "          " + reason);
            }
        }
    }
}
