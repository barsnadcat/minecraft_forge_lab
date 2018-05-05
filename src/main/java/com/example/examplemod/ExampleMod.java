package com.example.examplemod;

import com.example.examplemod.proxy.CommonProxy;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.item.Item;
import net.minecraft.block.Block;



@Mod(modid = Ref.MODID, name = Ref.NAME, version = Ref.VERSION)
public class ExampleMod
{
    @SidedProxy(clientSide = Ref.CLIENT_PROXY, serverSide = Ref.COMMON_RPOXY)
    public static CommonProxy mProxy;

    private static Logger mLogger;

    private Block mBlock1;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        mLogger = event.getModLog();
        mLogger.info("Pre init {}", event);
        mProxy.PreInit(event);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        mLogger.info("Init {}", event);
        mLogger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        mProxy.Init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        mLogger.info("Post init {}", event);
        mProxy.PostInit(event);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
        mBlock1 = new Block(Material.ROCK);
        mBlock1.setUnlocalizedName("fubar");
        mBlock1.setCreativeTab(CreativeTabs.REDSTONE);
        mBlock1.setRegistryName("fubar");
        mLogger.info("registerBlocks {}", mBlock1);
        event.getRegistry().register(mBlock1);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        ItemBlock item = new ItemBlock(mBlock1);
        item.setRegistryName(mBlock1.getRegistryName());
        mLogger.info("registerItems {}", item);
        event.getRegistry().register(item);
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(mBlock1.getRegistryName(), "inventory"));
    }

}
