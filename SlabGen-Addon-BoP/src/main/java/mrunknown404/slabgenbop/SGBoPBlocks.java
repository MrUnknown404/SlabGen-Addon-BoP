package mrunknown404.slabgenbop;

import java.util.function.Supplier;

import mrunknown404.slabgen.block.SlabFallable;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SGBoPBlocks {
	static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SlabGenBoP.MOD_ID);
	
	public static final RegistryObject<Block> BLACK_SAND_SLAB = block("black_sand_slab", () -> new SlabFallable(SoundType.SAND, 0.5f, 0.5f, 2960431));
	public static final RegistryObject<Block> WHITE_SAND_SLAB = block("white_sand_slab", () -> new SlabFallable(SoundType.SAND, 0.5f, 0.5f, 15987172));
	public static final RegistryObject<Block> ORANGE_SAND_SLAB = block("orange_sand_slab", () -> new SlabFallable(SoundType.SAND, 0.5f, 0.5f, 13408865));
	
	static <T extends Block> RegistryObject<T> block(String name, Supplier<T> o) {
		RegistryObject<T> reg = BLOCKS.register(name, o);
		SGBoPItems.item(name, () -> new BlockItem(reg.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
		return reg;
	}
}
