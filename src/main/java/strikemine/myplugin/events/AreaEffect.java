package strikemine.myplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class AreaEffect implements CommandExecutor {

    //private Location pos1;
  //  private World world = pos1.getWorld();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) sender;


        World world1 = player.getWorld();
        Location pos1 = new Location(world1, -158, 172, -264);
        Location pos2 = new Location(world1, -203, 145, -305);

        int minX = Math.min(pos1.getBlockX(), pos2.getBlockX());
        int minY = Math.min(pos1.getBlockY(), pos2.getBlockY());
        int minZ = Math.min(pos1.getBlockZ(), pos2.getBlockZ());
        int maxX = Math.max(pos1.getBlockX(), pos2.getBlockX());
        int maxY = Math.max(pos1.getBlockY(), pos2.getBlockY());
        int maxZ = Math.max(pos1.getBlockZ(), pos2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                for (int z = minZ; z < maxZ; z++) {
                    Location location = new Location(world1, x, y, z);
                    applyEffect(location);

                }

            }
        }
        return true;
    }

    private void applyEffect(Location location1) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getLocation().distance(location1) <= 5) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 3600, 1));
            }
        }
    }

}