package tk.emx.xstaffutilsbungee.staffchat;

import tk.emx.xstaffutilsbungee.StaffUtils;
import tk.emx.xstaffutilsbungee.utils.ServerUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class StaffChatManager {

    private final StaffUtils plugin;

    public StaffChatManager(StaffUtils plugin) {
        this.plugin = plugin;
    }

    public void staffChatMessage(ProxiedPlayer p, String message) {
        for (ProxiedPlayer online : ProxyServer.getInstance().getPlayers()) {
            if (online.hasPermission("staffutils.staffchat")) {
                online.sendMessage(ChatColor.GRAY + "[" + ServerUtils.getServer(p) + "] " + ChatColor.BLUE + p.getName() + ChatColor.GRAY + ":" + ChatColor.AQUA + message);
            }
        }
    }
}
