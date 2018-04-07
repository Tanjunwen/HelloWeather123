package com.example.administrator.helloweather123;

/**
 * Created by Administrator on 2018/4/7.
 */

class HttpUtil {
    static void getProvinceData(String url, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    static List<Province> parseJsonWithJSONObject(String data) {
        List<Province> provinceList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            Log.e(TAG, "parseJsonWithJSONObject: arraylength =  " + jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                int id = object.getInt("id");
                String name = object.getString("name");
                Province province = new Province(id, name);
                provinceList.add(province);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        Log.e(TAG, "parseJsonWithJSONObject: listsize = " + provinceList.size());
        return provinceList;
    }

    private static final String TAG = "HttpUtil";
}

}
