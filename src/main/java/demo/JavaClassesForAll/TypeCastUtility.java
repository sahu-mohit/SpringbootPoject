package demo.JavaClassesForAll;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.Entity.CommonTable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class TypeCastUtility {

    public static String stringValue(Object value) {
        if (value == null) {
            return "";
        } else {
            return (String) value;
        }
    }

    public static Integer integerValue(Object value) {
        if (value == null) {
            return 0;
        } else {
            return Integer.parseInt(value.toString());
        }
    }

    public static Long longValue(Object value) {
        if (value == null) {
            return 0l;
        } else {
            return (Long) value;
        }
    }


//    private static Boolean booleanValue(Object value) {
//        if (value == null) {
//            return false;
//        } else {
//            return (Boolean) value;
//        }
//    }

    public static void setColumnArray(String obj, HashMap<String, Object> resultMap) throws JSONException {
        try {
            JSONObject json = new JSONObject(obj);
            String columnArray = json.optString("columnArray");
            String title = json.optString("tilte");
            Boolean isCheckBox = TypeCastUtility.getBooleanValue(json.optString("isCheckbox"));
            Boolean actionButton = TypeCastUtility.getBooleanValue(json.optString("actionButton"));
            ObjectMapper mapper = new ObjectMapper();
            List<LinkedHashMap<String, Object>> ArraList = mapper.readValue(columnArray, List.class);
            List<Map<String, Object>> columnList = new LinkedList<>();
            if (isCheckBox) {
                initializeColumn("CheckBox", "checkbox", "chechbox", "", "", isCheckBox, false, columnList);
            }
            initializeColumn("Sr.No", "", "text", "", "", false, true, columnList);
            for (int i = 0; i < ArraList.size(); i++) {
                String columnname = TypeCastUtility.stringValue(ArraList.get(i).get("columnname"));
                String type = TypeCastUtility.stringValue(ArraList.get(i).get("type"));
                String columnid = TypeCastUtility.stringValue(ArraList.get(i).get("columnid"));
                initializeColumn(columnname, columnid, type, "", "", false, false, columnList);
            }
            if (actionButton) {
                initializeColumn("Action", "action", "buttun", "", "", false, false, columnList);
            }
            resultMap.put("ColumnArray", columnList);
            resultMap.put("title", title);
            resultMap.put("isChecked", isCheckBox);
            System.out.println(ArraList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private static void initializeColumn(String name, String columnid, String type, String htmlclass, String width, Boolean isChechkBox, Boolean isSrNo, List<Map<String, Object>> columnList) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("columnid", columnid);
        map.put("class", htmlclass);
        map.put("type", type);
        map.put("width", width);
        map.put("isSrno", isSrNo);
        if (isChechkBox) {
            List<Map<String, Object>> columnArray = new LinkedList<>();
            columnArray.add(map);
            columnArray.addAll(columnList);
            columnList.clear();
            columnList.addAll(columnArray);
        } else {
            columnList.add(map);
        }
    }

    public static Boolean getBooleanValue(Object value) {

        if (value != null && value != "") {
            return true;
        } else {
            return false;
        }
    }
}
