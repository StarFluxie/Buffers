package net.fluxie.buffers.block;

import net.fluxie.buffers.BuffersMod;
import net.fluxie.buffers.block.custom.MangroveTrainBuffer;
import net.fluxie.buffers.block.custom.TrainBuffer;
import net.fluxie.buffers.item.ModCreativeModeTab;
import net.fluxie.buffers.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BuffersMod.MOD_ID);
    public static final RegistryObject<Block> TRAIN_BUFFER = registerBlock("train_buffer",
            () -> new TrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);

    public static final RegistryObject<Block> MANGROVE_TRAIN_BUFFER = registerBlock("mangrove_train_buffer.json",
            () -> new MangroveTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
