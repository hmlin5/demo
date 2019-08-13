package com.hmlin5.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ Author ：linhaomiao
 * @ Date   ：2018-11-07
 * @ Desc   ：
 */
public class MyTest {

    @Test
    public void test(){
        double a = 0.0000000000001;
        double b = 0.0;
        System.out.println("a=b?  "+(a==b));
    }
    @Test
    public void test1(){
      // String[] arr = {"1","2"};
       String[] arr = null;
        for (String s : arr) {
            System.out.println(s);
        }

    }
    @Test
    public void test2(){
        try {
            List<Long> list = new ArrayList<Long>();
            list.add(1l);
            list.add(2l);
            System.out.println(list.toString());
            ObjectMapper om = new ObjectMapper();
            JavaType javaType = om.getTypeFactory().constructParametricType(List.class, Long.class);
            List<Long> list1 = (List<Long>)om.readValue(list.toString(), javaType);
            int i = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test3(){

        Long num = null;
        if (num == null){
            System.out.println("num==null");
        }
    }


    @Test
    public void test4(){
        Map<String, String> map = new HashMap<>();
        map.put("b","123");
        PropertiesUtil.setProperty("D://test.properties",map);
    }

    @Test
    public void test5(){
        String outerCode = "123S01";
        outerCode = outerCode.substring(0,outerCode.indexOf("S"));
        System.out.println(outerCode);
    }
    @Test
    public void test6(){
        String[] strArr = {"1","2"};

        List<String> list = Arrays.asList(strArr);

        boolean contains = list.contains("3");
        System.out.println(contains);

    }


    @Test
    public void test7(){
        try {
           /* String json = "{'v_sex':'1','v_birthday':'1900-01-01','v_phone':'15812345678','v_email':'abc@163.com','v_name':'张xxx','wife':'{\"age\":\"18\"}'}";*/
            String json = "{\"v_sex\":\"1\",\"v_birthday\":\"1900-01-01 02:50:00\",\"v_phone\":\"15812345678\",\"v_email\":\"abc@163.com\",\"v_name\":\"张xxx\"}";
        /*JSONObject user = JSONObject.fromObject(json);
        JSONObject wife = JSONObject.fromObject( user.get("wife"));
        System.out.println(wife.get("age"));*/
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            mapper.setDateFormat(fmt);
            User user = mapper.readValue(json, User.class);

            System.out.println(user.getV_birthday());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void test8(){
        String regex = "^1[3|4|5|6|7|8|9][0-9]{9}$";
       String phone = "1871937117";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
        System.out.println(isMatch);


    }


    @Test
    public void test9(){
        String json = "{\"v_sex\":\"1\",\"v_birthday\":\"1900-01-01 02:50:00\",\"v_phone\":\"15812345678\",\"v_email\":\"abc@163.com\",\"v_name\":\"相见不如怀念&\"}";

        JSONObject object = JSONObject.fromObject(json);
        String v_name = object.optString("v_name");
        System.out.println(v_name);


    }


    @Test
    public void test10(){
        Double saleUnitPrice = 0.0;

        BigDecimal bd1 = new BigDecimal(70.5900);
        BigDecimal bd2 = new BigDecimal(0.0000);
        saleUnitPrice = (bd1.doubleValue()
                - bd2.doubleValue())
                / 1;

        BigDecimal result = new BigDecimal(String.format("%.4f", saleUnitPrice));
        System.out.println(result);
    }
    @Test
    public void test11(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmsss");
        String prefixStr = dateFormat.format(new Date());

        Random rand =new Random();
        int i;
        i=rand.nextInt(9000)+1000;
        System.out.println(prefixStr);
        System.out.println(prefixStr+i+"");
    }


    @Test
    public void test12(){

        String log = "{\"orderSource\":\"339\",\"oriSys\":\"API\",\"receiverName\":\"刘美琪\",\"receiverMobile\":\"15586290653\",\"receiverProvince\":\"河南省\",\"receiverArea\":\"二七区\",\"supplierCode\":\"70230747\",\"receiverCity\":\"郑州市\",\"receiverAddress\":\"河南省郑州市二七区郑州市二七区侯寨乡中原第一城D11排126杜飞\",\"receiverPhone\":\"\",\"saleChannel\":\"yt\",\"outOrderId\":\"S190420155501582672444\",\"orderProductList\":[{\"itemName\":\"蓝月亮薰衣草洁净洗衣液2kg\",\"inventoryType\":\"1\",\"itemQuantity\":1,\"orderItemId\":1,\"itemCode\":\"10000534\",\"warehouseCode\":\"WM10000016\"},{\"itemName\":\"蓝月亮风清白兰手洗专用洗衣液（旅行装）80g\",\"inventoryType\":\"1\",\"itemQuantity\":1,\"orderItemId\":2,\"itemCode\":\"10000711\",\"warehouseCode\":\"WM10000016\"},{\"itemName\":\"蓝月亮薰衣草洁净洗衣液1kg\",\"inventoryType\":\"1\",\"itemQuantity\":2,\"orderItemId\":3,\"itemCode\":\"10000019\",\"warehouseCode\":\"WM10000016\"}]}";

        JSONObject obj = JSONObject.fromObject(log);

        JSONArray jsonArray = obj.optJSONArray("orderProductList");
        String lineCode = getProductCodeByList(jsonArray, "100007111");
        System.out.println(lineCode);


    }


    String getProductCodeByList(JSONArray jsonArray, String code ){
        if(jsonArray == null || jsonArray.size() < 1 || StringUtils.isEmpty(code)){
            return "";
        }
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject obj = (JSONObject)jsonArray.get(i);
            String itemCode = obj.getString("itemCode");
            if (code.equals(itemCode)){
                return obj.getString("orderItemId");
            }
        }
        return "";
    }


    @Test
    public void testIntegerNull(){


/*  Integer a = null;
        Integer b = 1;

        System.out.println(a + b);*/

/*String i = null;
"11".contains(i);*/

        System.out.println("=================="+"11".contains(""));


    }

    @Test
    public void testDouble(){
        Double d =1.11;
        System.out.println(d + "");

        Double dd = null;

        BigDecimal b = new BigDecimal(dd);
        System.out.println("null decimal===" + b);

    }


    @Test
    public void testArrContain(){

        String[] arr = {"1","2"};
        List<String> list = Arrays.asList(arr);

        System.out.println(list.contains("1"));

    }


    @Test
    public void testMapGetNull(){

        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1",5);
        Integer integer = map.get("");
        System.out.println("================"+integer);


    }




}
