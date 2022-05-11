package mrunknown404.slabgenbop;

import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SGBoPItems {
	static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SlabGenBoP.MOD_ID);
	
	static <T extends Item> RegistryObject<T> item(String name, Supplier<T> o) {
		return ITEMS.register(name, o);
	}
}
