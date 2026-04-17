package r_pg.apples.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class AttractionEffect extends MobEffect {
    public AttractionEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xe37951);
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