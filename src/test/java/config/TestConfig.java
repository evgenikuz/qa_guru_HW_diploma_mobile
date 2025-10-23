package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.config"
})
public interface TestConfig extends Config {
    @Key("url")
    @DefaultValue("hub.browserstack.com")
    String getUrl();

    @Key("project")
    @DefaultValue("First Java Project")
    String getProject();

    @Key("build")
    @DefaultValue("tests.browserstack-build-1")
    String getBuild();

    @Key("name")
    @DefaultValue("first_test")
    String getName();
}
