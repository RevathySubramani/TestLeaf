package ownerconfiguration;

import org.aeonbits.owner.ConfigCache;

public class Configuration {
	
	public static ConfigurationManager configuration() {
		ConfigurationManager instance = ConfigCache.getOrCreate(ConfigurationManager.class);
		return instance;
	}

}
