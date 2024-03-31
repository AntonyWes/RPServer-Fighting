package net.lil_requiem.item.client;

import net.lil_requiem.item.custom.Sipetr;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SipetrRenderer extends GeoItemRenderer<Sipetr> {

    public SipetrRenderer() {
        super(new SipetrModel());
    }
}
