package com.etheller.warsmash.viewer5.handlers.mdx;

import com.badlogic.gdx.math.Vector3;
import com.etheller.warsmash.datasources.DataSource;
import com.etheller.warsmash.util.StringBundle;
import com.etheller.warsmash.util.WorldEditStrings;
import com.etheller.warsmash.viewer5.CanvasProvider;
import com.etheller.warsmash.viewer5.SceneLightManager;
import com.etheller.warsmash.viewer5.handlers.AbstractMdxModelViewer;
import com.etheller.warsmash.viewer5.handlers.w3x.W3xScenePortraitLightManager;

public class MdxViewer extends AbstractMdxModelViewer {

	private final WorldEditStrings worldEditStrings;
	private final Vector3 defaultLighting;

	public MdxViewer(final DataSource dataSource, final CanvasProvider canvas, final Vector3 defaultLighting) {
		super(dataSource, canvas);
		this.defaultLighting = defaultLighting;
		this.worldEditStrings = new WorldEditStrings(this.dataSource);
	}

	@Override
	public SceneLightManager createLightManager(final boolean simple) {
		return new W3xScenePortraitLightManager(this, this.defaultLighting);
	}

	@Override
	public StringBundle getWorldEditStrings() {
		return this.worldEditStrings;
	}

}