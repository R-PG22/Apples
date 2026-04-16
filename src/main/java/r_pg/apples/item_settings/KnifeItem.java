package r_pg.apples.item_settings;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.*;

public class KnifeItem extends Item {
    public KnifeItem() {
        super(new FabricItemSettings().durability(150));
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack result = stack.copy();
        if (result.isDamageableItem()) {
            result.setDamageValue(stack.getDamageValue() + 1);
            if (result.getDamageValue() >= result.getMaxDamage()) {
                return ItemStack.EMPTY;
            }
        }
        return result;
    }
}