package test;

import java.util.Map;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1%20);
		
		String jsonStr =  "{ "
				+ "                    \"jsonType\": \"dns-service\", "
				+ "                    \"splitdns\":false, "
				+ "                    \"internalDns1\":{ "
				+ "                        \"jsonType\": \"ip-object\", "
				+ "                        \"addressType\":\"IP_ADDRESS\", "
				+ "                        \"entries\":[ { "
				+ "                            \"addressInfo1\":\"10.10.10.10\", "
				+ "                            \"tags\":[{ "
				+ "                                \"jsonType\": \"device\", "
				+ "                                \"value\":\"tag1\", "
				+ "                                \"ownerId\":102 "
				+ "                            }], "
				+ "                            \"ownerId\":102 "
				+ "                        }], "
				+ "                        \"name\":\"10.10.10.10\", "
				+ "                        \"predefined\":false, "
				+ "                        \"ownerId\":102 "
				+ "                    }, "
				+ "                    \"internalDns2\":{ "
				+ "                        \"jsonType\": \"ip-object\", "
				+ "                        \"addressType\":\"IP_ADDRESS\", "
				+ "                        \"entries\":[{ "
				+ "                            \"addressInfo1\":\"8.8.8.8\", "
				+ "                            \"tags\":[{ "
				+ "                                \"jsonType\": \"location\", "
				+ "                                \"value\":\"tag1\", "
				+ "                                \"ownerId\":102}], "
				+ "                            \"ownerId\":102 "
				+ "                        }], "
				+ "                        \"name\":\"8.8.8.8\", "
				+ "                        \"predefined\":false, "
				+ "                        \"ownerId\":102 "
				+ "                    }, "
				+ "                    \"internalDns3\":{ "
				+ "                        \"jsonType\": \"ip-object\", "
				+ "                        \"addressType\":\"IP_ADDRESS\", "
				+ "                        \"entries\":[{ "
				+ "                            \"addressInfo1\":\"8.8.4.4\", "
				+ "                            \"tags\":[{ "
				+ "                                \"jsonType\": \"global\", "
				+ "                                \"value\":\"tag1\", "
				+ "                                \"ownerId\":102}], "
				+ "                            \"ownerId\":102 "
				+ "                        }], "
				+ "                        \"name\":\"8.8.4.4\", "
				+ "                        \"predefined\":false, "
				+ "                        \"ownerId\":102 "
				+ "                    }, "
				+ "                    \"domainObject\":{ "
				+ "                        \"objName\":\"unit-tests-102611.aerohive.local\", "
				+ "                        \"objType\":\"CLASSIFICATION_POLICY\", "
				+ "                        \"items\":[{ "
				+ "                            \"domainName\":\"unit-tests-102611.aerohive.local\", "
				+ "                            \"ownerId\":102 "
				+ "                        }], "
				+ "                        \"ownerId\":102 "
				+ "                    }, "
				+ "                    \"dnsSpecificInfos\":[], "
				+ "                    \"name\":\"unit-test-579219-dns-profile\", "
				+ "                    \"description\":\"fake-dns-profile\", "
				+ "                    \"ownerId\":102 "
				+ "                }";
		JSONObject jsonObject = new JSONObject();
        // 输出jsonobject对象
        System.out.println("jsonObject：" + jsonObject);

        // 判读输出对象的类型
        boolean isArray = jsonObject.isArray();
        boolean isEmpty = jsonObject.isEmpty();
        boolean isNullObject = jsonObject.isNullObject();
        System.out.println("是否为数组:" + isArray + "， 是否为空:" + isEmpty
                + "， isNullObject:" + isNullObject);
        
        JSONObject object = JSONObject.fromObject(jsonStr);
        
        System.out.println(object);
        
        Gson gson = new Gson();
        

	}

}
