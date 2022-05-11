package mrunknown404.slabgenbop;

import biomesoplenty.api.block.BOPBlocks;
import mrunknown404.slabgen.world.FeatureGroundSlabs;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SlabGenBoP.MOD_ID)
public class SlabGenBoP {
	public static final String MOD_ID = "slabgenbop";
	
	public SlabGenBoP() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addGenericListener(Feature.class, SlabGenBoP::registerFeatures);
		
		SGBoPBlocks.BLOCKS.register(bus);
		SGBoPItems.ITEMS.register(bus);
	}
	
	@SubscribeEvent
	public static void registerFeatures(@SuppressWarnings("unused") RegistryEvent.Register<Feature<?>> e) {
		FeatureGroundSlabs.add(BOPBlocks.BLACK_SAND, null, SGBoPBlocks.BLACK_SAND_SLAB.get());
		FeatureGroundSlabs.add(BOPBlocks.WHITE_SAND, null, SGBoPBlocks.WHITE_SAND_SLAB.get());
		FeatureGroundSlabs.add(BOPBlocks.ORANGE_SAND, null, SGBoPBlocks.ORANGE_SAND_SLAB.get());
	}
}
