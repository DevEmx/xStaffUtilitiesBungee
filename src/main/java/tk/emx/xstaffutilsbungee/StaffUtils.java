package tk.emx.xstaffutilsbungee;

import tk.emx.xstaffutilsbungee.helpop.HelpOpCommand;
import tk.emx.xstaffutilsbungee.helpop.HelpOpManager;
import tk.emx.xstaffutilsbungee.listeners.JoinListener;
import tk.emx.xstaffutilsbungee.listeners.LeaveListener;
import tk.emx.xstaffutilsbungee.report.ReportCommand;
import tk.emx.xstaffutilsbungee.report.ReportManager;
import tk.emx.xstaffutilsbungee.staffchat.StaffChatCommand;
import tk.emx.xstaffutilsbungee.staffchat.StaffChatListener;
import tk.emx.xstaffutilsbungee.staffchat.StaffChatManager;
import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

public class StaffUtils extends Plugin {

    @Getter public static StaffUtils instance;
    @Getter public HelpOpManager helpOpManager;
    @Getter public ReportManager reportManager;
    @Getter public StaffChatManager staffChatManager;

    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new JoinListener());
        getProxy().getPluginManager().registerListener(this, new LeaveListener());
        getProxy().getPluginManager().registerListener(this, new StaffChatListener());

        getProxy().getPluginManager().registerCommand(this, new HelpOpCommand());
        getProxy().getPluginManager().registerCommand(this, new ReportCommand());
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand());

        registerManagers();
    }

    private void registerManagers() {
        this.helpOpManager = new HelpOpManager(this);
        this.reportManager = new ReportManager(this);
        this.staffChatManager = new StaffChatManager(this);
    }
}
