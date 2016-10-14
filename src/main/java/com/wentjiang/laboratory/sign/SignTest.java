package com.wentjiang.laboratory.sign;

/**
 * Created by jiangwentao on 9/30/2016.
 */
public class SignTest {
//    public static void main(String[] args) {
//
//
//        HttpClient httpClient = new HttpClient();
//        PostMethod httpMethod = new PostMethod("http://127.0.0.1:8115/comment/save");
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("appId","5");
//        map.put("contentId","100");
//        map.put("fromUserId","100");
//        map.put("fromNickname","nickname");
//        map.put("toUserId","200");
//        map.put("toNickname","tonickname");
//        map.put("content","content");
//        map.put("ip","127.0.0.2");
//        map.put("city","beijing");
//        map.put("device","mobel?");
//        map.put("desc","desc");
//        map.put("timestamp","2016");
//
//        if (map != null){
//            for (Map.Entry<String,Object> entry: map.entrySet()){
//                httpMethod.setParameter(entry.getKey(), String.valueOf(entry.getValue()));
//            }
//        }
//        httpMethod.setParameter("sign",getSign(map));
//        try {
//            int num = httpClient.executeMethod(httpMethod);
//            System.out.println(num);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String getSign(Map srcMap){
//        Map<String, String[]> desMap = new TreeMap<String, String[]>(srcMap);
//        StringBuilder desSb = new StringBuilder();
//        int i = 0;
//        for (Map.Entry<String, String[]> entry : desMap.entrySet()) {
//            if (!entry.getKey().equals("sign")) {
//                if (i > 0) {
//                    desSb.append("&");
//                }
//                // 默认每个参数名只有一个值，如果为数组，则需要修改这里的值的拼接，遍历所有值来拼接
//                desSb.append(entry.getKey()).append("=").append(entry.getValue());
//                i++;
//            }
//        }
//        String calcSign = EncryptUtils.saltSHA256("", desSb.toString());
//        return calcSign;
//    }
}
