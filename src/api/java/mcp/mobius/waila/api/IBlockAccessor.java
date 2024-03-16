package mcp.mobius.waila.api;

import mcp.mobius.waila.api.__internal__.ApiSide;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * Used to get some basic data out of the game without having to request direct access to the game engine.
 */
@ApiSide.ClientOnly
@ApiStatus.NonExtendable
public interface IBlockAccessor {

    Level getWorld();

    Player getPlayer();

    Block getBlock();

    BlockState getBlockState();

    @Nullable <T extends BlockEntity> T getBlockEntity();
    void blockEntity(BlockEntity blockEntity);

    BlockHitResult getBlockHitResult();
    void blockHitResult(BlockHitResult blockHitResult);

    BlockPos getPosition();

    @Nullable Vec3 getRenderingPosition();

    long getServerDataTime();

    IDataReader getData();

    Direction getSide();

    ItemStack getStack();

    int getUpdateId();

    Vec3 getRayCastOrigin();

    Vec3 getRayCastDirection();

    double getRayCastMaxDistance();

    float getFrameTime();

    // -----------------------------------------------------------------------------------------------------------------------------------------------
    // TODO: Remove

    /**
     * @deprecated use {@link #getData()}, {@link IDataReader#raw()}
     */
    @Deprecated(forRemoval = true)
    @ApiStatus.ScheduledForRemoval(inVersion = "1.21")
    CompoundTag getServerData();

    /**
     * @deprecated use {@link #getBlockHitResult()}
     */
    @Deprecated
    @ApiStatus.ScheduledForRemoval(inVersion = "1.21")
    HitResult getHitResult();

    /**
     * @deprecated use {@link #getFrameTime()}
     */
    @Deprecated
    @ApiStatus.ScheduledForRemoval(inVersion = "1.21")
    double getPartialFrame();

}
