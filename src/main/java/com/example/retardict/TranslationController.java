package com.example.retardict;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TranslationController {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest getRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.dictionaryapi.dev/api/v2/entries/en_US/hello"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(getResponse.body());

    }

}

//import java.net.URLEncoder;
//import java.io.UnsupportedEncodingException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpHeaders;
//import java.nio.charset.StandardCharsets;
//
//public class TranslationController {
//    public static void main(String[] args) {
//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        // Địa chỉ URL của API dịch
//        String textToTranslate = "Hello World!";
//        String apiUrl = URLEncoder.encode(textToTranslate, StandardCharsets.UTF_8);
//
//        String a = "api.mymemory.translated.net/get?q=Hello%20World!&langpair=en|it";
//
//        HttpRequest request = HttpRequest.newBuilder()
////                .uri(URI.create("https://api.mymemory.translated.net/get?q=" + apiUrl + "&langpair=en|vi"))
//                .uri(URI.create("https://" + URLEncoder.encode(a, StandardCharsets.UTF_8)))
//                .GET()
//                .build();
//        try {
//            // Thực hiện yêu cầu và nhận phản hồi
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//            // In ra kết quả
//            System.out.println(response.body());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
