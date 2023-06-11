package com.beanh.msg.plat.support.dao;

import com.beanh.msg.plat.support.domain.SmsRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bean
 * @date 2023/4/22 23:16
 */
public interface SmsRecordDao extends CrudRepository<SmsRecord, Long> {
}
