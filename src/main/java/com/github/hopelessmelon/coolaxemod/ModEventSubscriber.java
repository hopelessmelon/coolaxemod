/*
 This file includes event listeners (aka event subscribers) that run on the MOD event bus.
 An event listener is a function that waits for a certain event to occur and triggers when that event happens.
 Forge has a series of events when loading the game. Mod event subscribers listen for their relevant events, and take action.
 For example, the onRegisterItems function in this file listens for when Forge begins to register items. When that happens, it jumps in to add the mod's items into the game.
 I don't know exactly what an event bus is yet, but it seems to be a group of events. For example, I think the MOD event bus is when Forge starts to run all its mod-specific events.
 -MG
*/

package com.github.hopelessmelon.coolaxemod;

import com.github.hopelessmelon.coolaxemod.init.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = CoolAxeMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                setup(new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)), "example_item")
        );
    }
    // The following is a specific way of setting up item registration that allows compatibility with Forge and alongside other mods.
    // It was cped exactly to ensure proper setup. -MG
    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(CoolAxeMod.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

}
