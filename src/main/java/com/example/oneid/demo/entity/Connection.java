package com.example.oneid.demo.entity;

import com.example.oneid.demo.converter.JsonJpaConverter;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
@Audited
@Table(name = "connection")
public class Connection {

    @Id
    @Column(name = "connectionId")
    @GeneratedValue
    private Long id;

    @Column(name = "connectionName")
    private String name;

    @Convert(converter = JsonJpaConverter.class)
    @Column(name = "atmProperty")
    private Object atmProperty;

    @Version
    private Long version;

    @CreatedBy
    @Column(name = "createdBy")
    private String createdBy;

    @CreatedDate
    @Column(name = "createdDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate;

    @Column(name = "modifiedBy")
    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "modifiedDate", columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
