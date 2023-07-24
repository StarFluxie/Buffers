package net.fluxie.buffers.block;

import net.fluxie.buffers.BuffersMod;
import net.fluxie.buffers.block.custom.*;
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

    public static final RegistryObject<Block> MANGROVE_TRAIN_BUFFER = registerBlock("mangrove_train_buffer",
            () -> new MangroveTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);
    public static final RegistryObject<Block> SPRUCE_TRAIN_BUFFER = registerBlock("spruce_train_buffer",
            () -> new SpruceTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);
    public static final RegistryObject<Block> OAK_TRAIN_BUFFER = registerBlock("oak_train_buffer",
            () -> new OakTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);
    public static final RegistryObject<Block> BIRCH_TRAIN_BUFFER = registerBlock("birch_train_buffer",
            () -> new BirchTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);
    public static final RegistryObject<Block> JUNGLE_TRAIN_BUFFER = registerBlock("jungle_train_buffer",
            () -> new JungleTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);
    public static final RegistryObject<Block> ACACIA_TRAIN_BUFFER = registerBlock("acacia_train_buffer",
            () -> new AcaciaTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);
    public static final RegistryObject<Block> DARK_OAK_TRAIN_BUFFER = registerBlock("dark_oak_train_buffer",
            () -> new DarkOakTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);
    public static final RegistryObject<Block> CRIMSON_TRAIN_BUFFER = registerBlock("crimson_train_buffer",
            () -> new CrimsonTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);
    public static final RegistryObject<Block> WARPED_TRAIN_BUFFER = registerBlock("warped_train_buffer",
            () -> new WarpedTrainBuffer(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).noOcclusion()), ModCreativeModeTab.BUFFERS_TAB);

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
