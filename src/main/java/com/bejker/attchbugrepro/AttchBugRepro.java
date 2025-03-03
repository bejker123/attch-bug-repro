package com.bejker.attchbugrepro;

import com.mojang.serialization.Codec;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.Identifier;


public class AttchBugRepro implements ModInitializer {

    public static final AttachmentType<Integer> THIRST = AttachmentRegistry.create(
            Identifier.of("attachment-bug-repro", "thirst"),
            builder -> builder
                    .initializer(() -> 20) // start with a default value like hunger
                    .persistent(Codec.INT) // persist across restarts
                    .copyOnDeath()
                    .syncWith(PacketCodecs.VAR_INT, AttachmentSyncPredicate.targetOnly()) // only the player's own client needs the value for rendering
    );


    @Override
    public void onInitialize() {

    }
}
