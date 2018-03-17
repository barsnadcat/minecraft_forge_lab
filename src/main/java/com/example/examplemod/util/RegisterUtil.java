package com.example.examplemod.util;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class RegisterUtil
{
    public static void RegisterAll(FMLPreInitializationEvent event)
    {

    }

    private static void RegisterBlocks(FMLPreInitializationEvent event, Block...blocks)
    {
        for (Block block: blocks)
        {
            final ItemBlock itemBlock = new ItemBlock(block);
            if (event.getSide() == Side.CLIENT)
            {
                /**
                 * This is now private, you should use either ForgeRegistries constants.
                 * Or the registry passed in during the RegistryEvent.Register<T> event.
                 */
                GameRegistry.register(block);
                GameRegistry.register(itemBlock, block.getRegistryName());
                ModelLoader.setCustomModelResourceLocation(
                        Item.getItemFromBlock(block),
                        0,
                        new ModelResourceLocation(block.getRegistryName(), "inventory"));
            }

        }

    }

    private static void RegisterItems(FMLPreInitializationEvent event, Item...items)
    {
        for (Item item: items)
        {
            if (event.getSide() == Side.CLIENT)
            {
                GameRegistry.register(item);
                ModelLoader.setCustomModelResourceLocation(
                        item,
                        0,
                        new ModelResourceLocation(item.getRegistryName(), "inventory"));
            }

        }

    }
}
