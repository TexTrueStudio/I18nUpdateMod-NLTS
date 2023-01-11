package com.github.tartaricacid.i18nupdatemod;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = I18nUpdateMod.MOD_ID)
public class I18nModConfig implements ConfigData {
    @ConfigEntry.Gui.PrefixText
    public static String downloadLink = "https://ghproxy.com/https://raw.githubusercontent.com/zkitefly/TranslationPackMirror/main/files";
    public static String resourcePackName = "Minecraft-Mod-Language-Modpack-1-16-Fabric";
    public static String md5Name = "1.16-fabric";
}
