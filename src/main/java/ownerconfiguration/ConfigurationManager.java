package ownerconfiguration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)

@Config.Sources({
	"system:properties",
	"classpath:config.properties"
})

public interface ConfigurationManager extends Config{
	
	@Key("url") 
	String getURL();
	
	@Key("username") 
	String getUserName();
	
	@Key("password") 
	String getPassword();
	
	@Key("timeout") 
	int getTimeOuts();

}
