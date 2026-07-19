package xyz.iwolfking.vhapi.api.loaders.companion;

import iskallia.vault.config.CompanionRelicsConfig;
import iskallia.vault.init.ModConfigs;
import xyz.iwolfking.vhapi.api.events.VaultConfigEvent;
import xyz.iwolfking.vhapi.api.loaders.lib.core.VaultConfigProcessor;

public class CompanionRelicsConfigLoader extends VaultConfigProcessor<CompanionRelicsConfig> {
    public CompanionRelicsConfigLoader() {
        super(new CompanionRelicsConfig(), "companion_relics");
    }

    @Override
    public void afterConfigsLoad(VaultConfigEvent.End event) {
        this.CUSTOM_CONFIGS.forEach((resourceLocation, companionRelicsConfig) -> {
            ModConfigs.COMPANION_RELICS.pools.putAll(companionRelicsConfig.pools);
        });
        super.afterConfigsLoad(event);
    }
}
