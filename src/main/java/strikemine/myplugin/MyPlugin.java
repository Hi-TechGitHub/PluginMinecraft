package strikemine.myplugin;


import strikemine.myplugin.entity.SpawnCreeper;
import strikemine.myplugin.events.AreaEffect;
import strikemine.myplugin.healths.Heal;
import strikemine.myplugin.commands.KitCommandCompleter;
import strikemine.myplugin.healths.Pain;
import org.bukkit.plugin.java.JavaPlugin;
import strikemine.myplugin.commands.KitCommandExecutor;
import strikemine.myplugin.items.GiveItem;

public final class MyPlugin extends JavaPlugin {


    @Override
    public void onEnable() {

//        pain = new Pain(new Pain());
//        kit = new KitCommandExecutor(this);
//        heal = new Heal(this);
        getCommand("enableeffect").setExecutor(new AreaEffect());
        getCommand("pain").setExecutor(new Pain());
        getCommand("kit").setExecutor(new KitCommandExecutor());
        getCommand("kit").setTabCompleter(new KitCommandCompleter());
        getCommand("heal").setExecutor(new Heal());
        getCommand("giveItem").setExecutor(new GiveItem());
        getCommand("spawnCreeper").setExecutor(new SpawnCreeper());
    }
// ВСЕГДА ДОБАВЛЯТЬ КОМАНДЫ В plugin.yml !!!
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
