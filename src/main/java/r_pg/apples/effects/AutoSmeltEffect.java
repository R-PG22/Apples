package r_pg.apples.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class AutoSmeltEffect extends MobEffect {
    public AutoSmeltEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x2632aa);
    }

    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }


    // Called when the effect is applied.
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
    }
}