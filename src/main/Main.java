package main;

import main.models.Profile;
import main.models.User;
import main.utils.ReflectionUtils;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Profile profile = new Profile(1,"Gagik", "BIO", 21);
        User user = new User(1,"Robert");
        Set<Object> models = Set.of(user, profile);
        System.out.println(models);

        for (Object o : models) {
            Map<String,Object> columnNames = ReflectionUtils.getFilledMap(o);
            String tableNames = ReflectionUtils.getTableName(o.getClass());
            ReflectionUtils.selectData(models, columnNames,tableNames);
        }

    }
}
