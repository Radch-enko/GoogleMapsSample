package stanislav.radchenko.googlemapssample;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;


// Нужен API ключ чтобы эта штука работала, но он стоит денег
public class RouteHandler {


    private OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    public void callRoute(LatLng origin, LatLng end) throws IOException {

        String url_link = "https://maps.googleapis.com/maps/api/directions/json?origin="
                + origin.latitude + "," + origin.longitude + "&destination=" + end.latitude + "," + end.longitude + "&key=AIzaSyBg6Yw17doqo5eb6dZPWFntMrpPdMmrO80";

        RequestBody formBody = new FormBody.Builder().build();

        Request request = new Request.Builder().url(url_link)
                .post(formBody)
                .build();

        String respose = client.newCall(request).execute().body().string();
        Log.e("RouteHandler", respose);
    }
}
