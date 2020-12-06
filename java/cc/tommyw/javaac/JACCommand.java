package cc.tommyw.javaac;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JACCommand implements CommandExecutor {

	private final Main plugin;
	
	public JACCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender pSender, Command pCmd, String arg2, String[] arg3) {
		
		if (pSender instanceof Player) {
			Player lPlayer = (Player) pSender;
			lPlayer.sendMessage(ChatColor.GREEN + "Java" + ChatColor.YELLOW + "AC" + ChatColor.YELLOW + " by Tommy W.");
		}
		
		return true;
	}

}
