package r_pg.apples.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import r_pg.apples.ModEffects;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(Block.class)
public class BlockAutoSmeltMixin {
    @Inject(method = "getDrops(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void smeltDroppedItems(BlockState blockState, ServerLevel level, BlockPos blockPos, @Nullable BlockEntity blockEntity, @Nullable Entity entity, ItemStack itemStack, CallbackInfoReturnable<List<ItemStack>> cir) {

        if (entity instanceof Player player) {
            if (player.hasEffect(ModEffects.AUTOSMELT)) {

                List<ItemStack> originalDrops = cir.getReturnValue();
                List<ItemStack> newDrops = new ArrayList<>();

                for (ItemStack drop : originalDrops) {
                    // 仮想のかまどスロットを作成
                    SimpleContainer container = new SimpleContainer(drop);
                    // かまどのレシピが存在するか検索
                    Optional<SmeltingRecipe> recipe = level.getRecipeManager()
                            .getRecipeFor(RecipeType.SMELTING, container, level);

                    if (recipe.isPresent()) {
                        ItemStack smeltedResult = recipe.get().getResultItem(level.registryAccess()).copy();
                        smeltedResult.setCount(drop.getCount());
                        newDrops.add(smeltedResult);
                    } else {
                        newDrops.add(drop);
                    }
                }

                cir.setReturnValue(newDrops);
            }


        }
    }
}