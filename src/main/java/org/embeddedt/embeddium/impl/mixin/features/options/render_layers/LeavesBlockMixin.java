package org.embeddedt.embeddium.impl.mixin.features.options.render_layers;

import org.embeddedt.embeddium.impl.Embeddium;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LeavesBlock.class)
public class LeavesBlockMixin extends Block {
    public LeavesBlockMixin() {
        super(Properties.ofFullCopy(Blocks.AIR));
        throw new AssertionError("Mixin constructor called!");
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState stateFrom, Direction direction) {
        if (Embeddium.options().quality.leavesQuality.isFancy(Minecraft.getInstance().options.graphicsMode().get())) {
            return super.skipRendering(state, stateFrom, direction);
        } else {
            return stateFrom.getBlock() instanceof LeavesBlock || super.skipRendering(state, stateFrom, direction);
        }
    }
}
