package com.flow.workflow.entity;

import com.flow.workflow.utils.JsonToMapConverter;
import com.flowforge.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(schema = "absolut", name = "task_definition")
@SQLDelete(sql = "Update task_definition set is_deleted = 1, update_date=NOW(), update_user = 'system' WHERE pk_id = ?")
@FilterDef(name = "is_not_deleted", parameters = @ParamDef(name = "notDeleted", type = Integer.class))
@Filter(name = "isNotDeleted", condition = "is_deleted = 0")
@Data
public class Task extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    Long id;

    @Column(name = "name")
    String taskName;

    @Column(name = "type")
    String taskType;

    @Column(name = "parameters")
    @Convert(converter = JsonToMapConverter.class)
    Map<String, Object> parameters;

    @Column(name = "timeout_seconds")
    Long timeoutSeconds;

}
