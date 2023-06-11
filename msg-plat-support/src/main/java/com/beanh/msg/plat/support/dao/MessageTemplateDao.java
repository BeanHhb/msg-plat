package com.beanh.msg.plat.support.dao;

import com.beanh.msg.plat.support.domain.MessageTemplate;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bean
 * @date 2023/4/22 23:17
 */
public interface MessageTemplateDao extends CrudRepository<MessageTemplate, Long> {
}
