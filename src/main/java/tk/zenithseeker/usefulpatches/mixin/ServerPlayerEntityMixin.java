package tk.zenithseeker.usefulpatches.mixin;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo; 

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
	@Shadow
	private int joinInvulnerabilityTicks;	

	@Inject(method="<init>(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/server/world/ServerWorld;Lcom/mojang/authlib/GameProfile;)V", at=@At(value="TAIL"))
	private void init(MinecraftServer svr, ServerWorld sw, GameProfile gp, CallbackInfo ci) {
		this.joinInvulnerabilityTicks=0;
	}
}
