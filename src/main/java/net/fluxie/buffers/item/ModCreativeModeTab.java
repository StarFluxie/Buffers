package net.fluxie.buffers.item;

import net.fluxie.buffers.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab BUFFERS_TAB = new CreativeModeTab("Fluxie's Buffers") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.TRAIN_BUFFER.get());
        }
    };
}
