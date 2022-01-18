package com.example.test_ip.service.impl;

import com.example.test_ip.service.IpService;
import com.example.test_ip.util.ip.Ping_IP;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class IpServiceImpl implements IpService {
    @Override
    public Map<String, String> ping_value(Map<String, Object> ipMapParam) {
        int IP_Array[] = new int[8];
        int IP_Number = 0;
        for(Object object : ipMapParam.values()){
            IP_Array[IP_Number] = Integer.parseInt(object.toString());
            System.out.print(IP_Array[IP_Number]);
            IP_Number++;
        }
        Map IP_Map = new HashMap<String, String>();
        for(int a = IP_Array[0]; a <= IP_Array[1]; a++)
            for(int b = IP_Array[2]; b <= IP_Array[3]; b++)
                for(int c = IP_Array[4]; c <= IP_Array[5]; c++)
                    for(int d = IP_Array[6]; d <= IP_Array[7]; d++) {
                        // 生成ping的IP
                        String ip = String.valueOf(a) + "." + String.valueOf(b) + "." + String.valueOf(c) + "." + String.valueOf(d);
                        System.out.println("-------------------"+ip+"---------------------");
                        IP_Map.put(ip, Ping_IP.ping(ip, 1, 1000));
                    }
        return IP_Map;
    }
}
