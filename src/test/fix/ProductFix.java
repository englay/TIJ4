package test.fix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * 
 * 
 * @author wb-dingyudong
 * 
 */
public class ProductFix {

    /**
     * 解析文件,生成取消上门服务的URL集合
     * 第一列必需有titile的
     * 必需保证分销商ID是以'distributorId'开头。以';'分隔的前提。
     * 必需上门服务数量是以'pcInsuranceNumDealer'开头。以';'分隔的前提。
     * 
     * 第一个是产品ID。第二个分销商ID
     * Example:
       product_id,dimens,content
       "315223657353",";distributorId:3120168;",";buyNumDealer:109;pcInsuranceNumDealer:0;"
       "315223657353",";distributorId:3528244;",";buyNumDealer:77;pcInsuranceNumDealer:0;"
       "315223657353",";distributorId:637228;",";buyNumDealer:509;pcInsuranceNumDealer:0;"
       "315223657353",";distributorId:3118454;",";buyNumDealer:265;pcInsuranceNumDealer:0;"
       "315223657353",";distributorId:3959158;",";buyNumDealer:49;pcInsuranceNumDealer:0;"
     * 
     * 数据通过下面这个sql采集
     * select product_id ,dimens, content from bbc_product_extend_7250 where product_id = *** and content like '%pcInsuranceNumDealer%'
     * @param in
     * @return
     * @throws IOException
     */
    public static List<String> generateURLList(BufferedReader in) throws IOException {
        String line;
        String url;
        List<String> list = new ArrayList<String>();
        int product_id_index = -1;
        while ((line = in.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                char shuangyinhao = '"';
                char blank = ' ';
                line = line.replace(shuangyinhao,blank);
                line = deleteWhitespace(line);
                
                if(line.contains("product_id")){
                    //分析title得到title的列表，得到prodcut_id的下标
                    product_id_index = Arrays.asList(line.split(",")).indexOf("product_id");
                } else if(product_id_index != -1) {
                    url = "http://42.120.80.155/goodsplatform/service/baseFix?name=productExtFix&line=tradePc,产品ID,分销商ID,0,数量";
                    String[] idArray = line.split(",");
                    url = url.replace("产品ID", idArray[product_id_index].trim()); 
                    
                    String[] numArray = line.split(";");
                    for (String numString : numArray) {
                        if (numString.contains("pcInsuranceNumDealer")) {
                            //上门服务数量是以'pcInsuranceNumDealer'开头。以';'分隔的前提。
                            String number = numString.substring(numString.indexOf(":") + 1).trim();
                            if (!number.equals("0")) {
                                url = url.replace("数量", "-" + number);
                                //只有数量大于0的才取消上门。
                                list.add(url);
                           }
                        } else if (numString.contains("distributorId")) {
                            //分销商ID是以'distributorId'开头。以';'分隔的前提。
                            url = url.replace("分销商ID", numString.substring(numString.indexOf(":") + 1)).trim();
                        }
                    }
                 //   System.out.println(url);
                }
               
            }
        }
        return list;
    }
    

    public static void main(String[] args) {
        try {
            //创建一个客户端。比较耗时
            Client client = Client.create();
            
            //读文件。
            BufferedReader in = new BufferedReader(new FileReader("D:/1.txt"));
            //生成解析后的url集合
            List<String> urlList = generateURLList(in);
            in.close();
            if(urlList != null && !urlList.isEmpty() ){
                int i = 0;
                for (String url : urlList) {
                    System.out.println("====No: "+ (i+1) +"  =========");
                    System.out.println("URL: "+ url);
                    // URL没错后。把下面的注释移开，发送请求
                    // sendARequest(client, url);
                    i++;
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendARequest(Client client, String url) {
        try {
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource.get(ClientResponse.class);

            if (response.getStatus() != 200) {
                System.out.println("Failed : HTTP error code : " + response.getStatus());
            } 
                String output = response.getEntity(String.class);
                System.out.print("Output from Server .... \n");
                System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public static String deleteWhitespace(String str) {
        if (str == null) {
            return null;
        }

        int sz = str.length();
        StringBuilder buffer = new StringBuilder(sz);

        for (int i = 0; i < sz; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                buffer.append(str.charAt(i));
            }
        }

        return buffer.toString();
    }

}
