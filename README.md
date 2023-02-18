## service introduction

1.report service:service as publisher to provide latest weather info to rabbit every minute

2.client service:service as subscriber to listen rabbit msg and log data

## source part

SpringBoot+MyBatis+MySql+Rabbit

```sql
-- ----------------------------
-- Table structure for `w_latest_data`
-- ----------------------------
DROP TABLE IF EXISTS `w_latest_data`;
create table w_latest_data
(
    id          int auto_increment,
    city_code   varchar(6)                          null,
    temperature float                               null,
    humidity    float                               null,
    pressure    float                               null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    constraint w_latest_data_id_uindex
        unique (id)
);

alter table weather.w_latest_data
    add primary key (id);


