/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lobzik.home_sapiens.pi;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;
import org.lobzik.tools.Tools;

/**
 *
 * @author lobzik
 */
public class CommonData {

    public static final String BOX_PROPERTIES_FILE = "/etc/box.properties";
    public static final Integer BOX_ID;
    public static final String BOX_VERSION;
    public static final String BOX_ID_FILE;
    public static final String PUBLIC_KEY_FILE;
    public static final String PRIVATE_KEY_FILE;
    public static final String HOSTAPD_CONFIG_FILE;
    public static final String TUNNEL_SERVER_URL;
    public static final String REGISTER_SERVER_URL;
    public static final String SSID;
    public static final String WPA_PSK;
    public static final String PUBLIC_KEY;

    private CommonData() {
    }

    static { //Init from files
        HashMap<String, String> settingsMap = new HashMap();
        try {

            Properties props = new Properties();
            props.load(new FileInputStream(CommonData.BOX_PROPERTIES_FILE));
            settingsMap.put("PRIVATE_KEY_FILE", props.getProperty("private_key_file"));
            settingsMap.put("TUNNEL_SERVER_URL", props.getProperty("tunnel_server_url"));
            settingsMap.put("REGISTER_SERVER_URL", props.getProperty("register_server_url"));
            settingsMap.put("BOX_VERSION", props.getProperty("box_version"));
            
            String publicKeyFileName = props.getProperty("public_key_file");
            settingsMap.put("PUBLIC_KEY_FILE", publicKeyFileName);
            settingsMap.put("PUBLIC_KEY", new String(Files.readAllBytes(Paths.get(publicKeyFileName)), "UTF-8"));

            String hostapdConfFileName = props.getProperty("hostapd_conf_file");
            settingsMap.put("HOSTAPD_CONFIG_FILE", hostapdConfFileName);
            props.load(new FileInputStream(hostapdConfFileName));
            settingsMap.put("SSID", props.getProperty("ssid"));
            settingsMap.put("WPA_PSK", props.getProperty("wpa_passphrase"));

            String boxIdFileName = props.getProperty("id_file");
            settingsMap.put("BOX_ID_FILE", boxIdFileName);
            File boxIdFile = new File(boxIdFileName);

            if (boxIdFile.exists()) {
                props = new Properties();
                props.load(new FileInputStream(CommonData.BOX_ID_FILE));
                settingsMap.put("BOX_ID", props.getProperty("box_id"));
            }

        } catch (Throwable t) {
            System.err.println("Fatal error while initializing!");
            t.printStackTrace();
            System.exit(-1);

        }

        BOX_ID = Tools.parseInt(settingsMap.get("BOX_ID"), 0);
        BOX_ID_FILE = settingsMap.get("BOX_ID_FILE");
        BOX_VERSION = settingsMap.get("BOX_VERSION");
        PUBLIC_KEY_FILE = settingsMap.get("PUBLIC_KEY_FILE");
        PRIVATE_KEY_FILE = settingsMap.get("PRIVATE_KEY_FILE");
        HOSTAPD_CONFIG_FILE = settingsMap.get("HOSTAPD_CONFIG_FILE");
        TUNNEL_SERVER_URL = settingsMap.get("TUNNEL_SERVER_URL");
        REGISTER_SERVER_URL = settingsMap.get("REGISTER_SERVER_URL");
        SSID = settingsMap.get("SSID");
        WPA_PSK = settingsMap.get("WPA_PSK");
        PUBLIC_KEY = settingsMap.get("PUBLIC_KEY");

    }
}
