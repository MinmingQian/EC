package adeuni.group.ec.algorithm.configuration.yml;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by qianminming on 19/08/15.
 */
public class YamlConfigurationTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testTestLoadFromStream() throws Exception {
        Yaml yaml = new Yaml();
        InputStream input = new FileInputStream(new File("/Users/qianminming/IntelliJProjects/EC/resource/configuration.yml"));
        YamlConfiguration configuration = (YamlConfiguration) yaml.load(input);
    }
}