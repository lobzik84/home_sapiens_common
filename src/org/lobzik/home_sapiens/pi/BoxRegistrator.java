/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lobzik.home_sapiens.pi;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

/**
 *
 * @author lobzik
 */
public class BoxRegistrator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            /*
            if (BoxCommonData.BOX_ID > 0) {
                System.err.println("Box registered already, " + BoxCommonData.BOX_ID_FILE + " exists. Exiting.");
                return;
            }

            JSONObject boxJson = new JSONObject();
            boxJson.put("ssid", BoxCommonData.SSID);
            boxJson.put("public_key", new String(Files.readAllBytes(Paths.get(BoxCommonData.PUBLIC_KEY_FILE)), "UTF-8"));
            boxJson.put("version", BoxCommonData.BOX_VERSION);
            boxJson.put("wpa_psk", BoxCommonData.WPA_PSK);

            JSONObject reqJson = new JSONObject();
            reqJson.put("action", "register_request");
            reqJson.put("box_data", boxJson);

            URL url = new URL(BoxCommonData.REGISTER_SERVER_URL);

            URLConnection conn = url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(reqJson.toString());
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String decodedString;
            StringBuffer sb = new StringBuffer();
            while ((decodedString = in.readLine()) != null) {
                sb.append(decodedString);
            }
            in.close();
            JSONObject response = new JSONObject(sb.toString());
            if (response.has("register_result") && response.getString("register_result").equals("success")) {

                int id = response.getInt("box_id");
                File boxIdFile = new File(BoxCommonData.BOX_ID_FILE);
                FileOutputStream fos = new FileOutputStream(boxIdFile);
                OutputStreamWriter idFileOs = new OutputStreamWriter(fos);
                idFileOs.write("box_id=" + id + "\n");
                idFileOs.flush();
                idFileOs.close();
                fos.flush();
                fos.close();
                System.out.println("Box registered successfully");
                System.out.println("Box ID: " + id);
                System.out.println("Box SSID: " + BoxCommonData.SSID);
                System.out.println("Box WPA_PSK: " + BoxCommonData.WPA_PSK); //print on a sticker
                System.out.println("Box RSA public key: " + BoxCommonData.PUBLIC_KEY);
                System.out.println("Box registration done");
            } else {
                System.err.println("Error while registering device ");
                System.err.println(sb.toString());
            }
            //boxIdFile.
             */

            GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font[] fonts = e.getAllFonts(); // Get the fonts
            for (Font f : fonts) {
                System.out.println(f.getFontName());
            }

        } catch (Throwable e) {
            System.err.println("Error while registering device ");
            e.printStackTrace();
        }
    }

}
