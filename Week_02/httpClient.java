package java0.nio01.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class httpClient {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        //創建get請求
        HttpGet get = new HttpGet("http://localhost:8800");
        CloseableHttpResponse execute = aDefault.execute(get);
        if(execute.getStatusLine().getStatusCode()==200) {
            String string = EntityUtils.toString(execute.getEntity());
            System.out.println(string);
        }
        //关闭连接
        if(execute!=null) {
            execute.close();
        }
        //关闭连接
        if(aDefault!=null) {
            aDefault.close();
        }
    }
}
