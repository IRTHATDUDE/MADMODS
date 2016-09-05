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

	ArrayList<String> requester = new ArrayList<String>();
	ArrayList<String> requested = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		final Player player = (Player) sender;
		if (command.getName().equalsIgnoreCase("mod")) {
			

			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You cannot execute command in console dummy!");
				return false;
			}

			// if(player.hasPermission("mod.main.default")){
			
			if (!(requester.contains(player.getName()))){

			sender.sendMessage(ChatColor.DARK_BLUE + "You have requested assistance from mod");
			
			}
			if (requester.contains(player.getName())){
				sender.sendMessage(ChatColor.RED + "You have already requested a Mod");
				return false;
				
			}
			
			requester.add(player.getName());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

				public void run() {
				

					requester.remove(player.getName());

				}

			}, 3600);
			// }
			return true;
		}

		
		for (Player player1 : Bukkit.getOnlinePlayers()) {
			if (player1.hasPermission("mod.main.mod")) {
				player.sendMessage(ChatColor.DARK_RED + player.getName() + "Has requested your assistance");
			}
		}

		return true;

	}
}
