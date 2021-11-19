package tk.emx.xstaffutilsbungee.report;

import tk.emx.xstaffutilsbungee.StaffUtils;
import tk.emx.xstaffutilsbungee.utils.ServerUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ReportManager {

    private final StaffUtils plugin;

    public ReportManager(StaffUtils plugin) {
        this.plugin = plugin;
    }

    public void reportMessage(ProxiedPlayer reporter, ProxiedPlayer reported, String reason) {
        for (ProxiedPlayer online : ProxyServer.getInstance().getPlayers()) {
            if (online.hasPermission("staffutils.report.receive")) {
                online.sendMessage(ChatColor.GRAY + "[" + ServerUtils.getServer(reported) + "] " + ChatColor.DARK_RED + "" + ChatColor.BOLD +
                        "[REPORT] " + ChatColor.BLUE + reporter.getName() + ChatColor.AQUA + " has reported " + ChatColor.BLUE + reported.getName()
                        + ChatColor.AQUA + " for" + ChatColor.BLUE + reason);
            }
        }
    }
}
