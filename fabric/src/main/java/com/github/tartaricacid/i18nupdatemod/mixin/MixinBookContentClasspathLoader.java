/*
Credit: https://github.com/kappa-maintainer/PRP
*/
package com.github.tartaricacid.i18nupdatemod.mixin;

import java.io.IOException;
import java.io.InputStream;

import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import vazkii.patchouli.client.book.BookContentClasspathLoader;
import vazkii.patchouli.common.book.Book;

@Mixin(BookContentClasspathLoader.class)
public class MixinBookContentClasspathLoader {
    @Inject(at = @At("HEAD"), method = "loadJson", cancellable = true, remap = false)
    private void loadJson(Book book, Identifier resloc, Identifier fallback, CallbackInfoReturnable<InputStream> callback) {
        I18nUpdateMod.LOGGER.debug("[Patchouli] loading json from {}.",resloc);
        try {
            callback.setReturnValue(MinecraftClient.getInstance().getResourceManager().getResource(resloc).getInputStream());
        } catch (IOException e) {
            //no-op
        }
    }
}
