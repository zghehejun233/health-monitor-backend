package cn.sduonline.healthmonitorbackend.util;


import okhttp3.*;

import java.io.IOException;

/**
 * Created By GuoChao on 2022/7/17 23:14
 */
public class OkhttpUtil {
    public static String doGet(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }


}
