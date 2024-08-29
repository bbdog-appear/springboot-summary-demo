package com.bbdog.study.springboot.summary.demo.web.v2024.v08.规则引擎.QLExpress;

import com.bbdog.study.springboot.summary.demo.web.SpringbootSummaryDemoWebApplication;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 链接:https://github.com/alibaba/QLExpress
 * 1.不支持try{}catch{}
 * 2.注释目前只支持 /** **，不支持单行注释 //
 * 3.不支持java8的lambda表达式
 * 4.不支持for循环集合操作for(Item item:list)
 * 5.弱类型语言，请不要定义类型声明,更不要用Template（Map<String, List>之类的）
 * 6.array的声明不一样
 * 7.min,max,round,print,println,like,in 都是系统默认函数的关键字，请不要作为变量名
 */
@Slf4j
public class TestQLExpress extends SpringbootSummaryDemoWebApplication {

    @Test
    public void testSimple() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        String express = "a + b + c";
        Object result = runner.execute(express, context, null, true, false);
        System.out.println(result);
    }

    @Test
    public void testSimple2() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        String express = "n = 10;\n" +
                "        sum = 0;\n" +
                "        for (int i = 0; i < n; i++) {\n" +
                "            sum = sum + i;\n" +
                "        }\n" +
                "        return sum;";
        Object result = runner.execute(express, context, null, true, false);
        System.out.println(result);
    }

    @Test
    public void testSimple3() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        String express = "a = 1;\n" +
                "        b = 2;\n" +
                "        maxnum = a > b ? a : b;";
        Object result = runner.execute(express, context, null, true, false);
        System.out.println(result);
    }

    /**
     * java类操作，运行失败
     *
     * @throws Exception 异常
     */
    @Test
    public void testSimple4() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        String express = "import com.bbdog.study.springboot.summary.demo.web.v2024.v08.规则引擎.QLExpress.OrderQuery;" +
                "        import com.bbdog.study.springboot.summary.demo.web.v2024.v08.规则引擎.QLExpress.BizOrderDAO;" +
                "        query = new OrderQuery();\n" +
                "        query.setCreateDate(new Date());\n" +
                "        query.buyer = \"张三\";\n" +
                "        result = bizOrderDAO.query(query);\n" +
                "        System.out.println(result.getId());";
        Object result = runner.execute(express, context, null, true, false);
        System.out.println(result);
    }

    @Test
    public void testSimple5() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addOperator("join", new JoinOperator());
        String express = "1 join 2 join 3";
        Object result = runner.execute(express, context, null, true, false);
        // 返回结果 [1, 2, 3]
        System.out.println(result);
    }

    @Test
    public void testSimple6() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();

        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs", new String[] {"double"}, null);
        runner.addFunctionOfClassMethod("转换为大写", BeanExample.class.getName(), "upper", new String[] {"String"}, null);

        runner.addFunctionOfServiceMethod("打印", System.out, "println", new String[] { "String" }, null);
        runner.addFunctionOfServiceMethod("contains", new BeanExample(), "anyContains", new Class[] {String.class, String.class}, null);

        String express = "取绝对值(-100); 转换为大写(\"hello world\"); 打印(\"你好吗？\"); contains(\"helloworld\",\"aeiou\")";
        Object result = runner.execute(express, context, null, true, false);
        // 返回结果 [1, 2, 3]
        System.out.println(result);
    }

}
