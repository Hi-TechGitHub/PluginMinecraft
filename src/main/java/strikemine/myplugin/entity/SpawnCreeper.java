package strikemine.myplugin.entity;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.swing.text.PlainDocument;

public class SpawnCreeper implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            String player = strings[0];
            Player target = Bukkit.getPlayer(player);
            Creeper creeper = (Creeper) target.getWorld().spawnEntity(target.getLocation(), EntityType.CREEPER);
            creeper.setPowered(true);
            creeper.ignite();
            return true;
        }
        if (strings.length != 1) {
            sender.sendMessage("Выберите игрока");
            return true;
        }
        return false;
    }
}
