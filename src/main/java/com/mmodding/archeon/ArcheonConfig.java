package com.mmodding.archeon;

import com.mmodding.library.config.api.Config;
import com.mmodding.library.config.api.ConfigLevel;
import com.mmodding.library.config.api.ConfigNetworkManagement;
import com.mmodding.library.config.api.schema.ConfigSchema;

public class ArcheonConfig {

	private static final ConfigSchema SCHEMA = ConfigSchema.create()
		.bool("sunstradiver_snail_aggressive")
		.bool("heart_of_nature_difficulty_scaled");

	public static final Config INSTANCE = Config.builder("config.archeon", "archeon/common")
		.withSchema(SCHEMA)
		.withLevel(ConfigLevel.WORLD_LOAD)
		.withNetworkManagement(ConfigNetworkManagement.UPSTREAM_SERVER)
		.withDefaultContent(
			mutable -> mutable
				.bool("sunstradiver_snail_agressive", true)
				.bool("heart_of_nature_difficulty_scaled", false)
		)
		.build(Archeon.createId("common_config"));
}
