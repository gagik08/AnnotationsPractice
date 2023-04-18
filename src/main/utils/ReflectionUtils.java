package main.utils;

import main.annotations.Column;
import main.annotations.Table;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReflectionUtils {
    public static Map<String, Object> getFilledMap(Object classes) throws IllegalAccessException {
        Class<?> aClass = classes.getClass();
        Map<String,Object> columnNameToMapField = new HashMap<>();
        if (aClass.isAnnotationPresent(Table.class)){
            Table tableAnnotation = aClass.getAnnotation(Table.class);
//            System.out.println("tableAnnotation.value() = " + tableAnnotation.value());
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(Column.class)){
                    Column columnAnnotation = field.getAnnotation(Column.class);
//                    System.out.println("columnAnnotation.value() = " + columnAnnotation.value());
                    field.setAccessible(true);
                    Object obj = field.get(classes);
                    columnNameToMapField.put(columnAnnotation.value(), obj);
                }
            }
        }
        return columnNameToMapField;
    }

    public static String getTableName(Class<?> aClass){
        Table table = null;
        if ((aClass.isAnnotationPresent(Table.class))){
            table = aClass.getAnnotation(Table.class);
        }
        return Objects.requireNonNull((table).value());
    }

    public static void selectData(Object foundModels, Map <String, Object> columnNames, String tableName){
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");
        Class<?> aClass = foundModels.getClass();
        for (Map.Entry <String, Object> e : columnNames.entrySet()) {
            stringBuilder.append((e.getKey())).append(" = " + e.getValue() + ", ");
        }
        String substring = stringBuilder.substring(0,stringBuilder.length() - 2);
        System.out.println(substring);
    }
}


















