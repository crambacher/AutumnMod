package net.firebrandomega.autumn.block.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class KnotBlockEntity extends BlockEntity {
    private List owls = Lists.newArrayList();
    public KnotBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.BEEHIVE, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
    }

    public boolean isFull(){
        return owls.size() >= 2;
    }
    public boolean isEmpty(){
        return owls.isEmpty();
    }
}
