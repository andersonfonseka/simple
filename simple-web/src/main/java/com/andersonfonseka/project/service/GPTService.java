package com.andersonfonseka.project.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GPTService {

	public static void main(String[] args) throws IOException {

		URL url = new URL("https://api.openai.com/v1/chat/completions");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");

		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "Bearer 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");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		String jsonRequest = "{\r\n" + "    \"model\": \"gpt-3.5-turbo\",\r\n" + "    \"messages\": [\r\n"
				+ "      {\r\n" + "        \"role\": \"user\",\r\n"
				+ "        \"content\": \"exiba todos os requisitos funcionais obrigatórios e desejáveis para um sistema de seguros de automoveis, incluindo: cotação, perfis, riscos, renovação, cadastros, acessos, sinistros, cancelamento, dentre outras.\"\r\n"
				+ "      }\r\n" + "    ]\r\n" + "  }";

		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonRequest.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
//			StringBuilder response = new StringBuilder();
//			String responseLine = null;
//			while ((responseLine = br.readLine()) != null) {
//				response.append(responseLine.trim());
//			}
//
//			String result = response.toString();
//			System.out.println(result.replace("\\n", "\n"));

			ObjectMapper objectMapper = new ObjectMapper();
			GPTObject example = objectMapper.readValue(br, GPTObject.class);
			System.out.println(example);

		}

	}

}
