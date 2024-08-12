package oswego.incendium;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.CrossbowItem;
import net.minecraft.util.Identifier;
import oswego.incendium.item.ModItems;

public class InmodiumClient implements ClientModInitializer {
    public static void registerModelPredicateProviders() {

        ModelPredicateProviderRegistry.register(ModItems.MULTIPLEX_CROSSBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return CrossbowItem.isCharged(stack) ? 0.0F : (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float)CrossbowItem.getPullTime(stack);
            }
        });
        ModelPredicateProviderRegistry.register(ModItems.MULTIPLEX_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !CrossbowItem.isCharged(stack) ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(ModItems.MULTIPLEX_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) -> {
            return entity != null && CrossbowItem.isCharged(stack) ? 1.0F : 0.0F;
        });
    }

    @Override
    public void onInitializeClient() {
        // ...
        registerModelPredicateProviders();
    }
}
