package tk.emx.xstaffutilsbungee.staffchat;

import tk.emx.xstaffutilsbungee.StaffUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.List;

public class StaffChatCommand extends Command {

    public static List<ProxiedPlayer> staffChat = new ArrayList<ProxiedPlayer>();

    public StaffChatCommand() {
        super("staffchat", "staffutils.staffchat", "sc");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "You must be a player to execute this command."));
        }
        if (!sender.hasPermission("staffutils.staffchat")) {
            sender.sendMessage(ChatColor.RED + "No permission.");
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 0) {
            if (staffChat.contains(p)) {
                staffChat.remove(p);
                sender.sendMessage(ChatColor.GREEN + "You have toggled staff chat off.");
                return;
            }
            if (!staffChat.contains(p)) {
                staffChat.add(p);
                sender.sendMessage(ChatColor.GREEN + "You have toggled staff chat on.");
                return;
            }
        }
        else {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                b.append(" ");
                b.append(args[i]);
            }
            String message = b.toString();
            if (sender.hasPermission("staffutils.staffchat")) {
                StaffUtils.getInstance().getStaffChatManager().staffChatMessage((ProxiedPlayer) sender, message);
            }
        }
    }
}
