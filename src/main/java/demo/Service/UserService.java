package demo.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> createTableView(Map<String, Object> param, HttpServletRequest request) throws JSONException;

    ResponseEntity<String> getKey(Map<String, Object> param, HttpServletRequest request);

    Object getTableView(Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) throws JSONException;
}
