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

    // Item que vai ser apresentado
    private ItemStack icon;

    // Slot onde o item vai ser apresentado
    private int slot;

    // Ação do jogador
    private Consumer<Player> action;

}