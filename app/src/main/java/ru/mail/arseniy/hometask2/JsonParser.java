package ru.mail.arseniy.hometask2;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class JsonParser {
    public static List<Tech> parse(String data) throws JSONException {
        if (data == null) {
            return new ArrayList<>(0);
        }

        JSONObject techJson = new JSONObject(data).getJSONObject("technology");
        List<Tech> result = new ArrayList<>();
        Iterator<String> idIterator = techJson.keys();
        while (idIterator.hasNext()) {
            JSONObject techObj = techJson.getJSONObject(idIterator.next());
            Tech techItem = new Tech();
            techItem.id = techObj.getInt("id");
            techItem.picture = techObj.getString("picture");
            techItem.title = techObj.getString("title");
            techItem.info = techObj.optString("info");
            result.add(techItem);
        }

        return result;
    }
}
