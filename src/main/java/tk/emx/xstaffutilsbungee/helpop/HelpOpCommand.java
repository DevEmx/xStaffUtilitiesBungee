package tk.emx.xstaffutilsbungee.helpop;

import tk.emx.xstaffutilsbungee.StaffUtils;
import tk.emx.xstaffutilsbungee.utils.CooldownUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HelpOpCommand extends Command {

    public HelpOpCommand() {
        super("helpop", "", "ticket");
        CooldownUtils.createCooldown("Help");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "You must be a player to execute this command."));
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /helpop <message>");
            return;
        }
        if (CooldownUtils.isOnCooldown("Help", (ProxiedPlayer) sender)) {
            sender.sendMessage(ChatColor.RED + "You are on cooldown for another " + ChatColor.DARK_RED +
                    CooldownUtils.getCooldownForPlayerInt("Help", (ProxiedPlayer) sender) + ChatColor.RED + " seconds!");
        }
        else {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                b.append(" ");
                b.append(args[i]);
            }
            String reason = b.toString();

            sender.sendMessage(ChatColor.GREEN + "You have successfully requested assistance!");

            CooldownUtils.addCooldown("Help", (ProxiedPlayer) sender, 60);

            StaffUtils.getInstance().getHelpOpManager().helpopMessage((ProxiedPlayer) sender, reason);
        }
    }
}
