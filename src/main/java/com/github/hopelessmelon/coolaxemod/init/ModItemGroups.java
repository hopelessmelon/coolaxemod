/*
 This file deals with some item loading stuff on initialization.
 There are a lot of concepts I'm not familiar with here. They're explained (or at least referenced) in Cadiboo's tutorial step 1.7.
 We also create the Mod Item Group, which we call anytime we create a new item. (See ModEventSubscriber class)
 -MG
*/

package com.github.hopelessmelon.coolaxemod.init;

import com.github.hopelessmelon.coolaxemod.CoolAxeMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.function.Supplier;

public class ModItemGroups {
    public static class ModItemGroup extends ItemGroup {

        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }

    }

    public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(CoolAxeMod.MODID, () -> new ItemStack(ModItems.EXAMPLE_ITEM));





}
