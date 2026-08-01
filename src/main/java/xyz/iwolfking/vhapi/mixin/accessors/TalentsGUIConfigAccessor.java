package xyz.iwolfking.vhapi.mixin.accessors;


import iskallia.vault.config.TalentsGUIConfig;
import iskallia.vault.config.entry.SkillStyle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.HashMap;

@Mixin(value = TalentsGUIConfig.class, remap = false)
public interface TalentsGUIConfigAccessor {
    @Accessor("styles")
    void setStyles(HashMap<String, SkillStyle> styles);
}
