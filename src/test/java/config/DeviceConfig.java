package config;

import org.aeonbits.owner.Config;

public interface DeviceConfig extends Config {
    @Key("device")
    @DefaultValue("Google Pixel 5")
    String getDevice();

    @Key("app")
    @DefaultValue("bs://d89fc69d684960978f443721d5d835f433310bc6")
    String getApp();

    @Key("version")
    @DefaultValue("11.0")
    String getVersion();
}
