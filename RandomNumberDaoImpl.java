package com.second_hand.dao.impl;

import java.util.UUID;

import com.second_hand.dao.RandomNumberDao;

public class RandomNumberDaoImpl extends RandomNumberDao{
	public String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
//         0 代表前面补充0     
//         4 代表长度为4     
//         d 代表参数为正数型
        return  machineId+ String.format("%010d", hashCodeV);
    }
	
	public String getXiooByUUId() {
		
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        String result=machineId+ String.format("%010d", hashCodeV);
//         0 代表前面补充0     
//         4 代表长度为4     
//         d 代表参数为正数型
        return  result.substring(5);
    }
}
