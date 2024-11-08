package com.luv2code.spring_boot_library.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ExtractJWT {

    public static String payloadJWTExtraction(String token, String extraction) {
        // look up the JWT.io website for more information of the JWT token

        try {
            // Remove "Bearer " prefix if present
            token = token.replace("Bearer ", "");

            // Split the token into its parts
            String[] chunks = token.split("\\.");

            // Decode the payload part (second part)
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String payload = new String(decoder.decode(chunks[1]));

            // Parse the payload JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode payloadNode = objectMapper.readTree(payload);

            // Extract the "sub" field
            return payloadNode.get(extraction).asText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

//        token.replace("Bearer ", "");
//
//        String[] chunks = token.split("\\.");
//
//        Base64.Decoder decoder = Base64.getUrlDecoder();
//
//        String payload = new String(decoder.decode(chunks[1]));

//        String[] entries = payload.split(",");
//        Map<String, String> map = new HashMap<String, String>();
//        for (String entry : entries) {
//            String[] keyValue = entry.split(":");
//            if (keyValue[0].equals("\"sub\"")) {
//
//                int remove = 1;
//                if (keyValue[1].endsWith("}")) {
//                    remove = 2;
//                }
//                keyValue[1] = keyValue[1].substring(0, keyValue[1].length() - remove);
//                keyValue[1] = keyValue[1].substring(1);
//
//                map.put(keyValue[0], keyValue[1]);
//            }
//        }
//        if (map.containsKey("\"sub\"")) {
//            return map.get("\"sub\"");
//        } else {
//            return null;
//        }

    }
}
