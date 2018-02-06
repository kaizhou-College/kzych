/*==============================================================*/
/* Database name:  KZYCH                                        */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/2 16:17:50                            */
/*==============================================================*/


drop database if exists KZYCH;

/*==============================================================*/
/* Database: KZYCH                                              */
/*==============================================================*/
create database KZYCH;

use KZYCH;

/*==============================================================*/
/* Table: `KZ_ PACKAGE`                                         */
/*==============================================================*/
create table `KZ_ PACKAGE`
(
   ID                   bigint(20) not null auto_increment,
   UUID                 bigint(20),
   CATEGORYID           bigint(20),
   `STATE`               bigint(4) not null default 1 comment '1,��ʾδʹ�ã�2-��ʾ��ʹ�ã�3-��ʾ����',
   MONEY                int not null,
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;


/*==============================================================*/
/* Table: KZ_CHANNEL                                            */
/*==============================================================*/
create table `KZ_CHANNEL`
(
   ID                   bigint(20) not null auto_increment,
   NAME                 varchar(30) not null,
   LINK                 varchar(50) not null,
   KEYWORD              varchar(50),
   DESCRIPTION          text,
   ISDELETE             int not null default 0 comment '0:��ʾδɾ����1:��ʾ��ɾ��',
   CREATETIME           datetime not null,
   `UPDATE`              datetime,
   PARENTID             bigint(20),
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_CONTENT                                            */
/*==============================================================*/
create table `KZ_CONTENT`
(
   ID                   bigint(20) not null,
   CHANNELID            bigint(20),
   TITLE                varchar(50),
   CONTENT              text,
   AUTHOR               text(20),
   KEYWORD              text,
   PUBLISHDATE          datetime,
   IMG                  varchar(30),
   HIT                  bigint(30),
   `IS`                 int  comment '0����ʾ���ö���1����ʾ�ö�',
   ISCOMMENT            int comment '0����1����',
   COMEFROM             varchar(30),
   STATICURL            text,
   SOURCEURL            text,
   ISDELETE             int comment '0��δɾ����1����ɾ��',
   STATUS               int,
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_MAJOR                                              */
/*==============================================================*/
create table `KZ_MAJOR`
(
   ID                   bigint(20) not null auto_increment,
   MAJOR_CATEGORY_ID    bigint(20),
   NAME                 varchar(50) not null,
   MAJOR_CODE           varchar(50) not null,
   ISHOT                int not null default 2 comment '����רҵ��1��ʾ����  2,��ʾ������',
   DESCRIPTION          text not null,
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;



/*==============================================================*/
/* Table: KZ_MAJOR_CATEGORY                                     */
/*==============================================================*/
create table `KZ_MAJOR_CATEGORY`
(
   MAJOR_CATEGORY_ID    bigint(20) not null auto_increment,
   MAJOR_CATEGORY_NAME  varchar(30),
   CATEGORY_PARENT_ID   int,
   primary key (MAJOR_CATEGORY_ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_ORDER                                              */
/*==============================================================*/
create table `KZ_ORDER`
(
   ID                   bigint(20) not null auto_increment,
   UUID                 bigint(20),
   PAYMENT              decimal(20,2) comment 'ʵ�ʸ�����,��λ��Ԫ,������λС��',
   STATUS               int(10) comment '����״̬:0-��ȡ��-10-δ���20-�Ѹ��',
   PAYMENT_TYPE         int(4) comment '֧������,1-����֧��,2-֧����,3-΢��֧��',
   CREATE_TIME          datetime,
   UPDATE_TIME          datetime,
   END_TIME             datetime,
   CLOSE_TIME           datetime,
   PLAYMENT_TIME        datetime,
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_ORDERDETAIL                                        */
/*==============================================================*/
create table `KZ_ORDERDETAIL`
(
   ID                   bigint(20) not null auto_increment,
   ORDERID              bigint(20),
   UNIVERSITY_ID        bigint(20),
   COST                 decimal(20,2),
   VOUCHER              decimal(20,2) comment '0��δʹ�ã�1��ʹ��',
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_PACKAGE_CATEGORY                                   */
/*==============================================================*/
create table `KZ_PACKAGE_CATEGORY`
(
   ID                   bigint(20) not null auto_increment,
   NAME                 varchar(30),
   DESCRIPTION          text,
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;


/*==============================================================*/
/* Table: KZ_PAY_INFO                                           */
/*==============================================================*/
create table `KZ_PAY_INFO`
(
   ID                   bigint(11) not null auto_increment,
   USER_ID              bigint(20) not null,
   ORDER_ID             bigint(20) not null,
   PAY_PLATFORM         int(10) comment '֧��ƽ̨:1-֧����,2-΢��',
   PLATFORM_NUMBER      varchar(200) comment '֧����֧����ˮ��',
   PLATFORM_STATUS      varchar(20) comment '֧����֧��״̬',
   CREATE_TIME          datetime,
   UPDATE_TIME          datetime,
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_UNIVERSITY                                         */
/*==============================================================*/
create table `KZ_UNIVERSITY`
(
   ID                   bigint(20) not null auto_increment,
   NAME                 text not null,
   ADDRESS              text not null,
   CODE                 bigint(30) not null,
   PROFILE              varchar(50) not null,
   EMPLOYMENT_INFO      text not null,
   BROCHURE             text not null,
   AGREEMENTS           varchar(100) not null,
   TELEPHONE            varchar(20) not null,
   INTRODUCTION         text not null,
   GRANTS               decimal(20,2) not null,
   VOUCHER              decimal(20,2) not null,
   CATEGORYID           bigint(20) comment '1-���ƣ�2-��ƣ�3-��ר��4-��ѵѧУ',
   PUBLISH_STATUS       int comment '0-�ѷ�����1-δ����',
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_UNIVERSITY_CATEGORY                                */
/*==============================================================*/
create table `KZ_UNIVERSITY_CATEGORY`
(
   ID                   bigint(20) not null auto_increment,
   CATEGORY_NAME        varchar(30),
   CATEGORY_INFO        varchar(50),
   PARENTID             int,
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_UNIVERSITY_MAJOR                                   */
/*==============================================================*/
create table `KZ_UNIVERSITY_MAJOR`
(
   ID                   bigint(20) not null auto_increment,
   UNIVERSITY_ID        bigint(20),
   MAJOR_ID             bigint(20),
   COST                 decimal(20,2) not null,
   MAJOR_MESSAGE        text not null,
   COST_CUSTRUCT        text not null,
   JOB_INFO             text not null,
   primary key (ID)
)
ENGINE = InnoDB
charset = UTF8;

/*==============================================================*/
/* Table: KZ_USER                                               */
/*==============================================================*/
create table `KZ_USER`
(
   UUID                 bigint(20) not null auto_increment,
   USERNAME             varchar(30),
   PASSWORD             varchar(30),
   CELLPHONE            varchar(20),
   SEX                  varchar(4),
   IDCARD               varchar(20),
   ORIGIN_PLACE         varchar(20),
   SCHOOL               varchar(30),
   SIGN_MESSAGE         varchar(100),
   PROFILE              varchar(100),
   USER_TYPE            int,
   CREATE_TIME          datetime,
   LASTLOGIN_TIME       datetime,
   primary key (UUID)
)
ENGINE = InnoDB
charset = UTF8;

alter table `KZ_ PACKAGE` add constraint FK_REFERENCE_6 foreign key (UUID)
      references KZ_USER (UUID) on delete restrict on update restrict;

alter table `KZ_ PACKAGE` add constraint FK_REFERENCE_7 foreign key (CATEGORYID)
      references KZ_PACKAGE_CATEGORY (ID) on delete restrict on update restrict;

alter table KZ_CONTENT add constraint FK_REFERENCE_8 foreign key (CHANNELID)
      references KZ_CHANNEL (ID) on delete restrict on update restrict;

alter table KZ_MAJOR add constraint FK_REFERENCE_11 foreign key (MAJOR_CATEGORY_ID)
      references KZ_MAJOR_CATEGORY (MAJOR_CATEGORY_ID) on delete restrict on update restrict;

alter table KZ_ORDER add constraint FK_REFERENCE_3 foreign key (UUID)
      references KZ_USER (UUID) on delete restrict on update restrict;

alter table KZ_ORDERDETAIL add constraint FK_REFERENCE_4 foreign key (ORDERID)
      references KZ_ORDER (ID) on delete restrict on update restrict;

alter table KZ_ORDERDETAIL add constraint FK_REFERENCE_5 foreign key (UNIVERSITY_ID)
      references KZ_UNIVERSITY (ID) on delete restrict on update restrict;

alter table KZ_PAY_INFO add constraint FK_REFERENCE_9 foreign key (USER_ID)
      references KZ_ORDER (ID) on delete restrict on update restrict;

alter table KZ_UNIVERSITY add constraint FK_REFERENCE_10 foreign key (CATEGORYID)
      references KZ_UNIVERSITY_CATEGORY (ID) on delete restrict on update restrict;

alter table KZ_UNIVERSITY_MAJOR add constraint FK_REFERENCE_1 foreign key (UNIVERSITY_ID)
      references KZ_UNIVERSITY (ID) on delete restrict on update restrict;

alter table KZ_UNIVERSITY_MAJOR add constraint FK_REFERENCE_2 foreign key (MAJOR_ID)
      references KZ_MAJOR (ID) on delete restrict on update restrict;
	  
--user���ϵ�name�ֶν���Ψһ����
 alter table kz_user add unique(`username`);	  

