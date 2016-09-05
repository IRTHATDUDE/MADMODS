package mod;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getLogger().info("IT WORRKS!");
	}

	@Override
	public void onDisable() {
		getLogger().info("IT WORRKS!");
	}

	public void chatAI() {

	}

	ArrayList<Player> requester = new ArrayList<Player>();
	ArrayList<Player> requested = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if (command.getName().equalsIgnoreCase("mod")) {
			if (requester.contains(player))
				;

			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You cannot execute command in console dummy!");
				return false;
			}

			// if(player.hasPermission("mod.main.default")){

			player.sendMessage(ChatColor.DARK_BLUE + "You have requested assistance from mod");
			requester.add(player);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

				public void run() {

					requester.remove(player);

				}

			}, 3600);
			// }
			return true;
		}

		String send = Bukkit.getName();
		for (Player player1 : Bukkit.getOnlinePlayers()) {
			if (player1.hasPermission("mod.main.mod")) {
				player.sendMessage(ChatColor.DARK_RED + Bukkit.getName() + "Has requested your assistance");
			}
		}

		return true;

	}
}
