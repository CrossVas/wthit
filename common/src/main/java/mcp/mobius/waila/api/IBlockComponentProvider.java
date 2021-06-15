package mcp.mobius.waila.api;

import java.util.List;

import mcp.mobius.waila.api.internal.ApiSide;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.ApiStatus;

/**
 * Callback class interface used to provide Block/TileEntity tooltip informations to Waila.<br>
 * All methods in this interface shouldn't to be called by the implementing mod. An instance of the class is to be
 * registered to Waila via the {@link IRegistrar} instance provided in the original registration callback method
 * (cf. {@link IRegistrar} documentation for more information).
 */
@ApiSide.ClientOnly
@ApiStatus.OverrideOnly
public interface IBlockComponentProvider {

    /**
     * Callback used to override the default Waila lookup system.</br>
     * Will only be called if the implementing class is registered via {@link IRegistrar#addOverride}.</br>
     *
     * @param accessor Contains most of the relevant information about the current environment.
     * @param config   Current configuration of Waila.
     *
     * @return null if override is not required, a BlockState otherwise.
     */
    default BlockState getOverride(IBlockAccessor accessor, IPluginConfig config) {
        return null;
    }

    /**
     * Callback used to override the default Waila lookup system.</br>
     * Will only be called if the implementing class is registered via {@link IRegistrar#addDisplayItem}.</br>
     * <p>
     * This method is only called on the client side. If you require data from the server, you should also implement
     * {@link IServerDataProvider#appendServerData(NbtCompound, ServerPlayerEntity, World, Object)} and add the data to the {@link NbtCompound}
     * there, which can then be read back using {@link IBlockAccessor#getServerData()}. If you rely on the client knowing
     * the data you need, you are not guaranteed to have the proper values.
     *
     * @param accessor Contains most of the relevant information about the current environment.
     * @param config   Current configuration of Waila.
     *
     * @return {@link ItemStack#EMPTY} if override is not required, a non-empty ItemStack otherwise.
     */
    default ItemStack getDisplayItem(IBlockAccessor accessor, IPluginConfig config) {
        return ItemStack.EMPTY;
    }

    /**
     * Callback used to add lines to one of the three sections of the tooltip (Head, Body, Tail).</br>
     * Will only be called if the implementing class is registered via {@link IRegistrar#addComponent(IBlockComponentProvider,
     * TooltipPosition, Class)}.</br>
     * You are supposed to always return the modified input tooltip.</br>
     * <p>
     * This method is only called on the client side. If you require data from the server, you should also implement
     * {@link IServerDataProvider#appendServerData(NbtCompound, ServerPlayerEntity, World, Object)} and add the data to the {@link NbtCompound}
     * there, which can then be read back using {@link IBlockAccessor#getServerData()}. If you rely on the client knowing
     * the data you need, you are not guaranteed to have the proper values.
     *
     * @param tooltip  Current list of tooltip lines (might have been processed by other providers and might be processed
     *                 by other providers).
     * @param accessor Contains most of the relevant information about the current environment.
     * @param config   Current configuration of Waila.
     */
    default void appendHead(List<Text> tooltip, IBlockAccessor accessor, IPluginConfig config) {
    }

    /**
     * Callback used to add lines to one of the three sections of the tooltip (Head, Body, Tail).</br>
     * Will only be called if the implementing class is registered via {@link IRegistrar#addComponent(IBlockComponentProvider,
     * TooltipPosition, Class)}.</br>
     * You are supposed to always return the modified input tooltip.</br>
     * <p>
     * This method is only called on the client side. If you require data from the server, you should also implement
     * {@link IServerDataProvider#appendServerData(NbtCompound, ServerPlayerEntity, World, Object)} and add the data to the {@link NbtCompound}
     * there, which can then be read back using {@link IBlockAccessor#getServerData()}. If you rely on the client knowing
     * the data you need, you are not guaranteed to have the proper values.
     *
     * @param tooltip  Current list of tooltip lines (might have been processed by other providers and might be processed
     *                 by other providers).
     * @param accessor Contains most of the relevant information about the current environment.
     * @param config   Current configuration of Waila.
     */
    default void appendBody(List<Text> tooltip, IBlockAccessor accessor, IPluginConfig config) {
    }

    /**
     * Callback used to add lines to one of the three sections of the tooltip (Head, Body, Tail).</br>
     * Will only be called if the implementing class is registered via {@link IRegistrar#addComponent(IBlockComponentProvider,
     * TooltipPosition, Class)}.</br>
     * You are supposed to always return the modified input tooltip.</br>
     * <p>
     * You may return null if you have not registered this as a tail provider. However, you should return the provided list
     * to be safe.
     * <p>
     * This method is only called on the client side. If you require data from the server, you should also implement
     * {@link IServerDataProvider#appendServerData(NbtCompound, ServerPlayerEntity, World, Object)} and add the data to the {@link NbtCompound}
     * there, which can then be read back using {@link IBlockAccessor#getServerData()}. If you rely on the client knowing
     * the data you need, you are not guaranteed to have the proper values.
     *
     * @param tooltip  Current list of tooltip lines (might have been processed by other providers and might be processed by other providers).
     * @param accessor Contains most of the relevant information about the current environment.
     * @param config   Current configuration of Waila.
     */
    default void appendTail(List<Text> tooltip, IBlockAccessor accessor, IPluginConfig config) {
    }

}
