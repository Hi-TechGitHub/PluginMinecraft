package strikemine.myplugin.particle;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import java.util.logging.Level;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Spiral {
    public static void spawn(@NotNull Player player) {
        Location location = player.getLocation();

        // Задаем радиут спирали.
        double radius = 0.5;

        for (double y = 0; y <= 23; y += 0.1) {
            double x = radius * Math.cos(y);
            double z = radius * Math.sin(y);

            Location particleLocation = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
            player.spawnParticle(Particle.REDSTONE, particleLocation.add(x, y / 10, z), 2, new Particle.DustOptions(Color.AQUA, 1.0F));

            try {
                // Думаю, что это плохо, но для первого раза сойдет.
                TimeUnit.NANOSECONDS.sleep(1);
            } catch (InterruptedException e) {
                Bukkit.getLogger().log(Level.SEVERE, e.toString());
            }
        }
    }
}