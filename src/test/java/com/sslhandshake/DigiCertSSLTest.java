package com.sslhandshake;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class DigiCertSSLTest {
    public static void main(String[] args) {
        String httpsUrl = "https://shop.pulmuone.co.kr";
        try {
            URL url = new URL(httpsUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine).append("\n");
            }
            in.close();

            System.out.println("Response Content:");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("SSL/TLS 연결 실패 또는 기타 오류:");
            e.printStackTrace();
        }
    }
}