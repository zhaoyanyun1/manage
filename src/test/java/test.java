import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class test {


    public static void main(String[] args) {

        try {
            sendMsg();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static String sendMsg() throws BiffException {
        File file = new File("C:\\Users\\zyyy\\Desktop\\短信测试统计.xls");
        readExcel(file);
        return null;
    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static void readExcel(File file) throws BiffException {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                // 每个页签创建一个Sheet对象
                jxl.Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    Map map = new HashMap();
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        if (i != 0 && j != 0 && j != 3) {
                            String cellinfo = sheet.getCell(j, i).getContents();
//                            System.out.println(cellinfo);
                            if (j == 1) {
                                map.put("name", cellinfo);
                            } else if (j == 2) {
                                map.put("phone", cellinfo);
                            }
                        }
                    }

                    if (map != null && map.size() > 0) {
                        System.out.println(map.get("name").toString() + "-" + map.get("phone").toString());
                        postHttp(map.get("name").toString(), map.get("phone").toString());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * post方式
     *
     * @return
     */
    public static String postHttp(String name, String phone) {
        String responseMsg = "";
        //1.构造HttpClient的实例
        HttpClient httpClient = new HttpClient();

        httpClient.getParams().setContentCharset("utf-8");

        String url = "http://120.55.197.77:1210/Services/MsgSend.asmx/SendMsg";

        //2.构造PostMethod的实例
        PostMethod postMethod = new PostMethod(url);

        //3.把参数值放入到PostMethod对象中
        NameValuePair[] data = {new NameValuePair("userCode", "ztxcf"), new NameValuePair("userPass", "QV2Q!pcqy9"), new NameValuePair("DesNo", phone), new NameValuePair("Msg", name + "马上就是您的到期还款日了，请抽空处理下您的账单。【留客信息】"), new NameValuePair("Channel", "999")};
        postMethod.setRequestBody(data);


        try {
            // 4.执行postMethod,调用http接口
            httpClient.executeMethod(postMethod);//200

            responseMsg = postMethod.getResponseBodyAsString().trim();
            System.out.println(responseMsg);
//            log.info(responseMsg);

            //6.处理返回的内容

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.释放连接
            postMethod.releaseConnection();
        }
        return responseMsg;
    }
}
