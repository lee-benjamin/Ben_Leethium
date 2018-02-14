package com.benjamin.benleethium;

import com.benjamin.benleethium.resources.BenLeethiumResource;

import dagger.Component;

@Component(modules = {TwitterModule.class})
public interface BenLeethiumAppComponent {
    BenLeethiumResource getBenLeethiumResource();
}
