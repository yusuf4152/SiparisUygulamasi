package org.yusufislamdemir.service;

import org.yusufislamdemir.entity.BaseInterface;

import java.util.List;

public interface BaseService {
     void add(BaseInterface baseInterface);
     List<String> getAll();
}
