package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.example.demo.dao.DemoMapper;
import com.example.demo.service.DemoService;
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Map> getUserInfo() {
    	List<Map> result = null;
    	Transaction t = Cat.newTransaction(CatConstants.TYPE_URL, "com.example.demo.service.impl.DemoServiceImpl.getUserInfo()");
    	try {
    	    Cat.logEvent("URL.Server", "serverIp", Event.SUCCESS, "ip=10.16.163.126");
    	    Cat.logMetricForCount("SERVICE_COUNT");
    		result = demoMapper.queryUser();
    		t.setStatus(Transaction.SUCCESS);
    	} catch (Exception e) {
    		t.setStatus(e);
    	    Cat.logError(e);
		} finally {
			t.complete();
		}
        return result;
    }
}
