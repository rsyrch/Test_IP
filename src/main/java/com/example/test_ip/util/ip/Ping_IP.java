package com.example.test_ip.util.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ping_IP {
    //若line含有=18ms TTL=16字样,说明已经ping通,返回1,否則返回0.
    private static int getCheckResult(String line) {  // System.out.println("控制台输出的结果为:"+line);
        Pattern pattern = Pattern.compile("(\\d+ms)(\\s+)(TTL=\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            return 1;
        }
        return 0;
    }

    public static String ping(String ip_address, int ping_umber, int timeout) {
        BufferedReader bufferedReader = null;
        Runtime r = Runtime.getRuntime();
        // ping命令
        String pingCommand = "ping " + ip_address + " -n " + ping_umber    + " -w " + timeout;
        try {   // 执行命令并获取输出
            System.out.println(pingCommand);
            Process p = r.exec(pingCommand);
            if (p == null) {
                return "success";
            }
            bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));   // 逐行检查输出,计算类似出现=23ms TTL=62字样的次数
            int connectedCount = 0;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                connectedCount += getCheckResult(line);
            }
            // 如果出现类似=23ms TTL=62这样的字样,出现的次数=测试次数则返回真
            if(connectedCount == ping_umber)
                return "success";
            else
                return "fail";
        }
        catch (Exception exception) {
            exception.printStackTrace();   // 出现异常则返回假
            return "error";
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
    }
}
