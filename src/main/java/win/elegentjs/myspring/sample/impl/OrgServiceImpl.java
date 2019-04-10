package win.elegentjs.myspring.sample.impl;

import win.elegentjs.myspring.sample.OrgService;

public class OrgServiceImpl implements OrgService {

    @Override
    public String get(String id) {
        System.out.println("execute in method get");
        return null;
    }
}
