package net.lil_requiem.item.client;

import net.lil_requiem.RPServerFighting;
import net.lil_requiem.item.custom.Sipetr;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class SipetrModel extends GeoModel<Sipetr> {
    @Override
    public Identifier getModelResource(Sipetr animatable) {
        return new Identifier(RPServerFighting.MODID, "geo/sipetr.geo.json");
    }

    @Override
    public Identifier getTextureResource(Sipetr animatable) {
        return new Identifier(RPServerFighting.MODID, "textures/item/sipetr.png");
    }

    @Override
    public Identifier getAnimationResource(Sipetr animatable) {
        return new Identifier(RPServerFighting.MODID, "animations/sipetr.animation.json");
    }
}
