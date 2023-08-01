package fr.firstmegagame4.archeon;

import com.mmodding.mmodding_lib.library.config.Config;
import com.mmodding.mmodding_lib.library.config.ConfigObject;
import com.mmodding.mmodding_lib.library.config.client.screen.ConfigScreenOptions;
import net.minecraft.text.Text;

public class ArcheonConfig implements Config {

	@Override
	public String getQualifier() {
		return "archeon";
	}

	@Override
	public String getFilePath() {
		return "archeon/common";
	}

	@Override
	public ConfigObject defaultConfig() {
		return new ConfigObject.Builder()
			.addBooleanParameter("defaultDoesSunstradiversAttackSnails", true)
			.addBooleanParameter("defaultIsHeartOfNatureDifficultyScaled", true)
			.build();
	}

	@Override
	public ConfigScreenOptions getConfigOptions() {
		return new ConfigScreenOptions(Text.of("Archeon Config"), Archeon.createId("textures/blocks/anhydrite.png"));
	}
}
