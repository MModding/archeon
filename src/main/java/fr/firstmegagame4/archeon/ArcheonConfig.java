package fr.firstmegagame4.archeon;

import com.mmodding.mmodding_lib.library.config.Config;
import com.mmodding.mmodding_lib.library.config.ConfigObject;
import com.mmodding.mmodding_lib.library.config.ConfigOptions;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
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
	public ConfigOptions getConfigOptions() {
		return new ConfigOptions(Text.of("Archeon Config"), new TextureLocation.Block("archeon", "anhydrite"));
	}
}
