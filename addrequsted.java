package mod;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class addrequsted extends JavaPlugin implements Listener {
	ArrayList<String> requested = new ArrayList<String>();
	ArrayList<String> active = new ArrayList<String>();
	ArrayList<String> requester = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		active.add(player.getName());
		if (command.getName().equalsIgnoreCase("add") && sender.hasPermission("mod.change")) {

			requested.add(player.getName());
			// requested.remove(player1.getName());
		}
		if (command.getName().equalsIgnoreCase("remove") && sender.hasPermission("mod.change")) {

			// requested.add(player.getName());
			requested.remove(player.getName());
		}

		for (Player player1 : Bukkit.getOnlinePlayers()) {
			if (player1.hasPermission("mod.main.mod")) {
				if (player1.hasPermission("mod.main.change")) {
				if(getCommand("mod") != null){

					if (!(requested.contains(player.getName()))) {
						player.sendMessage(ChatColor.DARK_BLUE + ((CommandSender) requester).getName() + "Has requested your assistance");
						// requested.remove(player1.getName());

					}

				}
				}

			}
		}return true;
	}
}
