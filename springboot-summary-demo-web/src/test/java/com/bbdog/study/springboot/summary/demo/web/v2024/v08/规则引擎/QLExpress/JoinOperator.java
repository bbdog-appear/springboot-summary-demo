package com.bbdog.study.springboot.summary.demo.web.v2024.v08.规则引擎.QLExpress;

import com.ql.util.express.Operator;

import java.util.ArrayList;
import java.util.List;

public class JoinOperator extends Operator {

    @Override
    public Object executeInner(Object[] list) throws Exception {
        Object opdata1 = list[0];
        Object opdata2 = list[1];
        if (opdata1 instanceof List) {
            ((List)opdata1).add(opdata2);
            return opdata1;
        } else {
            List result = new ArrayList();
            for (Object opdata : list) {
                result.add(opdata);
            }
            return result;
        }
    }

}
