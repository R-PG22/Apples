package r_pg.apples;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import r_pg.apples.item_settings.KnifeItem;

public class ModItems {
	public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(Apples.MOD_ID, "item_group"));
	public static final CreativeModeTab CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ModItems.SLICED_APPLE))
			.title(Component.translatable("itemGroup.apples"))
			.build();

	public static void initialize(){
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

		ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
			itemGroup.accept(ModItems.SLICED_APPLE);
			itemGroup.accept(ModItems.KNIFE);
			itemGroup.accept(ModItems.IRON_APPLE);
		});
	}

	public static Item register(Item item, String id) {
		// Create the identifier for the item.
		ResourceLocation itemID = new ResourceLocation(Apples.MOD_ID, id);

		return Registry.register(BuiltInRegistries.ITEM, itemID, item);
	}

	public static final FoodProperties SLICED_APPLE_COMPONENT = new FoodProperties.Builder()
			.nutrition(1)
			.saturationMod(0.6f)
			.fast()
			.build();

	public static final FoodProperties IRON_APPLE_COMPONENT = new FoodProperties.Builder()
			.nutrition(4)
			.saturationMod(2.4f)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 180 * 20, 1), 1.0f)
			.build();

	public static final Item SLICED_APPLE = register(
			// Ignore the food component for now, we'll cover it later in the food section.
			new Item(new FabricItemSettings().food(SLICED_APPLE_COMPONENT)),
			"sliced_apple"
	);

	public static final Item KNIFE = register(
			new KnifeItem(),
			"knife"
	);

	public static final Item IRON_APPLE = register(
			// Ignore the food component for now, we'll cover it later in the food section.
			new Item(new FabricItemSettings().food(IRON_APPLE_COMPONENT)),
			"iron_apple"
	);
}

