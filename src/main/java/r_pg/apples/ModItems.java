package r_pg.apples;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
	public static void initialize(){
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
				.register((itemGroup) -> itemGroup.accept(ModItems.TEST_ITEM));
	};

	public static Item register(Item item, String id) {
		// Create the identifier for the item.
		ResourceLocation itemID = new ResourceLocation(Apples.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}

	public static final Item TEST_ITEM = register(
			// Ignore the food component for now, we'll cover it later in the food section.
			new Item(new FabricItemSettings()),
			"test_item"
	);
}

