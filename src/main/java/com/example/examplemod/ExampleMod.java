package com.example.examplemod;

import com.example.examplemod.proxy.CommonProxy;

import net.minecraft.init.Blocks;
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

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        mLogger = event.getModLog();
        mLogger.info("Pre init {}", event);
        mProxy.PreInit(event);
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
        event.getRegistry().register();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register();
    }

}
