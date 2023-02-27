# simple-inventory
Simples criador de inventários com as ações do botão super fáceis de criar.
<br><br>
```java
package com.github.simaodiazz.simpleinventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Example extends JavaPlugin {

    @Override
    public void onEnable() {
        
        View view = new View();
        view.create("Hello world!", 27);
        view.setButton(new Button(new ItemStack(Material.AIR), 10, player -> {
            player.sendMessage("Você é lindo....");
        }));
        view.register(this);
        
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.openInventory(view.getInventory());
        });
    }
}
```
