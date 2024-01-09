package io.github.cottonmc.cotton.gui.impl;

import net.minecraftforge.fml.common.Mod;

@Mod("libgui")
public final class LibGuiCommon {
	public static final String MOD_ID = "libgui";

	public LibGuiCommon() {
		ScreenNetworkingImpl.init();
	}
}
