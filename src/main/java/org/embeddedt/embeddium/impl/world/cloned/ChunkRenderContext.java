package org.embeddedt.embeddium.impl.world.cloned;

import net.minecraft.core.SectionPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.embeddedt.embeddium.api.MeshAppender;

import java.util.Collections;
import java.util.List;

public class ChunkRenderContext {
    private final SectionPos origin;
    private final ClonedChunkSection[] sections;
    private final BoundingBox volume;
    private List<MeshAppender> meshAppenders = Collections.emptyList();

    public ChunkRenderContext(SectionPos origin, ClonedChunkSection[] sections, BoundingBox volume) {
        this.origin = origin;
        this.sections = sections;
        this.volume = volume;
    }

    public ChunkRenderContext withMeshAppenders(List<MeshAppender> meshAppenders) {
        this.meshAppenders = meshAppenders;
        return this;
    }

    public ClonedChunkSection[] getSections() {
        return this.sections;
    }

    public SectionPos getOrigin() {
        return this.origin;
    }

    public BoundingBox getVolume() {
        return this.volume;
    }

    public List<MeshAppender> getMeshAppenders() {
        return this.meshAppenders;
    }
}
