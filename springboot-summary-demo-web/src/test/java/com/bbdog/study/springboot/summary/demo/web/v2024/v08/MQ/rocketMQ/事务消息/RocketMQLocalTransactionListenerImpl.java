package com.bbdog.study.springboot.summary.demo.web.v2024.v08.MQ.rocketMQ.事务消息;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

@RocketMQTransactionListener
public class RocketMQLocalTransactionListenerImpl implements RocketMQLocalTransactionListener {

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        // TODO 执行本地事务（书写你自己的本地事务逻辑）
        try{
            String body = message.getPayload().toString();
            int i = Integer.parseInt(body);
            // 模拟偶数执行成功，奇数执行失败
            if(i % 2 == 0){
                System.out.println("本地事务执行成功："+body);
                // 执行成功
                return RocketMQLocalTransactionState.COMMIT;
            }else{
                System.out.println("本地事务执行失败："+body);
                // 执行失败
                return RocketMQLocalTransactionState.ROLLBACK;
            }

        } catch (Exception e) {
            e.printStackTrace();
            // 执行失败
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        // TODO 去缓存或者数据库查询当前消息的实际状态

        // 模拟查询到状态为1
        Integer status = 1;

        // 不同实际状态对应的消息状态
        if (null != status) {
            switch (status) {
                case 1:
                    return RocketMQLocalTransactionState.COMMIT;
                case 2:
                    return RocketMQLocalTransactionState.ROLLBACK;
                default:
                    return RocketMQLocalTransactionState.COMMIT;
            }
        }
        return RocketMQLocalTransactionState.COMMIT;
    }

}
