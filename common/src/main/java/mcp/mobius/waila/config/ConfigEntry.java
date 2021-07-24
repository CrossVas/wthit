package mcp.mobius.waila.config;

import net.minecraft.resources.ResourceLocation;

public class ConfigEntry {

    private final ResourceLocation id;
    private final boolean defaultValue;
    private final boolean synced;
    private boolean value;

    public ConfigEntry(ResourceLocation id, boolean defaultValue, boolean synced) {
        this.id = id;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.synced = synced;
    }

    public ResourceLocation getId() {
        return id;
    }

    public boolean getDefaultValue() {
        return defaultValue;
    }

    public boolean isSynced() {
        return synced;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}
