package br.pb.thiagofb84jp.core;

import io.restassured.http.ContentType;

public interface Constants {
    String APP_BASE_URL = "https://dummyjson.com/";
    Integer APP_PORT = 443; // Para http -> 80
    String APP_BASE_PATH = "";
    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 5000L;
}
