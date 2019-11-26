package com.etheller.warsmash.viewer5;

import java.util.ArrayList;
import java.util.List;

import com.etheller.warsmash.viewer5.handlers.ModelHandler;
import com.etheller.warsmash.viewer5.handlers.ModelInstanceDescriptor;

public abstract class Model extends Resource<ModelHandler> {
	public Bounds bounds;
	public List<ModelInstance> preloadedInstances;

	public Model(final ModelHandler handler, final ModelViewer viewer, final String extension, final String fetchUrl) {
		super(viewer, handler, extension, fetchUrl);
		this.bounds = new Bounds();
		this.preloadedInstances = new ArrayList<>();
	}

	public ModelInstance addInstance(final int type) {
		final ModelInstanceDescriptor instanceDescriptor = this.handler.instanceDescriptor;
		final ModelInstance instance = instanceDescriptor.create(this);

		if (this.ok) {
			instance.load();
		}
		else {
			this.preloadedInstances.add(instance);
		}

		return instance;
	}
}