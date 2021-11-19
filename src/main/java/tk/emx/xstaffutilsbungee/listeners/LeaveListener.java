package tk.emx.xstaffutilsbungee.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerDisconnectEvent e) {
        ProxiedPlayer p = e.getPlayer();
        if (p.hasPermission("staffutils.staffjoin")) {
            for (ProxiedPlayer online : ProxyServer.getInstance().getPlayers()) {
                if (online.hasPermission("staffutils.staffjoin")) {
                    online.sendMessage(ChatColor.BLUE + p.getName() + ChatColor.AQUA + " has disconnected.");
                }
            }
        }
    }
}
