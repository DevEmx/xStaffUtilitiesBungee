package tk.emx.xstaffutilsbungee.listeners;

import tk.emx.xstaffutilsbungee.utils.ServerUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(ServerSwitchEvent e) {
        ProxiedPlayer p = e.getPlayer();
        if (p.hasPermission("staffutils.staffjoin")) {
            for (ProxiedPlayer online : ProxyServer.getInstance().getPlayers()) {
                if (online.hasPermission("staffutils.staffjoin")) {
                    online.sendMessage(ChatColor.BLUE + p.getName() + ChatColor.AQUA + " has joined " + ChatColor.BLUE + ServerUtils.getServer(p));
                }
            }
        }
    }
}
