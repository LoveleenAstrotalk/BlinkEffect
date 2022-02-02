package com.astrotalk.blinklibrary;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Banner {

    Response response;
    Context context;

    public Banner(Response response, Context context) {
        this.response = response;
        this.context = context;
    }

    RequestQueue queue;

    private void getBanner() {

        String url = "";
        try {
            url = "https://api.prod.astrotalk.in/AstroTalk/banner/get/v3" +
                    "?appId=" + "1" +
                    "&userId=" + "-1" +
                    "&pageNo=" + 0 +
                    "&pageSize=" + 10 +
                    "&isNew=" + true +
                    "&bussinessId=" + "1";
        } catch (Exception e) {
            Log.e("Response", e.getMessage());
        }
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url.trim(), r -> {

            try {
                JSONObject jsonObject = new JSONObject(r);
                response.onResponse(jsonObject);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, error -> Log.e("Response", error.getMessage()));
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(6000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);

    }

    public interface Response {
        void onResponse(JSONObject jsonObject);
    }
}
