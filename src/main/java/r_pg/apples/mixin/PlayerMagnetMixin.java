package r_pg.apples.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import r_pg.apples.ModEffects;

import java.util.List;

@Mixin(Player.class)
public class PlayerMagnetMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void pullNearbyItems(CallbackInfo ci) {
        Player player = (Player) (Object) this;

        if (!player.level().isClientSide() && player.hasEffect(ModEffects.ATTRACTION)) {

            if (player.tickCount % 5 == 0) {
                AABB box = player.getBoundingBox().inflate(10.0D); // 半径10ブロック
                List<ItemEntity> items = player.level().getEntitiesOfClass(ItemEntity.class, box);

                for (ItemEntity item : items) {
                    Vec3 direction = player.position().subtract(item.position()).normalize();

                    item.setDeltaMovement(direction.scale(0.5D));
                }
            }
        }
    }
}

