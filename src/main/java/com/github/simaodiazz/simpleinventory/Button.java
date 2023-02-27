package com.github.simaodiazz.simpleinventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Button {

    private ItemStack icon;

    private int slot;

    private Consumer<Player> action;

}
