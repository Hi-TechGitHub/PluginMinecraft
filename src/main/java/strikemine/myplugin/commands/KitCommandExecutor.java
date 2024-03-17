package strikemine.myplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import strikemine.myplugin.*;

import java.util.LinkedList;
import java.util.List;

public class KitCommandExecutor implements CommandExecutor {

    private final static List<ItemStack> STARTER_KIT = new LinkedList<>();

    static {
        // Броня
        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET); STARTER_KIT.add(helmet);
        ItemStack chestPlate = new ItemStack(Material.CHAINMAIL_CHESTPLATE); STARTER_KIT.add(chestPlate);
        ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS); STARTER_KIT.add(leggings);
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS); STARTER_KIT.add(boots);
        // Инструменты
        ItemStack sword = new ItemStack(Material.IRON_SWORD); STARTER_KIT.add(sword);
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE); STARTER_KIT.add(pickaxe);
        ItemStack axe = new ItemStack(Material.IRON_AXE); STARTER_KIT.add(axe);
        ItemStack shovel = new ItemStack(Material.IRON_SHOVEL); STARTER_KIT.add(shovel);
        // Еда
        ItemStack apple = new ItemStack(Material.APPLE, 32); STARTER_KIT.add(apple);
        ItemStack pork = new ItemStack(Material.PORKCHOP, 32); STARTER_KIT.add(pork);
        // Предметы
        ItemStack oakWood = new ItemStack(Material.OAK_WOOD, 48); STARTER_KIT.add(oakWood);
        ItemStack glass = new ItemStack(Material.GLASS, 48); STARTER_KIT.add(glass);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player p)) {
            Console.log("&4Console cannot use this command!");
            return true;
        }

        if (args.length > 0) {
            // Смотрим какой набор хочет получить человек
            if (args[0].equalsIgnoreCase("starter") || args[0].equalsIgnoreCase("start") ) {
                List<ItemStack> copied = new LinkedList<>(STARTER_KIT);

                for (ItemStack item : copied) {
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(
                            ChatColor.translateAlternateColorCodes('&',
                                    "&dПринадлежит игроку &c" + p.getName())
                    );
                    item.setItemMeta(meta);
                }

                p.getInventory().addItem(copied.toArray(ItemStack[]::new));
            } else {
                // В ином случае выводим ошибку
                p.sendMessage(ChatColor.
                        translateAlternateColorCodes('&',"&cТакого набора не существует!") );
            }
        }
        return true;
    }
}