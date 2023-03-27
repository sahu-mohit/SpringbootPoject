package demo.Service;

import demo.Entity.CommonTable;
import demo.Entity.StudentEntity;
import demo.Entity.UserEntity;
import demo.JavaClassesForAll.StudentRepo;
import demo.JavaClassesForAll.TypeCastUtility;
import demo.Repository.CommonTableRepo;
import demo.Repository.UserEntityRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    CommonTableRepo commonTableRepo;
    @Autowired
    UserEntityRepo userEntityRepo;
    @Autowired
    StudentRepo studentRepo;

    @Override
    public ResponseEntity<String> createTableView(Map<String, Object> param, HttpServletRequest request) throws JSONException {
        Integer rowCount = TypeCastUtility.integerValue(param.get("noofrow"));
        String mvc = TypeCastUtility.stringValue(param.get("mvcurl"));
        String rest = TypeCastUtility.stringValue(param.get("resturl"));
        String title  = TypeCastUtility.stringValue(param.get("title"));
        String tablename = TypeCastUtility.stringValue(param.get("tableviewname"));
        Boolean editbutton = TypeCastUtility.getBooleanValue(param.get("edit"));
        Boolean deletebutton = TypeCastUtility.getBooleanValue(param.get("delete"));
        Boolean actionButton = TypeCastUtility.getBooleanValue(param.get("actionbutton"));
        Boolean isCheckbox = TypeCastUtility.getBooleanValue(param.get("isCheckbox"));
        CommonTable tablekey =  commonTableRepo.findByTablename(tablename);
        if(tablekey != null)
        {
            return ResponseEntity.ok("Choose another name ");
        }
        List<JSONObject> columnArray = new LinkedList<>();
        JSONObject tableviewJson = new JSONObject();
        for(int i = 0; i < rowCount; i++)
        {
            JSONObject columnJsonArray = new JSONObject();
            columnJsonArray.put("columnid",TypeCastUtility.stringValue(param.get("columnid_"+i)));
            columnJsonArray.put("columnname",TypeCastUtility.stringValue(param.get("columnname_"+i)));
            columnJsonArray.put("columntype",TypeCastUtility.stringValue(param.get("columntype_"+i)));
            columnArray.add(columnJsonArray);
        }
        tableviewJson.put("tilte",title);
        tableviewJson.put("columnArray",columnArray);
        tableviewJson.put("MVCApi",mvc);
        tableviewJson.put("RestApi",rest);
        if(isCheckbox){
            tableviewJson.put("isCheckbox",isCheckbox);
        }
        if(actionButton)
        {
            tableviewJson.put("actionButton",true);
            if(deletebutton){
                tableviewJson.put("deleteButton",deletebutton);
            }
            if(editbutton){
                tableviewJson.put("editButton",editbutton);
            }
        }
        else{
            tableviewJson.put("actionButton",false);
        }

        CommonTable tableview = new CommonTable();
        tableview.setTablename(tablename);
        tableview.setTablejson(""+tableviewJson);
        commonTableRepo.save(tableview);
        CommonTable obj = commonTableRepo.findByTablename(tablename);
        String json = obj.getTablejson();
        return ResponseEntity.ok(""+tableviewJson);
    }

    @Override
    public ResponseEntity<String> getKey(Map<String, Object> param, HttpServletRequest request) {
        CommonTable tablekey =  commonTableRepo.findByTablename(TypeCastUtility.stringValue(param.get("key")));
        if(tablekey != null)
        {
            return ResponseEntity.ok("Choose another name of table");
        }
        return null;
    }

    @Override
    public Object getTableView(Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) throws JSONException {
//        CommonTable obj = commonTableRepo.findByTablename("tableview");
        CommonTable obj = commonTableRepo.findByTablename("userview");
        String json = obj.getTablejson();
        List<Object> data_array = new LinkedList<>();
        HashMap<String, Object> resultMap = new HashMap<>();
        TypeCastUtility.setColumnArray(json,resultMap);
        List<UserEntity> user = userEntityRepo.findAll();
//        List<CommonTable> tableview = commonTableRepo.findAll();

        if(user.size()>0)
        {
            user.forEach(data->{
                Long id = data.getId();
//                String check = "<input class='form-check-input' type='checkbox' name='isCheckbox' id="+id+">";
                Map<String,Object> map = new HashMap<>();
                map.put("name",data.getName());
//                map.put("name",check);
                map.put("email",data.getEmailid());
                map.put("address","address");
                map.put("password",data.getPassword());
                data_array.add(map);
            });
        }

//        if(tableview.size()>0)
//        {
//            tableview.forEach(data->{
//                Map<String,Object> map = new HashMap<>();
//                map.put("id",data.getId());
//                String check = "<input class='form-check-input' type='checkbox' name='isCheckbox' id='isCheckbox'>";
//                map.put("tablename",data.getTablename());
//                map.put("ischeckbox",check);
//                map.put("tablejson",data.getTablejson());
////                map.put("email",data.getEmail());
////                map.put("address",data.getAddress());
////                map.put("number",data.getNumber());
////                map.put("class",data.getClassname());
////                map.put("section",data.getSection());
//                data_array.add(map);
//            });
//        }
//        resultMap.put("column_array",json);
        resultMap.put("data_array",data_array);
        return resultMap;
    }
}



