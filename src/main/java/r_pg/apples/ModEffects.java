package r_pg.apples;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import r_pg.apples.effects.AttractionEffect;
import r_pg.apples.effects.AutoSmeltEffect;
import r_pg.apples.effects.FocusEffect;

public class ModEffects {
    public static final MobEffect FOCUS = Registry.register(
            BuiltInRegistries.MOB_EFFECT,
            new ResourceLocation(Apples.MOD_ID, "focus"),
            new FocusEffect()
    );

    public static final MobEffect ATTRACTION = Registry.register(
            BuiltInRegistries.MOB_EFFECT,
            new ResourceLocation(Apples.MOD_ID, "attraction"),
            new AttractionEffect()
    );

    public static final MobEffect AUTOSMELT = Registry.register(
            BuiltInRegistries.MOB_EFFECT,
            new ResourceLocation(Apples.MOD_ID, "auto_smelt"),
            new AutoSmeltEffect()
    );

    public static void initialize() {
    }
}

