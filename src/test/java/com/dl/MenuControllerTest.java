package com.dl;

import com.dl.util.JsonUtil;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class MenuControllerTest {

    public List testMenuMock() {
        try {
            String json = JsonUtil.getFromJson("mock/menu.json");
            return JsonUtil.parseJson(json, List.class);
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
