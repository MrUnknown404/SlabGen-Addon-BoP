package mrunknown404.slabgenbop;

import biomesoplenty.api.block.BOPBlocks;
import mrunknown404.slabgen.block.SlabFallable;
import mrunknown404.slabgen.world.FeatureGroundSlabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(SlabGenBoP.MOD_ID)
public class SlabGenBoP {
	public static final String MOD_ID = "slabgenbop";
	
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SlabGenBoP.MOD_ID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SlabGenBoP.MOD_ID);
	
	public static final RegistryObject<Block> BLACK_SAND_SLAB = block("black_sand_slab", new SlabFallable(SoundType.SAND, 0.5f, 0.5f, 2960431));
	public static final RegistryObject<Block> WHITE_SAND_SLAB = block("white_sand_slab", new SlabFallable(SoundType.SAND, 0.5f, 0.5f, 15987172));
	public static final RegistryObject<Block> ORANGE_SAND_SLAB = block("orange_sand_slab", new SlabFallable(SoundType.SAND, 0.5f, 0.5f, 13408865));
	
	public SlabGenBoP() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addGenericListener(Feature.class, SlabGenBoP::registerFeatures);
		
		BLOCKS.register(bus);
		ITEMS.register(bus);
	}
	
	@SubscribeEvent
	public static void registerFeatures(@SuppressWarnings("unused") RegistryEvent.Register<Feature<?>> e) {
		FeatureGroundSlabs.add(BOPBlocks.black_sand, null, BLACK_SAND_SLAB.get());
		FeatureGroundSlabs.add(BOPBlocks.white_sand, null, WHITE_SAND_SLAB.get());
		FeatureGroundSlabs.add(BOPBlocks.orange_sand, null, ORANGE_SAND_SLAB.get());
	}
	
	private static <T extends Block> RegistryObject<T> block(String name, T o) {
		RegistryObject<T> reg = BLOCKS.register(name, () -> o);
		item(name, new BlockItem(o, new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
		return reg;
	}
	
	private static <T extends Item> RegistryObject<T> item(String name, T o) {
		return ITEMS.register(name, () -> o);
	}
}
