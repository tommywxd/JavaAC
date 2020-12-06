package cc.tommyw.javaac;

import cc.tommyw.javaac.checks.fly.Fly;
import cc.tommyw.javaac.checks.nofall.NoFall;
import cc.tommyw.javaac.checks.reach.Reach;
import cc.tommyw.javaac.checks.speed.Speed;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("jac").setExecutor(new JACCommand(this));
		Bukkit.getPluginManager().registerEvents(new RListeners(), this);

		Bukkit.getPluginManager().registerEvents(new NoFall(), this);
		Bukkit.getPluginManager().registerEvents(new Speed(), this);
		Bukkit.getPluginManager().registerEvents(new Reach(), this);
		Bukkit.getPluginManager().registerEvents(new Fly(), this);
	}
	
	@Override
	public void onDisable() {
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {		
		
		return false;
	}
	
}
