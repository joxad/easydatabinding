package com.joxad.easydatabinding.plugin;

import com.github.stephanenicolas.morpheus.AbstractMorpheusPlugin;

import org.gradle.api.Project;

import javassist.build.IClassTransformer;

/**
 * Java class that we export via META-INF. This is the plugin's entry point.
 */
public class ByteManipulationPlugin extends AbstractMorpheusPlugin {
    @Override
    protected Class getPluginExtension() {
        return null;
    }

    @Override
    protected String getExtension() {
        return null;
    }

    @Override
    public IClassTransformer[] getTransformers(Project project) {
        return new IClassTransformer[]{new ClassTransformer()};
    }
}
