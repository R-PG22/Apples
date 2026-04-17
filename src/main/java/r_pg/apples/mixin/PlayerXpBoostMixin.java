package r_pg.apples.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import r_pg.apples.ModEffects;

@Mixin(Player.class)
public class PlayerXpBoostMixin {
    @ModifyVariable(method = "giveExperiencePoints", at = @At("HEAD"), argsOnly = true)
    private int multiplyXp(int experience) {
        if (((LivingEntity) (Object) this).hasEffect(ModEffects.FOCUS)) {
            return experience * 2;
        }
        return experience;
    }


}

