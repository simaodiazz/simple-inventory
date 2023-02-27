package com.github.simaodiazz.simpleinventory;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class View implements InventoryHolder {

    @Getter
    private Inventory inventory;

    @Getter
    private final List<Button> buttons = new ArrayList<>();

    // Criar o inventário
    public void create(String name, int size) {
        inventory = Bukkit.createInventory(null, size, name);
    }

   // Adicionar um botão ao inventário
    public void setButton(Button button) {
        inventory.setItem(button.getSlot(), button.getIcon());
        buttons.add(button);
    }

    // Registra o inventário
    public void register(JavaPlugin javaPlugin) {
        Bukkit.getPluginManager().registerEvents(new Listener() {

            public void onClick(InventoryClickEvent event) {

                if (!(event.getInventory().getHolder() instanceof View)) {
                    return;
                }

                event.setCancelled(true);

                Player player = (Player) event.getWhoClicked();
                ItemStack item = event.getCurrentItem();

                if (item == null || item.getType() == Material.AIR) {
                    return;
                }
                for (Button button : buttons) {
                    if (button.getSlot() == event.getSlot()) {
                        button.getAction().accept(player);
                        break;
                    }
                }
            }
        }, javaPlugin);
    }
}