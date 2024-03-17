package strikemine.myplugin.healths;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import strikemine.myplugin.*;
import strikemine.myplugin.commands.Console;
import strikemine.myplugin.particle.SpiralRed;

public class Pain implements CommandExecutor {
    public World world;
    public Player p;





    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // ... implementation exactly as before ...
        if (!(sender instanceof Player p)) {
            Console.log("&4Console cannot use this command!");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage("&cВыберите игрока");
            return true;
        }
        if (args.length == 1) {
            String player = args[0];
            Player target = Bukkit.getPlayer(player);
            SpiralRed.spawn(target);
            target.sendMessage(p.getName() + " стал инвалидом :(");
            ItemStack diamond = new ItemStack(Material.DIAMOND);
            target.getInventory().addItem(diamond);
            target.setMaxHealth(5);
            return true;
    }
     return false;
    }

}