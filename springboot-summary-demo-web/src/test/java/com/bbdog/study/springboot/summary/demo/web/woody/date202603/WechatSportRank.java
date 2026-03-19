package com.bbdog.study.springboot.summary.demo.web.woody.date202603;

import com.bbdog.study.springboot.summary.demo.web.v2024.v08.com.spring.Component;
import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 微信运动排行榜
 *
 * @author cheng.wang
 * @version Date：2026/3/19
 */
@Component
public class WechatSportRank {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 更新用户步数
     *
     * @param userId 用户id
     * @param steps 步数
     */
    public void updateSteps(String userId, int steps) {
        String today = LocalDate.now().toString();
        String key = "wechat:steps:" + today;

        redisTemplate.opsForZSet().add(key, userId, steps);

        redisTemplate.expire(key, 7, TimeUnit.DAYS);
    }

    /**
     * 获取排行榜前100名
     *
     * @return 全球排行榜
     */
    public List<RankVO> getGlobalTop100() {
        String today = LocalDate.now().toString();
        String key = "wechat:steps:" + today;

        // 按分数从高到低排序取前100名
        Set<ZSetOperations.TypedTuple<String>> top100 = redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, 99);

        List<RankVO> rankList = new ArrayList<>();
        int rank = 1;
        for (ZSetOperations.TypedTuple<String> tuple : top100) {
            RankVO vo = new RankVO();
            vo.setRank(rank++);
            vo.setUserId(tuple.getValue());
            vo.setSteps(tuple.getScore().intValue());
            rankList.add(vo);
        }
        return rankList;
    }

}

@Data
class RankVO {
    /**
     * 排名
     */
    private int rank;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 步数
     */
    private int steps;
}
