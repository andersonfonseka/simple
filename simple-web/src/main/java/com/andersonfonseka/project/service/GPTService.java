package com.andersonfonseka.project.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GPTService {

	public String generate(String value) throws Exception {

		URL url = new URL("https://api.openai.com/v1/chat/completions");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");

		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "Bearer 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");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		String jsonRequest = "{\r\n" + "    \"model\": \"gpt-3.5-turbo\",\r\n" + "    \"messages\": [\r\n"
				+ "      {\r\n" + "        \"role\": \"user\",\r\n" + "        \"content\":\"" + value + "\"\r\n"
				+ "      }\r\n" + "    ]\r\n" + "  }";

		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonRequest.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		GPTObject example = null;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			ObjectMapper objectMapper = new ObjectMapper();
			example = objectMapper.readValue(br, GPTObject.class);
			System.out.println(example);
		}

		return example.toString();
	}
}
