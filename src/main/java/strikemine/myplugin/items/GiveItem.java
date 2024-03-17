package strikemine.myplugin.items;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GiveItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) sender;

        ItemStack itemStack = new ItemStack(Material.APPLE, 15);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Красное яблоко");
        List<String> str = new ArrayList<>();
        str.add("Вы чувствуете особую силу, которое даёт это яблоко");
        itemMeta.setLore(str);
        itemStack.setItemMeta(itemMeta);


        player.getInventory().addItem(itemStack);

        return true;

    }
}
