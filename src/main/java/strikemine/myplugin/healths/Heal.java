package strikemine.myplugin.healths;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import strikemine.myplugin.*;
import strikemine.myplugin.commands.Console;
import strikemine.myplugin.particle.Spiral;
import strikemine.myplugin.particle.SpiralRed;

public class Heal implements CommandExecutor{


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
            Spiral.spawn(target);
            target.sendMessage(target.getName() + " Излечился :)");
            target.setMaxHealth(20);
            target.setHealth(20);

            //target.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10, 2));
            return true;
        }
        return false;
    }

}
