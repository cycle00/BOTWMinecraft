package cycle00.botw;

import cycle00.botw.utils.NPC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin implements Listener {

    // TODO: make different classes
    // it's all in the same class to save time

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (NPC.getNPCs() == null)
            return;
        if (NPC.getNPCs().isEmpty())
            return;
        NPC.addJoinPacket(event.getPlayer());
    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("test")){
            if (!(sender instanceof Player)) {
                sender.sendMessage("no");
                return false;
            }

            Player player = (Player) sender;
            NPC.createNPC(player);
            return true;
        }
        return false;
    }
}
